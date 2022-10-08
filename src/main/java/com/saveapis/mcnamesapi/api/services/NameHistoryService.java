package com.saveapis.mcnamesapi.api.services;

import com.saveapis.mcnamesapi.api.models.ReadonlyHistoryName;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Service to access the NameHistory of a player
 *
 * @author SaveFeelix
 * @version 1.0
 */
public final class NameHistoryService {
    /**
     * Default Constructor
     *
     * @throws IllegalAccessException You are not allowed to use the constructor. All methods are static!
     */
    public NameHistoryService() throws IllegalAccessException {
        throw new IllegalAccessException();
    }


    public static @NotNull ReadonlyHistoryName byUuid(UUID uuid) {
        return null;
    }

    public static @NotNull ReadonlyHistoryName byName(String name) {
        return null;
    }
}
