package com.kmc.rest.doctor.controller;

import com.kmc.rest.doctor.remote.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @date 2018/10/30 10:16
 */
@RestController
@RequestMapping(value = "user")
public class ApiSysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "getUserInfo/{id}")
    public String userInfo(@PathVariable("id") Integer id) {
        return sysUserService.getUserInfo(id);
    }

}
