package com.myretail.products.data.impl;

import com.myretail.products.data.IRedisDataClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RedisDataClient implements IRedisDataClient {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * This method helps to store data in Redis.
     * @param key
     * @param value
     */
    @Override
    public void saveValue(String key, String value) {
        log.debug("Save Data Call. KEY: {} and Value: {}", key, value);
        this.redisTemplate.opsForValue().set(key, value);
    }

    /**
     * This method helps to get data from Redis.
     * @param key
     * @return String
     */
    @Override
    public String getValue(String key) {
        log.debug("Get Data Call. KEY: {}", key);
        return this.redisTemplate.opsForValue().get(key);
    }
}
