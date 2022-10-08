package com.saveapis.mcnamesapi.api.services;

import com.saveapis.mcnamesapi.api.models.translations.ReadonlyTranslationInfo;
import com.saveapis.mcnamesapi.api.models.translations.ReadonlyTranslationResult;
import com.saveapis.mcnamesapi.api.utils.ReadonlyCollection;
import org.jetbrains.annotations.NotNull;

/**
 * Service to access the translations provided by the REST-API
 *
 * @author SaveFeelix
 * @version 1.0
 */
public final class TranslationService {
    /**
     * Default Constructor
     *
     * @throws IllegalAccessException You are not allowed to use the constructor. All methods are static!
     */
    public TranslationService() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static @NotNull ReadonlyCollection<ReadonlyTranslationInfo> getAllTranslations() {
        return null;
    }

    public static @NotNull ReadonlyTranslationResult byIdentifier(String identifier) {
        return null;
    }
}
