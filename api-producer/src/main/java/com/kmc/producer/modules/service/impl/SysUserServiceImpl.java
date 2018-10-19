package com.kmc.producer.modules.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.kmc.producer.modules.mapper.SysUserMapper;
import com.kmc.producer.modules.model.entity.SysUser;
import com.kmc.producer.modules.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 武海升
 * @date 2018/10/19 8:20
 */
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    private final SysUserMapper sysUserMapper;

    @Autowired
    public SysUserServiceImpl(SysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public SysUser findUserByUserId(Integer userId) {
        if (userId==null) {
            log.error("根据用户id{}查询用户为空", userId);
            //添加接口返回值
        }
        return sysUserMapper.selectUserByUserId(userId);
    }
}
