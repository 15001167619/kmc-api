package com.kmc.rest.patient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 武海升
 * @date 2018/10/31 9:56
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class ApiPatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiPatientApplication.class, args);
        log.info("ApiPatientApplication start-up is success!");
    }

}
