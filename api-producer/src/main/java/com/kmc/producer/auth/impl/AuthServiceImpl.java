package com.kmc.producer.auth.impl;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kmc.common.auth.base.BaseUser;
import com.kmc.common.auth.base.BaseVo;
import com.kmc.common.auth.validator.dto.Credence;
import com.kmc.common.utils.Md5Util;
import com.kmc.producer.auth.IAuthService;
import com.kmc.producer.auth.config.JwtProperties;
import com.kmc.producer.modules.mapper.SysUserMapper;
import com.kmc.producer.modules.model.entity.SysUser;
import com.kmc.producer.redis.IRedisService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 武海升
 * @date 2018/11/2 10:42
 */
@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private SysUserMapper userMapper;

    @Value("${specialValidator.enable}")
    private boolean enableValidator;

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private IRedisService redisService;

    /**
     * 获取jwt失效时间
     */
    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token).getExpiration();
    }

    /**
     * 获取jwt的payload部分
     */
    public Claims getClaimFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtProperties.getSecret())
                .parseClaimsJws(token)
                .getBody();
    }

    @Override
    public String getAccessToken(String uniqueCredence) {
        Map<String, Object> claims = new HashMap<>(1);
        claims.put(jwtProperties.getMd5Key(), RandomUtil.randomString(jwtProperties.getRandomCount()));
        return doGenerateToken(claims, uniqueCredence);
    }

    @Override
    public String getSign(Credence credence) {
        String json = JSON.toJSONString(
                BaseUser.builder()
                        .userType(credence.getUserType())
                        .mobile(credence.getCredenceUniqueName())
                        .password(credence.getCredenceCode())
                        .build()
        );
        return Md5Util.encrypt(json+RandomUtil.randomString(jwtProperties.getRandomCount()));
    }

    @Override
    public Boolean isTokenExpired(String accessToken) {
        try {
            final Date expiration = getExpirationDateFromToken(accessToken);
            return expiration.before(new Date());
        } catch (ExpiredJwtException expiredJwtException) {
            return true;
        }
    }

    @Override
    public Boolean isSignExpired(String sign) {
        return null;
    }

    @Override
    public boolean validate(Credence credence) {
        boolean flag;
        flag = enableValidator && ("666".equals(credence.getCredenceUniqueName()) && "888".equals(credence.getCredenceCode()));
        //是否开启特殊验证
        if (flag) {
            return true;
        } else {
            SysUser sysUser = null;
            if(1==credence.getUserType()){
                sysUser = userMapper.selectUserByMobile(credence.getCredenceUniqueName());
            }
            return sysUser==null?false:true;
        }
    }

    @Override
    public BaseVo getSecurityInfo(Credence authRequest) {
        BaseVo baseVo = new BaseVo();
        boolean validate = validate(authRequest);
        if (validate) {
            final String token = getAccessToken(authRequest.getCredenceUniqueName());
            final String sign = getSign(authRequest);
            final Long expiration = jwtProperties.getExpiration();
            redisService.addToRedis(authRequest.getCredenceUniqueName()+"_SIGN",sign,expiration);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("token",token);
            jsonObject.put("sign",sign);
            jsonObject.put("expiration",expiration);
            baseVo.setSuccessResult(100002,jsonObject);
            return baseVo;
        } else {
            baseVo.setResult(100001);
            return baseVo;
        }
    }

    /**
     * 生成token
     */
    private String doGenerateToken(Map<String, Object> claims, String subject) {

        final Date createdDate = new Date();
        final Date expirationDate = new Date(createdDate.getTime() + jwtProperties.getExpiration() * 1000);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret())
                .compact();
    }

}
