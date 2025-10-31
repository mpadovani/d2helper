package com.java.d2helper.infrastructure.zone.mapper;
import com.java.d2helper.domain.model.Zone;
import com.java.d2helper.infrastructure.zone.model.ZoneEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ZoneMapper {
    public List<Zone> toDomain(List<ZoneEntity> entities) {
        if (entities == null) {
            return List.of();
        }

        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    public Zone toDomain(ZoneEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Zone(
                entity.getZone(),
                entity.getAct(),
                entity.getImmunities() != null ? entity.getImmunities() : List.of()
        );
    }
}