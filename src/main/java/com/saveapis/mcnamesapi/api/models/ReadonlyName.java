package com.saveapis.mcnamesapi.api.models;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.UUID;

public record ReadonlyName(@NotNull UUID uuid, @NotNull String name, @NotNull Date since) {
    public static @NotNull ReadonlyName empty() {
        return new ReadonlyName(new UUID(0L, 0L), "", new Date(System.currentTimeMillis()));
    }
}
