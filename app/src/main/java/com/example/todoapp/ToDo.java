package com.example.todoapp;

import java.util.Date;
import java.util.UUID;

public class ToDo {
    private String uuid;
    private String title;
    private Date date;

    public ToDo(String title, Date date) {
        uuid = UUID.randomUUID().toString();
        this.title = title;
        this.date = date;
    }

    public String getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }
}
