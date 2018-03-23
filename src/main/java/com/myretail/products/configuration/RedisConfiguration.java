package com.myretail.products.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * This is a Redis configuration class, creates RedisTemplate object to access the data from Redis server.
 * The host and port will fetch from the properties.
 */
@Configuration
public class RedisConfiguration {

    @Value("${spring.redis.host}")
    private String hostName;

    @Value("${spring.redis.port}")
    private Integer port;

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(configuration());
        return jedisConnectionFactory;
    }

    @Bean
    public RedisStandaloneConfiguration configuration() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(hostName);
        configuration.setPort(port);
        return configuration;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate() {
        return new StringRedisTemplate(redisConnectionFactory());
    }
}
