package com.saveapis.mcnamesapi.models;

import com.saveapis.mcnamesapi.api.utils.ReadonlyCollection;

public class HistoryName {
    private Name name;
    private ReadonlyCollection<HistNameDateRelation> histNameDateCollection;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public ReadonlyCollection<HistNameDateRelation> getHistNameDateCollection() {
        return histNameDateCollection;
    }

    public void setHistNameDateCollection(ReadonlyCollection<HistNameDateRelation> histNameDateCollection) {
        this.histNameDateCollection = histNameDateCollection;
    }
}

