package com.java.d2helper.application.ports.out;

public interface HmacGeneratorPort {
    String generatorSignature(String secretKey, String rawToHash);
}
