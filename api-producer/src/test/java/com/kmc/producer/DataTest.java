package com.kmc.producer;

import com.kmc.common.auth.parameters.AuthRequestImpl;
import com.kmc.common.auth.validator.dto.Credence;
import com.kmc.producer.auth.IAuthService;
import com.kmc.producer.modules.mapper.SysUserMapper;
import com.kmc.producer.modules.model.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 武海升
 * @date 2018/10/18 16:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DataTest {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private IAuthService authService;

    /**
     * 测试
     */
    @Test
    public void selectUserByUserIdTest() {
        log.info("*******************");
        SysUser sysUser = sysUserMapper.selectUserByUserId(100);
        System.out.println(sysUser);
    }

    @Test
    public void getAccessTokenTest() {
        log.info("*******************");
        String accessToken = authService.getAccessToken("15001167619");
        System.out.println("accessToken<===========>"+accessToken);
    }

    @Test
    public void isTokenExpiredTest() {
        log.info("*******************");
        String accessToken = "eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiIxMjM0NTYiLCJzdWIiOiIxNTAwMTE2NzYxOSIsImV4cCI6MTU0MTIxNDQ1NCwiaWF0IjoxNTQxMTI4MDU0fQ.miet-em2NgW0ubTmiG-H8GJ40syxTu9dgXQ3zzF_2-_S5m8vl3btITTTL7lOYgH9AXv3JSsmjwJ99VbwlifStg";
        Boolean tokenExpired = authService.isTokenExpired(accessToken);
        System.out.println(tokenExpired);
    }

    @Test
    public void getSign() {
        log.info("*******************");
        AuthRequestImpl authRequest = new AuthRequestImpl();
        authRequest.setMobile("15001167619");
        authRequest.setPassword("123456");
        authRequest.setUserType(0);
        String sign = authService.getSign(authRequest);
        System.out.println("serverSign<===========>"+sign);
    }

}
