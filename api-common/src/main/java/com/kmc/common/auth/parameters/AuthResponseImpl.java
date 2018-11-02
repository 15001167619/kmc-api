package com.kmc.common.auth.parameters;

/**
 * @author 武海升
 * @date 2018/11/2 9:56
 */
public class AuthResponseImpl {

    /**
     * jwt token
     */
    private final String token;

    /**
     * 签名
     */
    private final String sign;

    public AuthResponseImpl(String token, String sign) {
        this.token = token;
        this.sign = sign;
    }

    public String getToken() {
        return this.token;
    }

    public String getSign() {
        return sign;
    }

}
