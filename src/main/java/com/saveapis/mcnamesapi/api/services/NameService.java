package com.saveapis.mcnamesapi.api.services;

import com.saveapis.mcnamesapi.api.models.ReadonlyName;
import com.saveapis.mcnamesapi.api.utils.ReadonlyCollection;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Service to access the Name of a player
 *
 * @author SaveFeelix
 * @version 1.0
 */
public final class NameService {
    /**
     * Default Constructor
     *
     * @throws IllegalAccessException You are not allowed to use the constructor. All methods are static!
     */
    public NameService() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static @NotNull ReadonlyName byUuid(@NotNull UUID uuid) {
        return null;
    }

    public static @NotNull ReadonlyCollection<ReadonlyName> byHistoryName(@NotNull String historyName) {
        return null;
    }
}
