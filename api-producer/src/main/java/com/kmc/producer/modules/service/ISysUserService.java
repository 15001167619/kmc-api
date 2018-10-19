package com.kmc.producer.modules.service;

import com.baomidou.mybatisplus.service.IService;
import com.kmc.producer.modules.model.entity.SysUser;

/**
 * @author 武海升
 * @date 2018/10/19 8:18
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * 根据用户id查询用户信息
     *
     * @param userId 用户id
     * @return user
     */
    SysUser findUserByUserId(Integer userId);

}
