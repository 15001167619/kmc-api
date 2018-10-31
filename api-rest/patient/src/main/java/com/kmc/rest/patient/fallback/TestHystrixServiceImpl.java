package com.kmc.rest.patient.fallback;

import com.kmc.rest.patient.remote.TestService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 武海升
 * @date 2018/10/30 10:12
 */
@Component
public class TestHystrixServiceImpl implements TestService {

    @Override
    public String getTestName(@RequestParam(value = "name")String name) {
        return "参数： "+name+"，服务提供者异常...";
    }

}
