package com.example.todoapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

public class ToDo {
    private String uuid;
    private String title;
    private Date date;
    private boolean completed;

    public ToDo(String title, Date date) {
        uuid = UUID.randomUUID().toString();
        this.title = title;
        this.date = date;
        this.completed = false;
    }

    public String getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFormattedDate() {
        return DateFormat.getDateInstance().format(date);
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
