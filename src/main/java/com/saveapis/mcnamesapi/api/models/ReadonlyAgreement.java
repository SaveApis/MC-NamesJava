package com.saveapis.mcnamesapi.api.models;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public record ReadonlyAgreement(@NotNull UUID uuid, @NotNull Boolean agreeValue) {
}
