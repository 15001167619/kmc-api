package com.common.test;

import com.kmc.common.constant.ConfigConstants;
import com.kmc.common.constant.StatusCodeUtils;

/**
 * @author 武海升
 * @date 2018/10/18 10:41
 */
public class ApiCommonTest {

    public static void main(String[] args) {
        System.out.println("系统配置文件读取======>" + ConfigConstants.PICTURE_BASE_PATH);
        System.out.println("Api配置文件读取======>" + StatusCodeUtils.getStatusDesc(100000));
    }

}
