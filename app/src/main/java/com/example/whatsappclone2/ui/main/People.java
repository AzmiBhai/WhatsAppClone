package com.example.whatsappclone2.ui.main;

import java.io.Serializable;

public class People implements Serializable {
    private String name,message,time;
    private int notification;

    public People(String name, String message, String time, int notification) {
        this.name = name;
        this.message = message;
        this.time = time;
        this.notification = notification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNotification() {
        return notification;
    }

    public void setNotification(int notification) {
        this.notification = notification;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", time='" + time + '\'' +
                ", notification=" + notification +
                '}';
    }
}
