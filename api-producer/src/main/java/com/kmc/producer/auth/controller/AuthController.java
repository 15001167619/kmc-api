package com.kmc.producer.auth.controller;

import com.kmc.common.auth.parameters.AuthRequestImpl;
import com.kmc.producer.auth.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @date 2018/11/2 15:11
 */
@RestController
public class AuthController {

    @Autowired
    private IAuthService authService;

    @RequestMapping(value = "getAccessToken")
    public String accessToken(AuthRequestImpl authRequest) {
        return authService.getSecurityInfo(authRequest);
    }

}
