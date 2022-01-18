package com.slh.redis.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisServiceImpl {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * hash set
     */
    public void hset(String key,String field,String value){
        redisTemplate.opsForHash().put(key,field,value);
    }

    /**
     *
     * @param key
     * @param field
     * @return
     */
    public String hget(String key,String field){
        Object result = redisTemplate.opsForHash().get(key, field);
        return result == null? null:result.toString();
    }



}
