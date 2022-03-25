package no.ntnu.card;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    private Deck deck;

    @BeforeEach
    void setup() {
        deck = new Deck();
    }

    @Test
    void getCards() {
        assertEquals(52, deck.getCards().size());
    }

    @Test
    void setCards() {
        deck.setCards(new ArrayList<>());
        assertEquals(0,deck.getCards().size());
    }

    @Test
    void dealHand() {
        ArrayList<Card> hand = deck.dealHand(5);
        assertEquals(5,hand.size());
        assertEquals(47, deck.getCards().size());
    }
}