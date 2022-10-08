package com.saveapis.mcnamesapi.models;

import java.util.Date;

public class HistNameDateRelation {
    private String name;
    private Date from;
    private Date to;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}
