package com.saveapis.mcnamesapi.models;

import java.util.Date;
import java.util.UUID;

public class Name {
    private UUID uuid;
    private String name;
    private Date since;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }
}
