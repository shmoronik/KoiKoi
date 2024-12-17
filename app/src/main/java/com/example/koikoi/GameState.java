package com.example.koikoi;

import java.util.ArrayList;

public class GameState {
    private String lName, lPass;
    private User player1, player2;
    private ArrayList<User> spectators;
    private int player1_points, player2_points;
    private Card.Season round;
    private Deck deck, pHand, eHand, table;

    public GameState(){}

    public GameState(User player, String name) {
        player1 = player;
        lName = name;
        player1_points = 0;
        player2_points = 0;
        round = Card.Season.January;
    }

    public void RoundSetup() {
        deck = new Deck();
        pHand = new Deck(deck);
        eHand = new Deck(deck);
        table = new Deck(deck);
    }

    public Deck getpHand() {
        return pHand;
    }

    public Deck geteHand() {
        return eHand;
    }

    public Deck getTable() {
        return table;
    }

    public String getlName() {
        return lName;
    }

    public String getPlayerNames() {
        if (player2==null)
            return String.format("%s / empty", player1.getuName());
        return String.format("%s / %s2", player1.getuName(), player2.getuName());
    }

    public boolean isFull() {
        return player2 != null;
    }

    public boolean isPub() {
        return lPass == null || lPass == "";
    }
}
