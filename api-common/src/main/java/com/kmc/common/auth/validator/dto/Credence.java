package com.kmc.common.auth.validator.dto;

/**
 * @author 武海升
 * @date 2018/11/2 9:27
 */
public interface  Credence {

    /**
     * 唯一凭证
     * @return 手机号
     */
    String getCredenceUniqueName();

    /**
     * 密码
     * @return Code
     */
    String getCredenceCode();
    /**
     * 用户类型
     * @return type
     */
    Integer getUserType();

}
