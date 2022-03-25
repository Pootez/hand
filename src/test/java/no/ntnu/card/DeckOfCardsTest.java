package no.ntnu.card;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

    private DeckOfCards deck;

    @BeforeEach
    void setup() {
        deck = new DeckOfCards();
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
        ArrayList<PlayingCard> hand = deck.dealHand(5);
        assertEquals(5,hand.size());
        assertEquals(47, deck.getCards().size());
    }
}