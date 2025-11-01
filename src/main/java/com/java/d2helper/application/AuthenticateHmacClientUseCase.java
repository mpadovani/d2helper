package com.java.d2helper.application;
import com.java.d2helper.application.ports.in.AuthenticateHmacClientInputPort;
import com.java.d2helper.application.ports.out.HmacGeneratorPort;
import com.java.d2helper.application.ports.out.SecretKeyPort;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateHmacClientUseCase implements AuthenticateHmacClientInputPort {
    HmacGeneratorPort hmacGenerator;
    SecretKeyPort secretKey;

    AuthenticateHmacClientUseCase(HmacGeneratorPort hmacGenerator, SecretKeyPort secretKey) {
        this.hmacGenerator = hmacGenerator;
        this.secretKey = secretKey;
    }

    @Override
    public boolean validateHmac(String hmac, String timestamp, String nonce, String apiKeyId) {
        String rawToHash = apiKeyId+timestamp+nonce;
        String validateHmac = hmacGenerator.generatorSignature(secretKey.getSecretKey(), rawToHash);
        return hmac.equals(validateHmac);
    }
}
