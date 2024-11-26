package com.example.koikoi;

import android.graphics.drawable.LayerDrawable;

import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;

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

    public Deck(Deck deck) {
        cards = new ArrayList<>();
        for(int i=0; i<8; i++)
            cards.add(deck.draw());
    }

    public Card draw() {
        return cards.remove(0);
    }

    public int getImg(int i) {
        return cards.get(i).getImg();
    }

    private void InitializeDeck() {
        // Jan
        Card.Season season = Card.Season.January;
        cards.add(new Card(R.drawable._10, season, Card.Type.Bright));
        cards.add(new Card(R.drawable._11, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._12, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._13, season, Card.Type.Chaff));
        //Feb
        season = Card.Season.February;
        cards.add(new Card(R.drawable._20, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._21, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._22, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._23, season, Card.Type.Chaff));
        //Mar
        season = Card.Season.March;
        cards.add(new Card(R.drawable._30, season, Card.Type.Bright));
        cards.add(new Card(R.drawable._31, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._32, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._33, season, Card.Type.Chaff));
        //Apr
        season = Card.Season.April;
        cards.add(new Card(R.drawable._40, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._41, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._42, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._43, season, Card.Type.Chaff));
        //May
        season = Card.Season.May;
        cards.add(new Card(R.drawable._50, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._51, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._52, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._53, season, Card.Type.Chaff));
        //Jun
        season = Card.Season.June;
        cards.add(new Card(R.drawable._60, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._61, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._62, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._63, season, Card.Type.Chaff));
        //Jul
        season = Card.Season.July;
        cards.add(new Card(R.drawable._70, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._71, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._72, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._73, season, Card.Type.Chaff));
        //Aug
        season = Card.Season.August;
        cards.add(new Card(R.drawable._80, season, Card.Type.Bright));
        cards.add(new Card(R.drawable._81, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._82, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._83, season, Card.Type.Chaff));
        //Sep
        season = Card.Season.September;
        cards.add(new Card(R.drawable._90, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._91, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._92, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._93, season, Card.Type.Chaff));
        //Oct
        season = Card.Season.October;
        cards.add(new Card(R.drawable._100, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._101, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._102, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._103, season, Card.Type.Chaff));
        //Nov
        season = Card.Season.November;
        cards.add(new Card(R.drawable._110, season, Card.Type.Bright));
        cards.add(new Card(R.drawable._111, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._112, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._113, season, Card.Type.Chaff));
        //Dec
        season = Card.Season.December;
        cards.add(new Card(R.drawable._120, season, Card.Type.Bright));
        cards.add(new Card(R.drawable._121, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._122, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._123, season, Card.Type.Chaff));
    }
    private void Shuffle() {
        Collections.shuffle(cards);
    }
}
