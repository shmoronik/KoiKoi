package com.example.koikoi;

import java.util.ArrayList;

public class User {
    private String email, uName, uId;
    private  int Gplayed, Gwins, Glost;
    private ArrayList<String> Friends;

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public User(String email, String uName) {
        this.email = email;
        this.uName = uName;
    }
}
