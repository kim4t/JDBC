package com.app.entity;

import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class Post {
    private int id;
    private String message;
    private String name;
    private boolean pub;
    private String dateTime;

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return dateTime;
    }

    private int hit;
    public Post(int id, String message, String name, boolean pub, String dateTime, int hit) {
        this.id = id;
        this.message = message;
        this.name = name;
        this.pub = pub;
        this.dateTime = dateTime;
        this.hit = hit;
    }

    public Post(String message, String name, boolean pub, int hit) {
        this.message = message;
        this.name = name;
        this.pub = pub;
        this.hit = hit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPub() {
        return pub;
    }

    public void setPub(boolean pub) {
        this.pub = pub;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }
}
