package com.kmc.producer;

import com.kmc.common.auth.parameters.AuthRequestImpl;
import com.kmc.producer.auth.IAuthService;
import com.kmc.producer.modules.mapper.SysUserMapper;
import com.kmc.producer.modules.model.entity.SysUser;
import com.kmc.producer.redis.IRedisService;
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
public class DataRedisTest {

    @Autowired
    private IRedisService redisService;

    /**
     * 测试
     */
    @Test
    public void addToRedisTest() {
        boolean b = redisService.addToRedis("whs", "1597538246", 160L);
        System.out.println(b);

    }
    @Test
    public void getRedisValueByKeyTest() {
        String redisValueByKey = redisService.getRedisValueByKey("whs");
        System.out.println(redisValueByKey);
    }


}
