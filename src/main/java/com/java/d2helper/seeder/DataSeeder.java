package com.java.d2helper.seeder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.d2helper.domain.model.Zone;
import com.java.d2helper.infrastructure.repository.MongoZoneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataSeeder {
    private final MongoZoneRepository zoneRepository;

    public DataSeeder(MongoZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    @Bean
    CommandLineRunner seedAll() {
        return args -> {
            seedZones();
        };
    }

    private void seedZones() {
        if (zoneRepository.count() == 0) {
            backupMongo("/diablo2_terror_zones.json");
        }
    }

    private void backupMongo(String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Zone>> typeReference = new TypeReference<>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream(fileName);
        try {
            List<Zone> zones = mapper.readValue(inputStream, typeReference);
            zoneRepository.saveAll(zones);
            System.out.println("Terror Zones inicializadas no MongoDB!");
        } catch (Exception e) {
            System.out.println("Erro ao popular dados: " + e.getMessage());
        }
    }
}