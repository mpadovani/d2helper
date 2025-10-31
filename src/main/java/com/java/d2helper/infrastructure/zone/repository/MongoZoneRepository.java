package com.java.d2helper.infrastructure.zone.repository;
import com.java.d2helper.infrastructure.zone.model.ZoneEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoZoneRepository extends MongoRepository<ZoneEntity,Long> { }
