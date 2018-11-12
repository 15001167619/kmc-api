package com.kmc.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author 武海升
 * @date 2018/11/12 15:37
 */
@Slf4j
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ApiConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiConfigApplication.class, args);
        log.info("ApiConfigApplication start-up is success!");
    }

}
