package no.ntnu.card;

import java.util.ArrayList;

/**
 * Represents a hand of cards.
 *
 * @author sondesp
 * @version 2022-03-25
 */

public class Hand {

    private ArrayList<Card> cards;

    /**
     * Constructs a hand with a set ArrayList of cards.
     *
     * @param cards ArrayList of cards
     */
    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    /**
     * Constructs a hand with an empty Arraylist of cards.
     */

    public Hand() {
        cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }
}
