package com.java.d2helper.application;
import com.java.d2helper.domain.ports.TerrorzoneClient;
import com.java.d2helper.domain.ports.TerrorzoneRepositoryPort;
import com.java.d2helper.domain.model.Terrorzone;
import com.java.d2helper.domain.model.TerrozoneApiResponse;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

@Service
public class TerrorzoneUseCase {
    private TerrorzoneClient apiClient;
    private final TerrorzoneRepositoryPort repository;

    public TerrorzoneUseCase(TerrorzoneClient terrorzoneClient,
                             TerrorzoneRepositoryPort newRepository) {
        this.apiClient = terrorzoneClient;
        this.repository = newRepository;
    }

    public Terrorzone get() {
        Long id = generateId();
        return repository.findById(id).orElseGet(() -> generateNewTerrorzone(id));
    }

    private Terrorzone generateNewTerrorzone(Long id) {
        TerrozoneApiResponse terrozoneApiResponse = apiClient.fetchFromApi();
        Terrorzone newTerrorzone = new Terrorzone(id, terrozoneApiResponse);
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
