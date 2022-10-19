package com.saveapis.mcnamesapi.models;

import java.util.UUID;

public class Agreement {
    private UUID uuid;
    private Boolean agreementValue;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Boolean getAgreementValue() {
        return agreementValue;
    }

    public void setAgreementValue(Boolean agreementValue) {
        this.agreementValue = agreementValue;
    }
}
