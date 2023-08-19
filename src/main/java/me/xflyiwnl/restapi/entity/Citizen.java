package me.xflyiwnl.restapi.entity;

import org.json.JSONObject;

import java.util.UUID;

public class Citizen extends Entity {

    private UUID city;
    private String registered;
    private String joinedCity;

    public Citizen() {
    }

    public Citizen(UUID uniqueId, String name, UUID city, String registered, String joinedCity) {
        super(uniqueId, name);
        this.city = city;
        this.registered = registered;
        this.joinedCity = joinedCity;
    }

    @Override
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("uniqueId", getUniqueId().toString());
        json.put("name", getName());
        json.put("city", city.toString());
        json.put("registered", registered);
        json.put("joinedCity", joinedCity);
        return json;
    }

    @Override
    public String toString() {
        JSONObject json = new JSONObject();
        json.put("uniqueId", getUniqueId().toString());
        json.put("name", getName());
        json.put("city", city.toString());
        json.put("registered", registered);
        json.put("joinedCity", joinedCity);
        return json.toString();
    }

    public UUID getCity() {
        return city;
    }

    public void setCity(UUID city) {
        this.city = city;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getJoinedCity() {
        return joinedCity;
    }

    public void setJoinedCity(String joinedCity) {
        this.joinedCity = joinedCity;
    }
}
