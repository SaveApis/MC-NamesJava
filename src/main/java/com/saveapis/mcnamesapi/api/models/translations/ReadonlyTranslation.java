package com.saveapis.mcnamesapi.api.models.translations;

import com.saveapis.mcnamesapi.api.utils.ReadonlyCollection;
import org.jetbrains.annotations.NotNull;

public record ReadonlyTranslation(@NotNull ReadonlyTranslationInfo info,
                                  @NotNull ReadonlyCollection<@NotNull ReadonlyTranslationContent> content) {
}
