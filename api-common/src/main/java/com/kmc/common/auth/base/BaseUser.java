package com.kmc.common.auth.base;

import lombok.Builder;
import lombok.Data;

/**
 * @author 武海升
 * @date 2018/11/2 11:34
 */
@Data
@Builder
public class BaseUser {

    private Integer userType;

    private String mobile;

    private String password;

}
