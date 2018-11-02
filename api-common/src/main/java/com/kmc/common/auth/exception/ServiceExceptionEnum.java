package com.kmc.common.auth.exception;

/**
 * @author 武海升
 * @date 2018/11/2 10:09
 */
public interface ServiceExceptionEnum {

    /**
     * 获取异常编码
     */
    Integer getCode();

    /**
     * 获取异常信息
     */
    String getMessage();

}
