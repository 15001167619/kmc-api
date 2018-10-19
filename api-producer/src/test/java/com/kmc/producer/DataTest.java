package com.kmc.producer;

import com.kmc.producer.modules.mapper.SysUserMapper;
import com.kmc.producer.modules.model.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 武海升
 * @date 2018/10/18 16:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DataTest {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 测试
     */
    @Test
    public void selectUserByUserId() {
        log.info("*******************");
        SysUser sysUser = sysUserMapper.selectUserByUserId(100);
        System.out.println(sysUser);
    }

}
