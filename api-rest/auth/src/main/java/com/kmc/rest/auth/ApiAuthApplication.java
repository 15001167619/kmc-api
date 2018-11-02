package com.kmc.rest.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 武海升
 * @date 2018/11/1 9:50
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class ApiAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiAuthApplication.class, args);
        log.info("ApiDoctorApplication start-up is success!");
    }

}
