package com.zkn.demo.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;

/**
 * @author 郑凯努
 * @version 1.0
 * @date 2019/8/28
 */
@Configuration
public class RedisConfiguration {

    @Bean
    @ConditionalOnMissingBean(ReactiveStringRedisTemplate.class)
    public ReactiveStringRedisTemplate reactiveStringRedisTemplate(ReactiveRedisConnectionFactory factory) {
        return new ReactiveStringRedisTemplate(factory);
    }
}
