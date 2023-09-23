package com.driver;

import java.util.*;

public class Mail {

    private Date date;
    private String sender;
    private String message;


    public Mail(Date date, String sender, String message) {
        this.date = date;
        this.sender = sender;
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
