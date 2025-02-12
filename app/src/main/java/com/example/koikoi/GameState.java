package com.example.koikoi;

import java.util.ArrayList;

public class GameState {
    private String lName, lPass, lID;
    private Friend player1, player2;
    private ArrayList<User> spectators;
    private int player1_points, player2_points;
    private Card.Season round;
    private Deck deck, player1_hand, player2_hand, table;

    private int pCard, tCard;

    public GameState(){}

    public GameState(Friend user1, String name, String id) {
        player1 = user1;
        lName = name;
        player1_points = 0;
        player2_points = 0;
        lID = id;
        RoundSetup();
    }

    public void RoundSetup() {
        deck = new Deck();
        player1_hand = new Deck(deck);
        player2_hand = new Deck(deck);
        table = new Deck(deck);
        if (round == null) round = Card.Season.January;
        else round = round.next();
    }

    public Deck getPlayer1_hand() {
        return player1_hand;
    }

    public Deck getPlayer2_hand() {
        return player2_hand;
    }

    public Deck getTable() {
        return table;
    }
    public Deck getDeck() {return deck;}

    public Friend getPlayer1() {return player1;}
    public Friend getPlayer2() {return player2;}

    public String getlName() {
        return lName;
    }

    public String getlID() {
        return lID;
    }

    public int getPlayer1_points() {return player1_points;}
    public int getPlayer2_points() {return player2_points;}

    public Card.Season getRound() {return round;}

    public String getPlayerNames() {
        if (player2==null)
            return String.format("%s / empty", player1.getUname());
        return String.format("%s / %s", player1.getUname(), player2.getUname());
    }

    public boolean isP1(String uId) {return uId.equals(this.player1.getUid());}
    public boolean isP2(String uId) {return uId.equals(this.player2.getUid());}

    public boolean isFull() {
        return player2 != null;
    }

    public boolean isPub() {
        return lPass == null || lPass == "";
    }
}
