package com.kmc.rest.fallback;

import com.kmc.rest.remote.SysUserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 武海升
 * @date 2018/10/30 10:12
 */
@Component
public class SysUserHystrixServiceImpl implements SysUserService {

    @Override
    public String getUserInfo(@RequestParam(value = "id")Integer id) {
        return "参数： "+id+"，服务提供者异常...";
    }
}
