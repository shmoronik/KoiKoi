package com.example.koikoi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        InitializeDeck();
        Shuffle();
    }

    private void InitializeDeck() {
        // Jan
        Card.Season season = Card.Season.January;
        cards.add(new Card(season, Card.Type.Bright));
        cards.add(new Card(season, Card.Type.Ribbon, 1));
        cards.add(new Card(season, Card.Type.Chaff, 1));
        cards.add(new Card(season, Card.Type.Chaff, 2));
        //Feb
        season = Card.Season.February;
        cards.add(new Card(season, Card.Type.Animal));
        cards.add(new Card(season, Card.Type.Ribbon, 1));
        cards.add(new Card(season, Card.Type.Chaff, 1));
        cards.add(new Card(season, Card.Type.Chaff, 2));
        //Mar
        season = Card.Season.March;
        cards.add(new Card(season, Card.Type.Bright));
        cards.add(new Card(season, Card.Type.Ribbon, 1));
        cards.add(new Card(season, Card.Type.Chaff, 1));
        cards.add(new Card(season, Card.Type.Chaff, 2));
        //Apr
        season = Card.Season.April;
        cards.add(new Card(season, Card.Type.Animal));
        cards.add(new Card(season, Card.Type.Ribbon));
        cards.add(new Card(season, Card.Type.Chaff, 1));
        cards.add(new Card(season, Card.Type.Chaff, 2));
        //May
        season = Card.Season.May;
        cards.add(new Card(season, Card.Type.Animal));
        cards.add(new Card(season, Card.Type.Ribbon));
        cards.add(new Card(season, Card.Type.Chaff, 1));
        cards.add(new Card(season, Card.Type.Chaff, 2));
        //Jun
        season = Card.Season.June;
        cards.add(new Card(season, Card.Type.Animal));
        cards.add(new Card(season, Card.Type.Ribbon, 2));
        cards.add(new Card(season, Card.Type.Chaff, 1));
        cards.add(new Card(season, Card.Type.Chaff, 2));
        //Jul
        season = Card.Season.July;
        cards.add(new Card(season, Card.Type.Animal));
        cards.add(new Card(season, Card.Type.Ribbon));
        cards.add(new Card(season, Card.Type.Chaff, 1));
        cards.add(new Card(season, Card.Type.Chaff, 2));
        //Aug
        season = Card.Season.August;
        cards.add(new Card(season, Card.Type.Bright));
        cards.add(new Card(season, Card.Type.Animal));
        cards.add(new Card(season, Card.Type.Chaff, 1));
        cards.add(new Card(season, Card.Type.Chaff, 2));
        //Sep
        season = Card.Season.September;
        cards.add(new Card(season, Card.Type.Animal));
        cards.add(new Card(season, Card.Type.Ribbon, 2));
        cards.add(new Card(season, Card.Type.Chaff, 1));
        cards.add(new Card(season, Card.Type.Chaff, 2));
        //Oct
        season = Card.Season.October;
        cards.add(new Card(season, Card.Type.Animal));
        cards.add(new Card(season, Card.Type.Ribbon, 2));
        cards.add(new Card(season, Card.Type.Chaff, 1));
        cards.add(new Card(season, Card.Type.Chaff, 2));
        //Nov
        season = Card.Season.November;
        cards.add(new Card(season, Card.Type.Bright));
        cards.add(new Card(season, Card.Type.Ribbon));
        cards.add(new Card(season, Card.Type.Animal));
        cards.add(new Card(season, Card.Type.Chaff));
        //Dec
        season = Card.Season.December;
        cards.add(new Card(season, Card.Type.Bright));
        cards.add(new Card(season, Card.Type.Chaff, 1));
        cards.add(new Card(season, Card.Type.Chaff, 2));
        cards.add(new Card(season, Card.Type.Chaff, 3));
    }
    private void Shuffle() {
        Collections.shuffle(cards);
    }
}
