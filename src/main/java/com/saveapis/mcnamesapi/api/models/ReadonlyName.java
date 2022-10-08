package com.saveapis.mcnamesapi.api.models;

import java.util.Date;
import java.util.UUID;

public record ReadonlyName(UUID uuid, String name, Date since) {
}
