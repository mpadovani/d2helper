package com.java.d2helper.domain.ports;
import com.java.d2helper.domain.model.Zone;
import java.util.List;

public interface ZoneRepositoryPort {
    List<Zone> findAll();
}
