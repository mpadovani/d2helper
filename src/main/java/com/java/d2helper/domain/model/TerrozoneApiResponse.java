package com.java.d2helper.domain.model;

public record TerrozoneApiResponse(
        Zone nextTerrorZone,
        Zone currentTerrorZone
) {
    public record Zone(String zone, String act) {}
}