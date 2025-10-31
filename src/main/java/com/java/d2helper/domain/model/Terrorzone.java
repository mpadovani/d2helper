package com.java.d2helper.domain.model;

public class Terrorzone {
    private Long id;
    private String current_zone;
    private String current_act;
    private String next_zone;
    private String next_act;

    public Terrorzone(Long id, String current_zone, String current_act, String next_zone, String next_act) {
        this.id = id;
        this.current_zone = current_zone;
        this.current_act = current_act;
        this.next_zone = next_zone;
        this.next_act = next_act;
    }

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
