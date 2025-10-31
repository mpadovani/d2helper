package com.java.d2helper.domain.model;
import java.util.List;

public class Zone {
    private String zone;
    private int act;
    private List<String> immunities;

    public Zone() {}

    public Zone(String zone, int act, List<String> immunities) {
        this.zone = zone;
        this.act = act;
        this.immunities = immunities;
    }

    public String getZone() { return zone; }
    public List<String> getImmunities() { return immunities; }
    public int getAct() { return act; }
}