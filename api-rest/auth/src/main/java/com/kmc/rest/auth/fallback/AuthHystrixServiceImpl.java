package com.kmc.rest.auth.fallback;

import com.kmc.api.rest.common.auth.parameters.AuthRequestImpl;
import com.kmc.rest.auth.remote.AuthService;
import org.springframework.stereotype.Component;

/**
 * @author 武海升
 * @date 2018/11/2 15:01
 */
@Component
public class AuthHystrixServiceImpl implements AuthService {

    @Override
    public String getAccessToken(AuthRequestImpl authRequest) {
        return "服务异常..........";
    }

}
