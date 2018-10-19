package com.kmc.common.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author 武海升
 * @date 2018/10/18 10:14
 * @description: 公用常量类文件读取配置
 */
public class ReloadableConfig {

    private ReloadableConfig(){}
    private static Properties prop;
    private static InputStream in;
    private static InputStreamReader inputStreamReader;

    private static final String SYSTEM_PROPERTIES_PATH = "/constant/configConstants.properties";
    private static final String API_PROPERTIES_PATH = "/code/statusCode.properties";

    public static String getProperty(String key,String defaultValue,Integer pathType){
        initProperties(pathType);
        if (prop == null) {
            return null;
        }
        String value = prop.getProperty(key);
        if(value == null) {
            return defaultValue;
        }
        return value;
    }

    private static void initProperties(Integer pathType) {
        String path;
        switch (pathType){
            case 1:
                path = ReloadableConfig.SYSTEM_PROPERTIES_PATH;
                break;
            case 2:
                path = ReloadableConfig.API_PROPERTIES_PATH;
                break;
                default:path = ReloadableConfig.SYSTEM_PROPERTIES_PATH;
        }
        try {
            prop = new Properties();
            in = ReloadableConfig.class.getResourceAsStream(path);
            inputStreamReader = new InputStreamReader(in, "UTF-8");
            prop.load(inputStreamReader);
            inputStreamReader.close();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("reloadableConfig  properties file not find ");
        } catch (IOException e) {
            System.out.println("reloadableConfig initial faile");
        } catch (Exception e) {
            System.out.println("property file not exits");
        }finally {
            if(inputStreamReader!=null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
