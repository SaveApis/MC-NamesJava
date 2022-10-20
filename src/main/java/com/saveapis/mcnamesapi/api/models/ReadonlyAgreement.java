package com.saveapis.mcnamesapi.api.models;

import java.util.UUID;

public record ReadonlyAgreement(UUID uuid, boolean agreeValue) {
    public static ReadonlyAgreement empty() {
        return new ReadonlyAgreement(new UUID(0L, 0L), false);
    }
}
