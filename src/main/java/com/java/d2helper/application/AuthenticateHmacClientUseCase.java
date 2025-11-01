package com.java.d2helper.application;
import com.java.d2helper.application.ports.in.AuthenticateHmacClientInputPort;
import com.java.d2helper.application.ports.out.CachePort;
import com.java.d2helper.application.ports.out.HmacGeneratorPort;
import com.java.d2helper.application.ports.out.SecretKeyPort;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateHmacClientUseCase implements AuthenticateHmacClientInputPort {
    HmacGeneratorPort hmacGenerator;
    SecretKeyPort secretKey;
    CachePort cachePort;
    private static final long HMAC_TTL_SECONDS = 300;

    AuthenticateHmacClientUseCase(HmacGeneratorPort hmacGenerator, SecretKeyPort secretKey, CachePort cachePort) {
        this.hmacGenerator = hmacGenerator;
        this.secretKey = secretKey;
        this.cachePort = cachePort;
    }

    @Override
    public boolean validateHmac(String hmac, String timestamp, String nonce, String apiKeyId) {
        String rawToHash = apiKeyId+timestamp+nonce;

        if (cachePort.get(hmac).isPresent()) {
            return false;
        }

        String validateHmac = hmacGenerator.generatorSignature(secretKey.getSecretKey(), rawToHash);

        if (hmac.equals(validateHmac)) {
            cachePort.save(hmac, hmac, HMAC_TTL_SECONDS);
            return true;
        }

        return false;
    }
}
