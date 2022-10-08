package com.saveapis.mcnamesapi.api.services;

import com.saveapis.mcnamesapi.api.models.ReadonlyAgreement;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Service to access the Agreement of a player
 *
 * @author SaveFeelix
 * @version 1.0
 */
public final class AgreementService {
    /**
     * Default Constructor
     *
     * @throws IllegalAccessException You are not allowed to use the constructor. All methods are static!
     */
    public AgreementService() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    /**
     * Method to get the agreement value from the specific UUID <br />
     * If the given UUID has no entry in the REST-API the {@link ReadonlyAgreement#agreeValue()} is always false!
     *
     * @param uuid the UUID of the player
     * @return the current AgreementValue
     */
    public static @NotNull ReadonlyAgreement byUuid(UUID uuid) {
        return new ReadonlyAgreement(uuid, false);
    }
}
