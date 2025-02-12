package com.example.koikoi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Deck implements Serializable {
    public ArrayList<Card> cards;

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
    public Card pull(int n){return cards.remove(n);}
    public Card choose(int n){return cards.get(n);}

    public int getImg(int i) {
        return cards.get(i).getImg();
    }

    public int size() {
        return cards.size();
    }

    private void InitializeDeck() {
        // Jan
        Card.Season season = Card.Season.January;
        cards.add(new Card(R.drawable._10, season, Card.Type.Bright));
        cards.add(new Card(R.drawable._11, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._12, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._13, season, Card.Type.Chaff));
        //Feb
        season = season.next();
        cards.add(new Card(R.drawable._20, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._21, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._22, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._23, season, Card.Type.Chaff));
        //Mar
        season = season.next();
        cards.add(new Card(R.drawable._30, season, Card.Type.Bright));
        cards.add(new Card(R.drawable._31, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._32, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._33, season, Card.Type.Chaff));
        //Apr
        season = season.next();
        cards.add(new Card(R.drawable._40, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._41, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._42, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._43, season, Card.Type.Chaff));
        //May
        season = season.next();
        cards.add(new Card(R.drawable._50, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._51, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._52, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._53, season, Card.Type.Chaff));
        //Jun
        season = season.next();
        cards.add(new Card(R.drawable._60, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._61, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._62, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._63, season, Card.Type.Chaff));
        //Jul
        season = season.next();
        cards.add(new Card(R.drawable._70, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._71, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._72, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._73, season, Card.Type.Chaff));
        //Aug
        season = season.next();
        cards.add(new Card(R.drawable._80, season, Card.Type.Bright));
        cards.add(new Card(R.drawable._81, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._82, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._83, season, Card.Type.Chaff));
        //Sep
        season = season.next();
        cards.add(new Card(R.drawable._90, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._91, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._92, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._93, season, Card.Type.Chaff));
        //Oct
        season = season.next();
        cards.add(new Card(R.drawable._100, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._101, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._102, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._103, season, Card.Type.Chaff));
        //Nov
        season = season.next();
        cards.add(new Card(R.drawable._110, season, Card.Type.Bright));
        cards.add(new Card(R.drawable._111, season, Card.Type.Animal));
        cards.add(new Card(R.drawable._112, season, Card.Type.Ribbon));
        cards.add(new Card(R.drawable._113, season, Card.Type.Chaff));
        //Dec
        season = season.next();
        cards.add(new Card(R.drawable._120, season, Card.Type.Bright));
        cards.add(new Card(R.drawable._121, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._122, season, Card.Type.Chaff));
        cards.add(new Card(R.drawable._123, season, Card.Type.Chaff));
    }
    private void Shuffle() {
        Collections.shuffle(cards);
    }
}
