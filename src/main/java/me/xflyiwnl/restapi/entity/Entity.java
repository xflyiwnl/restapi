package me.xflyiwnl.restapi.entity;

import org.json.JSONObject;

import java.util.UUID;

public abstract class Entity {

    private UUID uniqueId;
    private String name;

    public Entity() {
    }

    public Entity(UUID uniqueId, String name) {
        this.uniqueId = uniqueId;
        this.name = name;
    }

    public JSONObject toJSON() {
        return null;
    }

    public UUID getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(UUID uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
