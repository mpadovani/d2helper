package com.java.d2helper.infrastructure.zone.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "terror_zones")
public class ZoneEntity {

    @Id
    private String id;

    @JsonProperty("zone")
    private String zone;
    @JsonProperty("act")
    private int act;
    @JsonProperty("immunities")
    private List<String> immunities;
    @JsonProperty("monster_density")
    private String monsterDensity;
    @JsonProperty("monster_level")
    private int monsterLevel;
    @JsonProperty("difficulty")
    private String difficulty;

    public ZoneEntity() {}

    public String getZone() { return zone; }
    public List<String> getImmunities() { return immunities; }
    public int getAct() { return act; }
}