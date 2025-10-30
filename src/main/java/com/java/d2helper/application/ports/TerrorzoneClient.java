package com.java.d2helper.application.ports;
import com.java.d2helper.domain.model.TerrozoneApiResponse;

public interface TerrorzoneClient {
    TerrozoneApiResponse fetchFromApi();
}
