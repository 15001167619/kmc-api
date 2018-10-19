package com.kmc.common.constant;

import com.kmc.common.config.ReloadableConfig;

/**
 * @author 武海升
 * @date 2018/10/18 10:10
 * @description: 公用常量类
 */
public class ConfigConstants {

    //========================== 系统常量配置  ==============================
    /**
     * 读取系统配置文件
     */
    public static final Integer SYSTEM_PROPERTIES_TYPE = 1;
    /**
     * 读取接口配置文件
     */
    public static final Integer API_PROPERTIES_TYPE = 2;

    /**
     * 图片Api接口访问基础路径
     */
    public static String PICTURE_BASE_PATH = ReloadableConfig.getProperty("PICTURE_BASE_PATH", "http://192.168.1.203/shopStatic",ConfigConstants.SYSTEM_PROPERTIES_TYPE);


}
