package com.java.d2helper.infrastructure.security;
import com.java.d2helper.application.ports.in.AuthenticateHmacClientInputPort;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {
    private final AuthenticateHmacClientInputPort authenticateHmac;

    public ApiKeyFilter(AuthenticateHmacClientInputPort authenticateHmac) {
        this.authenticateHmac = authenticateHmac;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String hmac = request.getHeader("Authorization");
        String timestamp = request.getHeader("X-Timestamp");
        String nonce = request.getHeader("X-Nonce");
        String apiKeyId = request.getHeader("X-Api-Key-Id");

        if (hmac == null || hmac.isEmpty() ||
                timestamp == null || timestamp.isEmpty() ||
                nonce == null || nonce.isEmpty() ||
                apiKeyId == null || apiKeyId.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        if (!authenticateHmac.validateHmac(hmac, timestamp, nonce, apiKeyId)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        filterChain.doFilter(request, response);
    }
}
