package com.java.d2helper.application.ports.out;
import java.util.Optional;

public interface CachePort {
    void save(String key, String value, long timeoutSeconds);
    Optional<String> get(String key);
}
