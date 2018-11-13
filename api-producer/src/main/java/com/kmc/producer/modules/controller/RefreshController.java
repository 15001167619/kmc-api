package com.kmc.producer.modules.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @date 2018/11/13 11:36
 */
@RestController
@RefreshScope
public class RefreshController {

    @Value("${specialValidator.enable}")
    private boolean enable;

    @RequestMapping(value = "getSpecialValidatorValue")
    public boolean getSpecialValidatorValue() {
        return this.enable;
    }

}
