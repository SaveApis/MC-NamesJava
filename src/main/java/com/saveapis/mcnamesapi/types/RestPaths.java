package com.saveapis.mcnamesapi.types;

public enum RestPaths {
    AGREEMENT("Agreement"),
    HISTORY("History"),
    NAME("Name"),
    UUID("Uuid"),
    TRANSLATION("Translation"),
    ;

    private final String path;

    RestPaths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
