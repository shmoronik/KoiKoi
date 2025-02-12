package com.example.koikoi;

import android.net.Uri;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class User {
    private String email, uName, uId;
    private  int Gplayed, Gwins, Glost;
    private ArrayList<Friend> Friends;
    private String pfp;

    public User() {
        this.uName = "guest";
        this.uId = "";
        this.pfp = "";
    }
    public String getPfp() {return pfp;}
    public void setPfp(String pfp) {this.pfp = pfp;}

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
        this.Gplayed = 0;
        this.Gwins = 0;
        this.Glost = 0;
    }

    public int getGplayed() {return Gplayed;}
    public int getGwins() {return Gwins;}
    public int getGlost() {return Glost;}

    public void GplayedInc(Boolean isWin) {
        this.Gplayed += 1;
        if (isWin)
            this.Gwins += 1;
        else
            this.Glost += 1;
    }

    public ArrayList<Friend> getFriends() {
        ArrayList<Friend> friends = new ArrayList<>();
        for(int i=1; i<15; i++){
            friends.add(new Friend("Friend "+i, (int)(Math.random()*100), (int)(Math.random()*100)));
        }
        return friends;
    }
}
