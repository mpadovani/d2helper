package com.java.d2helper.domain.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "terrorzone")
public class Terrorzone {
    @Id
    private Long id;
    private String current_zone;
    private String current_act;
    private String next_zone;
    private String next_act;
    private Instant createdAt = Instant.now();

    public Terrorzone() {}

    public Terrorzone(Long id, TerrozoneApiResponse terrozoneApiResponse) {
        this.id = id;
        this.current_zone = terrozoneApiResponse.currentTerrorZone().zone();
        this.current_act = terrozoneApiResponse.currentTerrorZone().act();

        this.next_zone = terrozoneApiResponse.nextTerrorZone().zone();
        this.next_act = terrozoneApiResponse.nextTerrorZone().act();
    }
    
    public Long getId() { return id; }
    public String getCurrent_zone() { return current_zone; }
    public String getCurrent_act() { return current_act; }
    public String getNext_zone() { return next_zone; }
    public String getNext_act() { return next_act; }
}
