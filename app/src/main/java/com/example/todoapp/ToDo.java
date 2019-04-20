package com.example.todoapp;

import java.text.DateFormat;
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

    String getUuid() {
        return uuid;
    }

    String getTitle() {
        return title;
    }

    Date getDate() {
        return date;
    }

    String getFormattedDate() {
        return DateFormat.getDateInstance().format(date);
    }
}
