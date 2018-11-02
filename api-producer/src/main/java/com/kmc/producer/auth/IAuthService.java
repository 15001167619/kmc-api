package com.kmc.producer.auth;

import com.kmc.common.auth.base.BaseVo;
import com.kmc.common.auth.validator.dto.Credence;

/**
 * @author 武海升
 * @date 2018/11/2 10:30
 */
public interface IAuthService {

    /**
     * 获取 AccessToken
     *
     * @param uniqueCredence 唯一凭证(手机号)
     * @return accessToken
     */
    String getAccessToken(String uniqueCredence);
    /**
     * 获取 服务器端签名
     *
     * @param credence 用户参数
     * @return accessToken
     */
    String getSign(Credence credence);

    /**
     * 校验 Token 是否过期
     *
     * @param accessToken token
     * @return boolean
     */
    Boolean isTokenExpired(String accessToken);
    /**
     * 校验 服务器端签名Sign 是否过期
     *
     * @param sign 服务器端签名
     * @return boolean
     */
    Boolean isSignExpired(String sign);

    /**
     * 通过请求参数验证
     * @param credence 用户信息
     * @return boolean
     */
    boolean validate(Credence credence);
    /**
     * 校验 服务器端签名Sign 是否过期
     *
     * @param credence 用户信息
     * @return boolean
     */
    BaseVo getSecurityInfo(Credence credence);
}
