package com.saveapis.mcnamesapi.api.types;

public enum Languages {
    DEUTSCH("de"),
    ENGLISH("en")
    ;

    private final String identifier;

    Languages(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
