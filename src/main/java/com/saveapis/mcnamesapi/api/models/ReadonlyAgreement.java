package com.saveapis.mcnamesapi.api.models;

import java.util.UUID;

public record ReadonlyAgreement(UUID uuid, boolean agreeValue) {
}
