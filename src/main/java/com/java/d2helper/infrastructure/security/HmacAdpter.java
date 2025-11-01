package com.java.d2helper.infrastructure.security;
import com.java.d2helper.application.ports.out.HmacGeneratorPort;
import org.springframework.stereotype.Component;
import java.security.NoSuchAlgorithmException;

@Component
public class HmacAdpter implements HmacGeneratorPort {
    HmacGenerator generator;

    public HmacAdpter(HmacGenerator generator) {
        this.generator = generator;
    }
    @Override
    public String generatorSignature(String secretKey, String rawToHash) {
        try {
            return generator.generate(secretKey, rawToHash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
