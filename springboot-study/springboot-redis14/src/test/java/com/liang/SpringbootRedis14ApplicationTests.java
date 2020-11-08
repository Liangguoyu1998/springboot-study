package com.liang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liang.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

//在我们真实的开发中，或者你们在公司，一般都可以看到一个公司自己封装的redisUtils
@SpringBootTest
class SpringbootRedis14ApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    void contextLoads() {
        //redisTemplate
        //opsForValue 操作字符串 类似String
        //opsForList 操作List 类似List
        //opsForSet
        //opsForHash
        //opsForZSet
        //opsForGeo
        //opsForHyperLogLog

        //除了基本的操作，我们常用的方法都可以直接通过直接通过redisTemplate操作，比如事务和基本的CRUD
        //获取redis的连接对象
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        System.out.println(connection);
        connection.flushDb();
        connection.flushAll();
        redisTemplate.opsForValue().set("mykey","kuangshen");
        System.out.println(redisTemplate.opsForValue().get("mykey"));


    }
    @Test
    void test() throws JsonProcessingException {
        //真实的开发一般都是用json来传递对象
        User user = new User("小明", 5);
        //String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
