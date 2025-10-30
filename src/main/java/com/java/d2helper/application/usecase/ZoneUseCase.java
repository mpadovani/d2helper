package com.java.d2helper.application.usecase;
import com.java.d2helper.domain.model.Zone;
import com.java.d2helper.infrastructure.repository.MongoZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneUseCase {
    private final MongoZoneRepository repository;

    public ZoneUseCase(MongoZoneRepository repository) {
        this.repository = repository;
    }

    public List<Zone> get() {
        return repository.findAll();
    }
}
