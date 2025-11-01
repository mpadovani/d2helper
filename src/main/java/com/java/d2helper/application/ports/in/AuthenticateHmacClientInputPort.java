package com.java.d2helper.application.ports.in;

public interface AuthenticateHmacClientInputPort {
    boolean validateHmac(String hmac, String timestamp, String nonce, String apiKeyId);
}
