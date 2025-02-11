package com.example.koikoi;

import java.util.ArrayList;

public class GameState {
    public String lName, lPass, lID;
    public String player1, player2;
    public ArrayList<User> spectators;
    public int player1_points, player2_points;
    public Card.Season round;
    public Deck deck, player1_hand, player2_hand, table;

    public GameState(){}

    public GameState(String player, String name, String id) {
        player1 = player;
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
            return String.format("%s / empty", player1);
        return String.format("%s / %s2", player1, player2);
    }

    public boolean isFull() {
        return player2 != null;
    }

    public boolean isPub() {
        return lPass == null || lPass == "";
    }
}
