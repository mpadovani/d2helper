package com.java.d2helper.infrastructure.terrorzone.adpter;
import com.java.d2helper.application.ports.TerrorzoneRepositoryPort;
import com.java.d2helper.domain.model.Terrorzone;
import com.java.d2helper.infrastructure.terrorzone.model.TerrorzoneEntity;
import com.java.d2helper.infrastructure.terrorzone.mapper.TerrorzoneMapper;
import com.java.d2helper.infrastructure.terrorzone.repository.TerrorzoneRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TerrorzoneRepositoryAdapter implements TerrorzoneRepositoryPort {
    private final TerrorzoneRepository repository;
    private final TerrorzoneMapper mapper;

    public TerrorzoneRepositoryAdapter(TerrorzoneRepository repository, TerrorzoneMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public Optional<Terrorzone> findById(Long id) {
        Optional<TerrorzoneEntity> entityOptional = repository.findById(id);
        return entityOptional.map(mapper::toDomain);
    }

    @Override
    public void save(Terrorzone terrorzone) {
        TerrorzoneEntity entity = mapper.toEntity(terrorzone);
        repository.save(entity);
    }
}
