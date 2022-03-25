package no.ntnu.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void sumFaces() {
        Deck deck = new Deck();
        Hand hand = new Hand();

        hand.getCards().add(deck.getCards().get(0));
        hand.getCards().add(deck.getCards().get(1));
        hand.getCards().add(deck.getCards().get(2));

        assertEquals(6,hand.sumFaces());
        hand = new Hand(deck.dealHand(5));

        assertNotEquals(0,hand.sumFaces());
    }
}