package com.saveapis.mcnamesapi.api.models;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public record ReadonlyHistory(@NotNull String name, @NotNull Date from, @NotNull Date to) {
    public static @NotNull ReadonlyHistory empty() {
        return new ReadonlyHistory("", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
    }
}
