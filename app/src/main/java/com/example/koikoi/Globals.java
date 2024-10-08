package com.example.koikoi;

import android.app.Application;
import java.util.ArrayList;

public class Globals extends Application {
    private String uName = "";


    public String getUName(){
        return this.uName;
    }

    public void setUName(String u){
        this.uName = u;
    }

}