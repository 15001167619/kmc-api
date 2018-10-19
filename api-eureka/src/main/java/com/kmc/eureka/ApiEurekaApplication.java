package com.kmc.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 武海升
 * @date 2018/10/18 14:04
 */
@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class ApiEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiEurekaApplication.class, args);
        log.info("ApiEurekaApplication Start-Up is SUCCESS!");
    }

}
