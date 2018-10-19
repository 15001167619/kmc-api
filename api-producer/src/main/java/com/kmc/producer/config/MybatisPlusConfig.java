package com.kmc.producer.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.kmc.producer.config.properties.DruidProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * @author 武海升
 * @date 2018/10/18 15:27
 */
@Configuration
@EnableTransactionManagement(order = 2)
@MapperScan(basePackages = {"com.kmc.producer.modules.mapper"})
public class MybatisPlusConfig {

    @Resource
    private DruidProperties druidProperties;

    /**
     * 核心数据源
     */
    private DruidDataSource coreDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }


    /**
     * 单数据源连接池配置
     */
    @Bean
    public DruidDataSource singleDatasource() {
        return coreDataSource();
    }


    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }


}
