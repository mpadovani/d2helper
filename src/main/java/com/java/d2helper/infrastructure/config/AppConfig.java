package com.java.d2helper.infrastructure.config;

import com.java.d2helper.application.ports.TerrorzoneClient;
import com.java.d2helper.application.usecase.TerrorzoneUseCase;
import com.java.d2helper.infrastructure.external.TerrorzoneApiClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
//    @Bean
//    public TerrorzoneApiClient terrorzoneApiClient(RestTemplate restTemplate) {
//        return new TerrorzoneApiClient(restTemplate);
//    }
//
//    @Bean
//    public TerrorzoneUseCase terrorZoneUseCase(TerrorzoneApiClient terrorzoneApiClient) {
//        return new TerrorzoneUseCase(terrorzoneApiClient);
//    }
}
