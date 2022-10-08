package com.saveapis.mcnamesapi.models;

import java.util.UUID;

public class Agreement {
    private UUID uuid;
    private Boolean agreeValue;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Boolean getAgreeValue() {
        return agreeValue;
    }

    public void setAgreeValue(Boolean agreeValue) {
        this.agreeValue = agreeValue;
    }
}
