package com.pluralsight;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void deal(Card card) {
        cards.add(card);
    }

    public int getValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            int cardValue = card.getPointValue();
            value += cardValue;
            if (card.getValue().equals("A")) {
                aceCount++;
            }
        }

        while (value > 21 && aceCount > 0) {
            value -= 10;
            aceCount--;
        }

        return value;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void showHand() {
        for (Card card : cards) {
            System.out.println(" - " + card);
        }
        System.out.println("Total: " + getValue());
    }
}