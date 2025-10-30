package com.java.d2helper.infrastructure.repository;

import com.java.d2helper.domain.model.Terrorzone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TerrorzoneRepository extends MongoRepository<Terrorzone,Long> {
    Terrorzone findTopByOrderByCreatedAtDesc();
}
