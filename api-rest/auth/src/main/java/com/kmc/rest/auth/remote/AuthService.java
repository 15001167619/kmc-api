package com.kmc.rest.auth.remote;

import com.kmc.api.rest.common.auth.parameters.AuthRequestImpl;
import com.kmc.rest.auth.fallback.AuthHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 武海升
 * @date 2018/11/2 15:00
 */
@FeignClient(name= "api-server-producer",fallback = AuthHystrixServiceImpl.class)
public interface AuthService {

    /**
     * 获取 Token
     * @param authRequest 用户信息
     * @return accessToken
     */
    @RequestMapping(value = "getAccessToken")
    String getAccessToken(AuthRequestImpl authRequest);

}
