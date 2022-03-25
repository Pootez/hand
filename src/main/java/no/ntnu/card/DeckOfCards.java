package no.ntnu.card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

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

    /**
     * Returns a hand of a specified number of cards.
     *
     * @param n Number of cards to be dealt
     * @return Collection of n playing cards
     */

    public ArrayList<PlayingCard> dealHand(int n) {
        if (n < 1 || n > 52) {
            throw new IllegalArgumentException("Not a valid number of cards");
        } else {
            ArrayList<PlayingCard> hand = new ArrayList<>();
            Random rand = new Random();
            for (int i = 0; i < n; i++) {
                int temp = rand.nextInt(cards.size());
                hand.add(cards.get(temp));
                cards.remove(temp);
            }
            return hand;
        }
    }

    public ArrayList<PlayingCard> getCards() {
        return cards;
    }

    public void setCards(ArrayList<PlayingCard> cards) {
        this.cards = cards;
    }
}
