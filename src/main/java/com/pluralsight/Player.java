package com.pluralsight;

public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public int getScore() {
        return hand.getValue();
    }

    @Override
    public String toString() {
        return name + " (" + getScore() + " points)";
    }
}