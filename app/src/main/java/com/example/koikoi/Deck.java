package com.example.koikoi;
import androidx.annotation.DrawableRes;

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
        cards.add(new Card(10, season, Card.Type.Bright));
        cards.add(new Card(11, season, Card.Type.Ribbon));
        cards.add(new Card(12, season, Card.Type.Chaff));
        cards.add(new Card(13, season, Card.Type.Chaff));
        //Feb
        season = Card.Season.February;
        cards.add(new Card(20, season, Card.Type.Animal));
        cards.add(new Card(21, season, Card.Type.Ribbon));
        cards.add(new Card(22, season, Card.Type.Chaff));
        cards.add(new Card(23, season, Card.Type.Chaff));
        //Mar
        season = Card.Season.March;
        cards.add(new Card(30, season, Card.Type.Bright));
        cards.add(new Card(31, season, Card.Type.Ribbon));
        cards.add(new Card(32, season, Card.Type.Chaff));
        cards.add(new Card(33, season, Card.Type.Chaff));
        //Apr
        season = Card.Season.April;
        cards.add(new Card(40, season, Card.Type.Animal));
        cards.add(new Card(41, season, Card.Type.Ribbon));
        cards.add(new Card(42, season, Card.Type.Chaff));
        cards.add(new Card(43, season, Card.Type.Chaff));
        //May
        season = Card.Season.May;
        cards.add(new Card(50, season, Card.Type.Animal));
        cards.add(new Card(51, season, Card.Type.Ribbon));
        cards.add(new Card(52, season, Card.Type.Chaff));
        cards.add(new Card(53, season, Card.Type.Chaff));
        //Jun
        season = Card.Season.June;
        cards.add(new Card(60, season, Card.Type.Animal));
        cards.add(new Card(61, season, Card.Type.Ribbon));
        cards.add(new Card(62, season, Card.Type.Chaff));
        cards.add(new Card(63, season, Card.Type.Chaff));
        //Jul
        season = Card.Season.July;
        cards.add(new Card(70, season, Card.Type.Animal));
        cards.add(new Card(71, season, Card.Type.Ribbon));
        cards.add(new Card(72, season, Card.Type.Chaff));
        cards.add(new Card(73, season, Card.Type.Chaff));
        //Aug
        season = Card.Season.August;
        cards.add(new Card(80, season, Card.Type.Bright));
        cards.add(new Card(81, season, Card.Type.Animal));
        cards.add(new Card(82, season, Card.Type.Chaff));
        cards.add(new Card(83, season, Card.Type.Chaff));
        //Sep
        season = Card.Season.September;
        cards.add(new Card(90, season, Card.Type.Animal));
        cards.add(new Card(91, season, Card.Type.Ribbon));
        cards.add(new Card(92, season, Card.Type.Chaff));
        cards.add(new Card(93, season, Card.Type.Chaff));
        //Oct
        season = Card.Season.October;
        cards.add(new Card(100, season, Card.Type.Animal));
        cards.add(new Card(101, season, Card.Type.Ribbon));
        cards.add(new Card(102, season, Card.Type.Chaff));
        cards.add(new Card(103, season, Card.Type.Chaff));
        //Nov
        season = Card.Season.November;
        cards.add(new Card(110, season, Card.Type.Bright));
        cards.add(new Card(111, season, Card.Type.Ribbon));
        cards.add(new Card(112, season, Card.Type.Animal));
        cards.add(new Card(113, season, Card.Type.Chaff));
        //Dec
        season = Card.Season.December;
        cards.add(new Card(120, season, Card.Type.Bright));
        cards.add(new Card(121, season, Card.Type.Chaff));
        cards.add(new Card(122, season, Card.Type.Chaff));
        cards.add(new Card(123, season, Card.Type.Chaff));
    }
    private void Shuffle() {
        Collections.shuffle(cards);
    }
}
