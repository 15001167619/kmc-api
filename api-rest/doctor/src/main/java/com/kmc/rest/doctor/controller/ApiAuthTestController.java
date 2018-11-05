package com.kmc.rest.doctor.controller;

import com.kmc.rest.doctor.remote.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @date 2018/10/30 10:16
 */
@RestController
@RequestMapping(value = "auth/user")
public class ApiAuthTestController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "getUserInfo")
    public String userInfo(@RequestParam("id") Integer id) {
        return sysUserService.getUserInfo(id);
    }

}
