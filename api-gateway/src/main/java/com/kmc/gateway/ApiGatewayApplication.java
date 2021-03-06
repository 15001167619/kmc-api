package com.kmc.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
/**
 * @author 武海升
 * @date 2018/10/31 14:47
 */
@Slf4j
@SpringBootApplication
@EnableZuulProxy
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
        log.info("ApiGatewayApplication Start-Up is SUCCESS!");
    }

}
