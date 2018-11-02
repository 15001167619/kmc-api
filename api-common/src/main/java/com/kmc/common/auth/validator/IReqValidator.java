package com.kmc.common.auth.validator;


import com.kmc.common.auth.validator.dto.Credence;

/**
 * @author 武海升
 * @date 2018/11/2 9:26
 */
public interface IReqValidator {

    /**
     * 通过请求参数验证
     */
    boolean validate(Credence credence);

}
