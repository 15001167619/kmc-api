package com.kmc.producer;

import com.kmc.api.rest.common.auth.parameters.AuthRequestImpl;
import com.kmc.common.auth.base.BaseVo;
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
        BaseVo securityInfo = authService.getSecurityInfo(AuthRequestImpl.builder().userType(0).mobile("15001167619").build());
        System.out.println("serverSign<===========>"+securityInfo);
    }

}
