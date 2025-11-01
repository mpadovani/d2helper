package com.java.d2helper.infrastructure.external;
import com.java.d2helper.domain.ports.TerrorzoneClient;
import com.java.d2helper.domain.exception.GenericApiException;
import com.java.d2helper.domain.model.TerrozoneApiResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class TerrorzoneApiClient implements TerrorzoneClient {
    private final RestTemplate restTemplate;

    public TerrorzoneApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public TerrozoneApiResponse fetchFromApi() {
        String url = "https://d2runewizard.com/api/terror-zone";

        try {
            return restTemplate.getForObject(url, TerrozoneApiResponse.class);
        } catch (RestClientException e) {
            throw new GenericApiException("Erro ao acessar API externa: " + url, e);
        }
    }
}
