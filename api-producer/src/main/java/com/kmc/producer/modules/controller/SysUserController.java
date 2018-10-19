package com.kmc.producer.modules.controller;

import com.kmc.producer.modules.model.entity.SysUser;
import com.kmc.producer.modules.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @date 2018/10/19 8:26
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private ISysUserService userService;

    /**
     * 通过ID查询当前用户信息
     *
     * @param id ID
     * @return 用户信息
     */
    @GetMapping("/{id}")
    public SysUser user(@PathVariable Integer id) {
        return userService.findUserByUserId(id);
    }

}
