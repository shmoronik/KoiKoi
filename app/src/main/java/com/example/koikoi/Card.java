package com.example.koikoi;

public class Card {
    public enum Season {
        January, February, March, April, May, June, July, August, September, October, November, December
    }
    public enum Type {
        Bright, Animal, Ribbon, Chaff
    }

    private Season season;
    private Type type;
    private int sub;

    public Card(Season suit, Type type, int sub) {
        this.season = suit;
        this.type = type;
        this.sub = sub;
    }

    public Card(Season season, Type type) {
        this.season = season;
        this.type = type;
    }

    public Season getSeason() {
        return season;
    }

    public Type getType() {
        return type;
    }

    public int getSub() {
        return sub;
    }
}