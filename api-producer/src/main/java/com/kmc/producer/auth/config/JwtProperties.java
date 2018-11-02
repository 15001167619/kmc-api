package com.kmc.producer.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 武海升
 * @date 2018/11/2 10:06
 */
@Data
@Configuration
@ConfigurationProperties(prefix = JwtProperties.JWT_PREFIX)
public class JwtProperties {

    public static final String JWT_PREFIX = "jwt";

    private String header = "Authorization";

    private String secret = "defaultSecret";

    private Long expiration = 100L;

    private String authPath = "auth";

    private String md5Key = "randomKey";

    private Integer randomCount = 6;

}
