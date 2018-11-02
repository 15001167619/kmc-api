package com.kmc.rest.auth.remote;

import com.kmc.rest.auth.fallback.AuthHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 武海升
 * @date 2018/11/2 15:00
 */
@FeignClient(name= "api-server-producer",fallback = AuthHystrixServiceImpl.class)
public interface AuthService {

    /**
     * 获取 Token
     * @param userType 用户信息
     * @param mobile 用户信息
     * @return accessToken
     */
    @RequestMapping(value = "getAccessToken")
    Object getAccessToken(@RequestParam("userType") Integer userType, @RequestParam("mobile")String mobile);

}
