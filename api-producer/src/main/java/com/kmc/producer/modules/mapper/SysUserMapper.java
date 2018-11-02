package com.kmc.producer.modules.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kmc.producer.modules.model.entity.SysUser;

/**
 * @author 武海升
 * @date 2018/10/18 15:43
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 通过用户名查询用户信息
     *
     * @param userId 用户名
     * @return user
     */
    SysUser selectUserByUserId(Integer userId);
    /**
     * 通过手机号查询用户信息
     *
     * @param mobile 用户名
     * @return user
     */
    SysUser selectUserByMobile(String mobile);

}
