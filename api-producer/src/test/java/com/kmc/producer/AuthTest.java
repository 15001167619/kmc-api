package com.kmc.producer;

import com.kmc.common.auth.parameters.AuthRequestImpl;
import com.kmc.producer.auth.IAuthService;
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
public class AuthTest {

    @Autowired
    private IAuthService authService;

    @Test
    public void getSecurityInfo() {
        log.info("*******************");
        AuthRequestImpl authRequest = new AuthRequestImpl();
        authRequest.setMobile("15001167619");
        authRequest.setPassword("123456");
        authRequest.setUserType(1);
        String sign = authService.getSecurityInfo(authRequest);
        System.out.println("serverSign<===========>"+sign);
    }

}
