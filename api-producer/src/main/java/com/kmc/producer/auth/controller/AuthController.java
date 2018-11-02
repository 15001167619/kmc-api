package com.kmc.producer.auth.controller;

import com.kmc.api.rest.common.auth.parameters.AuthRequestImpl;
import com.kmc.producer.auth.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Object accessToken(@RequestParam("userType") Integer userType, @RequestParam("mobile")String mobile) {
        return authService.getSecurityInfo(AuthRequestImpl.builder().userType(userType).mobile(mobile).build());
    }

}
