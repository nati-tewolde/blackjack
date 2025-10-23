package com.pluralsight;

public class Card {
    private String suit;
    private String value;
    private boolean isFaceUp;

    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = true;
    }

    public String getSuit() {
        return isFaceUp ? suit : "#";
    }

    public String getValue() {
        return isFaceUp ? value : "#";
    }

    public int getPointValue() {
        if (!isFaceUp) return 0;

        switch (value) {
            case "A":
                return 11;
            case "K":
            case "Q":
            case "J":
                return 10;
            default:
                return Integer.parseInt(value);
        }
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}