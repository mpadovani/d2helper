package com.java.d2helper.infrastructure.redis;
import com.java.d2helper.application.ports.out.CachePort;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RedisCachAdpter implements CachePort {
    private final StringRedisTemplate redisTemplate;

    public RedisCachAdpter(StringRedisTemplate stringRedisTemplate) {
        this.redisTemplate = stringRedisTemplate;
    }

    @Override
    public void save(String key, String value, long timeoutSeconds) {
        redisTemplate.opsForValue().set(value, key, timeoutSeconds);
    }

    @Override
    public Optional<String> get(String key) {
        String value = redisTemplate.opsForValue().get(key);
        return Optional.ofNullable(value);
    }
}
