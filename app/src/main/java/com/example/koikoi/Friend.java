package com.example.koikoi;

public class Friend {
    private String Uid;
    private String Uname;
    private int Win;
    private int Loss;

    public Friend(String uname, int win, int loss) {
        Uname = uname;
        Win = win;
        Loss = loss;
    }

    public String getUid() {
        return Uid;
    }

    public String getUname() { return Uname; }

    public int getWin() {
        return Win;
    }

    public void addWin() {
        Win += 1;
    }

    public int getLoss() {
        return Loss;
    }

    public void addLoss() {
        Loss += 1;
    }
}