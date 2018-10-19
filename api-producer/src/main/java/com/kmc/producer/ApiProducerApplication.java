package com.kmc.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 武海升
 * @date 2018/10/18 16:59
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class ApiProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiProducerApplication.class,args);
        log.info("ApiProducerApplication start-up is success!");
    }

}
