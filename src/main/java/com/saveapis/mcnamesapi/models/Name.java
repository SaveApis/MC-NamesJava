package com.saveapis.mcnamesapi.models;

import java.util.Date;
import java.util.UUID;

public class Name {
    private UUID uuid;
    private String displayName;
    private Date since;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }
}
