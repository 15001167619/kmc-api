package com.kmc.common.auth.exception;

/**
 * @author 武海升
 * @date 2018/11/2 10:10
 */
public enum ExceptionEnum implements ServiceExceptionEnum {

    /**
     * token异常
     */
    TOKEN_EXPIRED(700, "token过期"),
    TOKEN_ERROR(700, "token验证失败"),

    /**
     * 签名异常
     */
    SIGN_ERROR(700, "签名验证失败"),

    /**
     * 其他
     */
    WRITE_ERROR(500,"渲染界面错误"),
    AUTH_REQUEST_ERROR(400, "账号密码错误"),

    /**
     * 错误的请求
     */
    REQUEST_NULL(400, "请求有错误"),
    SERVER_ERROR(500, "服务器异常");

    ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
