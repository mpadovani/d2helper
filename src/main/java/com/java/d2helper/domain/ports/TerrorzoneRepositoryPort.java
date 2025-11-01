package com.java.d2helper.domain.ports;
import com.java.d2helper.domain.model.Terrorzone;
import java.util.Optional;

public interface TerrorzoneRepositoryPort {
    void deleteAll();
    Optional<Terrorzone> findById(Long id);
    void save(Terrorzone terrorzone);
}
