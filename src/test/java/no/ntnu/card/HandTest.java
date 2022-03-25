package no.ntnu.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    private Deck deck;
    private Hand hand;

    @BeforeEach
    void setup() {
        deck = new Deck();
        hand = new Hand();
    }

    @Test
    void sumFaces() {
        hand.getCards().add(deck.getCards().get(0));
        hand.getCards().add(deck.getCards().get(1));
        hand.getCards().add(deck.getCards().get(2));

        assertEquals(6,hand.sumFaces());
        hand = new Hand(deck.dealHand(5));

        assertNotEquals(0,hand.sumFaces());
    }

    @Test
    void getHearts() {
        hand.getCards().add(deck.getCards().get(13));
        hand.getCards().add(deck.getCards().get(14));
        hand.getCards().add(deck.getCards().get(15));
        assert(hand.getHearts().equals("H1 H2 H3"));

        hand = new Hand();
        assert(hand.getHearts().equals("No Cards"));

        hand.getCards().add(deck.getCards().get(0));
        hand.getCards().add(deck.getCards().get(1));
        hand.getCards().add(deck.getCards().get(2));
        assert(hand.getHearts().equals("No Hearts"));
        assert(!hand.getHearts().equals("No Cards"));
    }

    @Test
    void ifQueenOfSpades() {
        hand.setCards(deck.dealHand(26));
        Hand otherHand = new Hand(deck.dealHand(26));
        assert(hand.ifQueenOfSpades() != otherHand.ifQueenOfSpades());
    }
}