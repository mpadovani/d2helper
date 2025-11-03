package com.java.d2helper.application.ports.in;
import com.java.d2helper.domain.model.Zone;
import java.util.List;

public interface ZoneUseCaseInputPort {
    List<Zone> get();
}
