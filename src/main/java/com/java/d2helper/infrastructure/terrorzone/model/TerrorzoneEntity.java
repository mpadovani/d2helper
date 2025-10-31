package com.java.d2helper.infrastructure.terrorzone.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document(collection = "terrorzone")
public class TerrorzoneEntity {
    @Id
    private Long id;
    private String current_zone;
    private String current_act;
    private String next_zone;
    private String next_act;
    private Instant createdAt = Instant.now();

    public TerrorzoneEntity() {}

    public TerrorzoneEntity(Long id, String current_zone, String current_act, String next_zone, String next_act) {
        this.id = id;
        this.current_zone = current_zone;
        this.current_act = current_act;
        this.next_zone = next_zone;
        this.next_act = next_act;
    }

    public Long getId() { return id; }
    public String getCurrent_zone() { return current_zone; }
    public String getCurrent_act() { return current_act; }
    public String getNext_zone() { return next_zone; }
    public String getNext_act() { return next_act; }
}
