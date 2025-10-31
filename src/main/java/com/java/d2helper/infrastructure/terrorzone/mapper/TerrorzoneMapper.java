package com.java.d2helper.infrastructure.terrorzone.mapper;
import com.java.d2helper.domain.model.Terrorzone;
import com.java.d2helper.infrastructure.terrorzone.model.TerrorzoneEntity;
import org.springframework.stereotype.Component;

@Component
public class TerrorzoneMapper {
    public Terrorzone toDomain(TerrorzoneEntity entity) {
        return new Terrorzone(entity.getId(), entity.getCurrent_zone(), entity.getCurrent_act(), entity.getNext_zone(), entity.getNext_act());
    }

    public TerrorzoneEntity toEntity(Terrorzone domain) {
        return new TerrorzoneEntity(domain.getId(), domain.getCurrent_zone(), domain.getCurrent_act(), domain.getNext_zone(), domain.getNext_act());
    }
}
