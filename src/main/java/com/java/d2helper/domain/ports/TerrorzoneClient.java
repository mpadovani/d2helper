package com.java.d2helper.domain.ports;
import com.java.d2helper.domain.model.TerrozoneApiResponse;

public interface TerrorzoneClient {
    TerrozoneApiResponse fetchFromApi();
}
