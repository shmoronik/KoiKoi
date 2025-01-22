package com.example.koikoi;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Card {
    public enum Season {
        January, February, March, April, May, June, July, August, September, October, November, December;
        public Season next() {
            Season[] seasons = Season.values();
            int ordinal = this.ordinal();
            ordinal = ++ordinal % seasons.length;
            return seasons[ordinal];
        }
    }
    public enum Type {
        Bright, Animal, Ribbon, Chaff
    }

    private int img;
    private Season season;
    private Type type;

    public Card(){}

    public Card(int img, Season suit, Type type) {
        this.img = img;
        this.season = suit;
        this.type = type;
    }

    public int getImg() { return img; }

    public Season getSeason() {
        return season;
    }

    public Type getType() {
        return type;
    }

    public boolean isPair(Card card) {return card.getSeason()==season;}
}