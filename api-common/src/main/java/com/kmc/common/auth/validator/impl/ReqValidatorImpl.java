package com.kmc.common.auth.validator.impl;

import com.kmc.common.auth.validator.IReqValidator;
import com.kmc.common.auth.validator.dto.Credence;
import org.springframework.stereotype.Service;

/**
 * @author 武海升
 * @date 2018/11/2 9:28
 */
@Service
public class ReqValidatorImpl implements IReqValidator {
    @Override
    public boolean validate(Credence credence) {
        return false;
    }
}
