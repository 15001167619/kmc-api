package com.kmc.rest.auth.fallback;

import com.kmc.rest.auth.remote.AuthService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 武海升
 * @date 2018/11/2 15:01
 */
@Component
public class AuthHystrixServiceImpl implements AuthService {

    @Override
    public String getAccessToken(@RequestParam("userType") Integer userType, @RequestParam("mobile")String mobile) {
        return "服务异常..........";
    }

}
