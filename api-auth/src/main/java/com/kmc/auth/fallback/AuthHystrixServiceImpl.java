package com.kmc.auth.fallback;

import com.alibaba.fastjson.JSON;
import com.kmc.auth.remote.AuthService;
import com.kmc.common.auth.parameters.AuthRequestImpl;
import org.springframework.stereotype.Component;

/**
 * @author 武海升
 * @date 2018/11/2 15:01
 */
@Component
public class AuthHystrixServiceImpl implements AuthService {

    @Override
    public String getAccessToken(AuthRequestImpl authRequest) {
        return "服务异常.........."+JSON.toJSONString(authRequest);
    }

}
