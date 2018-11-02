package com.kmc.rest.auth.controller;

import com.kmc.api.rest.common.auth.parameters.AuthRequestImpl;
import com.kmc.rest.auth.remote.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @date 2018/11/2 9:50
 */
@RestController
@RequestMapping(value = "auth")
public class ApiAuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "getAccessToken")
    public Object accessToken(AuthRequestImpl authRequest) {
        return authService.getAccessToken(authRequest);
    }

}
