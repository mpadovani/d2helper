package com.java.d2helper.infrastructure.repository;
import com.java.d2helper.domain.model.Zone;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoZoneRepository extends MongoRepository<Zone,Long> { }
