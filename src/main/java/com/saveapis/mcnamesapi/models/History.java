package com.saveapis.mcnamesapi.models;

import java.util.Date;

public class History {
    private int id;
    private Name player;
    private String historyName;
    private Date from;
    private Date to;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getPlayer() {
        return player;
    }

    public void setPlayer(Name player) {
        this.player = player;
    }

    public String getHistoryName() {
        return historyName;
    }

    public void setHistoryName(String historyName) {
        this.historyName = historyName;
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
