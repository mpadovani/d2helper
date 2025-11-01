package com.java.d2helper.infrastructure.zone.adpter;
import com.java.d2helper.application.ports.out.ZoneRepositoryPort;
import com.java.d2helper.domain.model.Zone;
import com.java.d2helper.infrastructure.zone.mapper.ZoneMapper;
import com.java.d2helper.infrastructure.zone.repository.MongoZoneRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ZoneRepositoryAdapter implements ZoneRepositoryPort {
    MongoZoneRepository mongoZoneRepository;
    ZoneMapper zoneMapper;

    public ZoneRepositoryAdapter(MongoZoneRepository mongoZoneRepository, ZoneMapper zoneMapper) {
        this.mongoZoneRepository = mongoZoneRepository;
        this.zoneMapper = zoneMapper;
    }

    @Override
    public List<Zone> findAll() {
        return zoneMapper.toDomain(mongoZoneRepository.findAll());
    }
}
