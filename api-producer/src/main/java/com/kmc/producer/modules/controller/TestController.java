package com.kmc.producer.modules.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @date 2018/10/31 10:16
 */
@RestController
public class TestController {

    /**
     * 测试
     *
     * @param name
     * @return 用户信息
     */
    @RequestMapping(value = "getTestName")
    public String testName(@RequestParam String name) {
        return "---------服务提供者--------> 参数："+name;
    }

}
