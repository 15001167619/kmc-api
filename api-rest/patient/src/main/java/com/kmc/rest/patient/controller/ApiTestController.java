package com.kmc.rest.patient.controller;

import com.kmc.rest.patient.remote.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @date 2018/10/30 10:16
 */
@RestController
public class ApiTestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "getTestName/{name}")
    public String testName(@PathVariable("name") String name) {
        return testService.getTestName(name);
    }

}
