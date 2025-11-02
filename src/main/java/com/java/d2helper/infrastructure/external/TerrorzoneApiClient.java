package com.java.d2helper.infrastructure.external;
import com.java.d2helper.application.ports.out.TerrorzoneClient;
import com.java.d2helper.domain.exception.GenericApiException;
import com.java.d2helper.domain.model.TerrozoneApiResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class TerrorzoneApiClient implements TerrorzoneClient {
    public TerrorzoneApiClient() { }

    @Override
    public TerrozoneApiResponse fetchFromApi() {
        String url = "https://d2runewizard.com/api/terror-zone";

        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(url, TerrozoneApiResponse.class);
        } catch (RestClientException e) {
            throw new GenericApiException("Erro ao acessar API externa: " + url, e);
        }
    }
}
