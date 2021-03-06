package com.kmc.rest.patient.controller;

import com.kmc.rest.patient.remote.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @date 2018/10/30 10:16
 */
@RestController
public class ApiTestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "getTestName")
    public String testName(@RequestParam("name") String name) {
        return testService.getTestName(name);
    }

}
