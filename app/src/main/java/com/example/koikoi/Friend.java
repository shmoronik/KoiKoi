package com.example.koikoi;

public class Friend {
    private String Uid, Uname, pfp;
    private int Win, Loss;

    public Friend() {
        Uid = "";
    }

    public Friend(User user) {
        Uid = user.getuId();
        Uname = user.getuName();
        pfp = user.getPfp();
    }

    public Friend(String uname, int win, int loss) {
        Uname = uname;
        Win = win;
        Loss = loss;
    }

    public String getUid() {return Uid;}
    public void setUid(String uid) {Uid = uid;}
    public String getUname() { return Uname; }
    public void setUname(String uname) {Uname = uname;}

    public int getWin() {return Win;}
    public void addWin() {Win += 1;}

    public int getLoss() {return Loss;}
    public void addLoss() {Loss += 1;}
}