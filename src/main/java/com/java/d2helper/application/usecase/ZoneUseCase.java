package com.java.d2helper.application.usecase;
import com.java.d2helper.application.ports.in.ZoneUseCaseInputPort;
import com.java.d2helper.application.ports.out.ZoneRepositoryPort;
import com.java.d2helper.domain.model.Zone;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ZoneUseCase implements ZoneUseCaseInputPort {
    private final ZoneRepositoryPort repository;

    public ZoneUseCase(ZoneRepositoryPort repository) {
        this.repository = repository;
    }

    public List<Zone> get() {
        return repository.findAll();
    }
}
