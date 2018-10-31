package com.kmc.rest.patient.config;

import com.kmc.api.rest.common.config.HystrixConfig;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 武海升
 * @date 2018/10/30 15:26
 */
@Configuration
public class ServletRegistrationHystrixConfig {

    @Bean
    public ServletRegistrationBean getServlet() {
        return HystrixConfig.initServletRegistrationHystrixConfig();
    }

}
