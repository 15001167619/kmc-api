package com.kmc.turbine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author 武海升
 * @date 2018/10/31 10:45
 */
@Slf4j
@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class ApiTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTurbineApplication.class,args);
        log.info("ApiTurbineApplication start-up is success!");
    }

}
