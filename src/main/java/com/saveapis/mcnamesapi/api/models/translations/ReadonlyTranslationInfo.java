package com.saveapis.mcnamesapi.api.models.translations;

import org.jetbrains.annotations.NotNull;

public record ReadonlyTranslationInfo(@NotNull String displayName, @NotNull String identifier) {
    
}
