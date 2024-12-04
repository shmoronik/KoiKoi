package com.example.koikoi;

public class GameState {
    private Deck deck, pHand, eHand, table;

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
}
