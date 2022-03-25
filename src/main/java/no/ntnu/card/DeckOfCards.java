package no.ntnu.card;

import java.util.ArrayList;

/**
 * Represents a deck of cards.
 *
 * @author sondesp
 * @version 2022-03-25
 */

public class DeckOfCards {

    private final char[] suit = { 'S', 'H', 'D', 'C' };
    private ArrayList<PlayingCard> cards;

    /**
     * Constructs a deck of cards form an existing ArrayList.
     *
     * @param cards ArrayList of cards
     */

    public DeckOfCards(ArrayList<PlayingCard> cards) {
        this.cards = cards;
    }

    /**
     * Constructs a reguler deck of 52 cards.
     */

    public DeckOfCards() {
        cards = new ArrayList<>();
        for (char temp : suit) {
            for (int i = 1; i < 14; i++) {
                cards.add(new PlayingCard(temp,i));
            }
        }
    }

    public ArrayList<PlayingCard> getCards() {
        return cards;
    }

    public void setCards(ArrayList<PlayingCard> cards) {
        this.cards = cards;
    }
}
