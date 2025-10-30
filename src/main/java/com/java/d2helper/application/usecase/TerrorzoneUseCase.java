package com.java.d2helper.application.usecase;
import com.java.d2helper.domain.model.Terrorzone;
import com.java.d2helper.domain.model.TerrozoneApiResponse;
import com.java.d2helper.infrastructure.external.TerrorzoneApiClient;
import com.java.d2helper.infrastructure.repository.TerrorzoneRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

@Service
public class TerrorzoneUseCase {
    private TerrorzoneApiClient apiClient;
    private final TerrorzoneRepository repository;

    public TerrorzoneUseCase(TerrorzoneApiClient terrorzoneClient,
                             TerrorzoneRepository repository) {
        this.apiClient = terrorzoneClient;
        this.repository = repository;
    }

    public Terrorzone get() {
        Long id = generateId();
        return repository.findById(id).orElseGet(() -> generateNewTerrorzone(id));
    }

    private Terrorzone generateNewTerrorzone(Long id) {
        TerrozoneApiResponse terrozoneApiResponse = apiClient.fetchFromApi();
        Terrorzone newTerrorzone = new Terrorzone(generateId(), terrozoneApiResponse);
        repository.save(newTerrorzone);
        return newTerrorzone;
    }

    private Long generateId() {
        Instant now = Instant.now();
        LocalDateTime ldt = LocalDateTime.ofInstant(now, ZoneOffset.UTC);
        LocalDateTime startOfHour = ldt.truncatedTo(ChronoUnit.HOURS);
        Instant startOfHourInstant = startOfHour.toInstant(ZoneOffset.UTC);
        return startOfHourInstant.toEpochMilli();
    }
}
