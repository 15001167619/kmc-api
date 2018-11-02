package com.kmc.producer.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 武海升
 * @date 2018/11/2 10:07
 */
@Data
@Configuration
@ConfigurationProperties(prefix = RestProperties.REST_PREFIX)
public class RestProperties {

    public static final String REST_PREFIX = "rest";

    private boolean authOpen = true;

    private boolean signOpen = true;

}
