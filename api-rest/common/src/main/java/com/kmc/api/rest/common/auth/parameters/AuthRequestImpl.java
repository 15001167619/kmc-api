package com.kmc.api.rest.common.auth.parameters;

import com.kmc.api.rest.common.auth.Credence;
import lombok.Data;

/**
 * @author 武海升
 * @date 2018/11/2 9:50
 */
@Data
public class AuthRequestImpl implements Credence {

    private Integer userType;

    private String mobile;

    private String password;

    @Override
    public String getCredenceUniqueName() {
        return this.mobile;
    }

    @Override
    public String getCredenceCode() {
        return this.password;
    }

    @Override
    public Integer getUserType() {
        return this.userType;
    }
}
