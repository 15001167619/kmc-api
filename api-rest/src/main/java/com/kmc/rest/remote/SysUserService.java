package com.kmc.rest.remote;

import com.kmc.rest.fallback.SysUserHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 武海升
 * @date 2018/10/30 10:04
 * @desc name:远程服务名，即spring.application.name配置的名称 fallback 回调函数类
 */
@FeignClient(name= "api-server-producer",fallback = SysUserHystrixServiceImpl.class)
public interface SysUserService {

    /**
     * 根据用户id查询用户信息
     * @param id 用户id
     * @return user
     */
    @RequestMapping(value = "getUserInfo")
    public String getUserInfo(@RequestParam(value = "id") Integer id);

}
