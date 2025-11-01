package com.java.d2helper.application.ports.out;
import com.java.d2helper.domain.model.Zone;
import java.util.List;

public interface ZoneRepositoryPort {
    List<Zone> findAll();
}
