package com.java.d2helper.infrastructure.security;
import com.java.d2helper.application.ports.out.security.SecretKeyPort;
import org.springframework.stereotype.Component;

@Component
public class SecretKeyAdpter implements SecretKeyPort {
    @Override
    public String getSecretKey() {
        return "meuSecretAqui";
    }
}
