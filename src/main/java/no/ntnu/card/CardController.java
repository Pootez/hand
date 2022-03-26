package no.ntnu.card;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

/**
 * Controller for the application events.
 *
 * @author sondr
 * @version 2022-03-26
 */

public class CardController {

    private Deck deck;
    private Hand hand;
    private GraphicsContext gc;

    /**
     * Constructs the controller for the application with a deck, hand and the graphics context of the canvas.
     *
     * @param gc GraphicsContext of the application canvas
     */

    public CardController(GraphicsContext gc) {
        this.gc = gc;
        deck = new Deck();
        hand = new Hand();
    }

    /**
     * Handles the Deal Hand button event.
     *
     * @return ObservableList for the results of checking the hand
     */

    public ObservableList<String> onDealHandClick() {
        deck = new Deck();
        hand = new Hand(deck.dealHand(7));
        drawCards(0,0);
        return FXCollections.observableArrayList(
                String.valueOf(hand.sumFaces()),
                hand.getHearts(),
                String.valueOf(hand.hasFlush()),
                String.valueOf(hand.hasQueenOfSpades())
        );
    }

    /**
     * Handles mousemovement on the application where the canvas should update.
     *
     * @param event MouseEvent
     */

    public void updateCanvas(MouseEvent event) {
        double x = event.getSceneX();
        double y = event.getSceneY();

        drawBackGround();
        drawCards(x,y);
    }

    /**
     * Draws the all the cards and the card the mouse is hovering.
     *
     * @param x Mouse's x-position
     * @param y Mouse's y-position
     */

    private void drawCards(double x, double y) {
        if (!hand.getCards().isEmpty()) {
            gc.setFill(Color.WHITESMOKE);
            gc.setStroke(Color.BLACK);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setFont(new Font(100));
            float visableEdge = 340 / (float) hand.getCards().size();
            for (int i = 1; i <= hand.getCards().size(); i++) {
                gc.setFill(Color.WHITE);
                gc.fillRoundRect(i*50,50,360,500,25,25);
                gc.strokeRoundRect(i*50,50,360,500,25,25);
                char suit = hand.getCards().get(i-1).getSuit();
                Color temp = suit == 'S' || suit == 'C' ? Color.BLACK : Color.RED;
                gc.setFill(temp);
                gc.fillText(hand.getCards().get(i-1).getAsString(),50*i+180,300);
                gc.strokeText(hand.getCards().get(i-1).getAsString(),50*i+180,300);
            }
            if (y > 50 && y < 550 && x > 50 && x < 750) {
                int card = (int) Math.floor((x-50)/visableEdge) + 1;
                if (card <= hand.getCards().size()) {
                    gc.setFill(Color.WHITE);
                    gc.fillRoundRect(card*50,50,360,500,25,25);
                    gc.strokeRoundRect(card*50,50,360,500,25,25);
                    char suit = hand.getCards().get(card-1).getSuit();
                    Color temp = suit == 'S' || suit == 'C' ? Color.BLACK : Color.RED;
                    gc.setFill(temp);
                    gc.fillText(hand.getCards().get(card-1).getAsString(),50*card+180,300);
                    gc.strokeText(hand.getCards().get(card-1).getAsString(),50*card+180,300);
                }
            }
        }
    }

    /**
     * Draws a gray background.
     */

    public void drawBackGround() {
            gc.setFill(Color.DIMGRAY);
            gc.fillRect(0,0,800,600);
    }
}
