package com.kmc.gateway.config;

import com.kmc.gateway.filter.AuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 武海升
 * @date 2018/11/5 9:40
 */
@Configuration
public class AuthFilterConfig {

    @Bean
    public AuthFilter authFilter() {
        return new AuthFilter();
    }

}
