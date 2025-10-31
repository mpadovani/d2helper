package com.java.d2helper.infrastructure.terrorzone.repository;
import com.java.d2helper.infrastructure.terrorzone.model.TerrorzoneEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TerrorzoneRepository extends MongoRepository<TerrorzoneEntity,Long> { }
