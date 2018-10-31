package com.kmc.rest.patient.remote;

import com.kmc.rest.patient.fallback.TestHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 武海升
 * @date 2018/10/30 10:04
 * @desc name:远程服务名，即spring.application.name配置的名称 fallback 回调函数类
 */
@FeignClient(name= "api-server-producer",fallback = TestHystrixServiceImpl.class)
public interface TestService {

    /**
     * 测试
     * @param name
     * @return user
     */
    @RequestMapping(value = "getTestName")
    String getTestName(@RequestParam(value = "name") String name);

}
