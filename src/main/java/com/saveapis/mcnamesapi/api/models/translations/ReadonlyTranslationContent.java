package com.saveapis.mcnamesapi.api.models.translations;

import org.jetbrains.annotations.NotNull;

public record ReadonlyTranslationContent(@NotNull String key, @NotNull String translation,
                                         @NotNull String description) {
}
