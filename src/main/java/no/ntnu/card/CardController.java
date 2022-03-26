package no.ntnu.card;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class CardController {

    private Deck deck;
    private Hand hand;
    private GraphicsContext gc;

    public CardController(GraphicsContext gc) {
        this.gc = gc;
        deck = new Deck();
        hand = new Hand();
    }

    public ObservableList<String> onDrawHandClick() {
        System.out.println("gaming");
        deck = new Deck();
        hand = new Hand(deck.dealHand(7));
        drawCards(hand.getCards().size()-1);
        return checkHand();
    }

    public void updateCanvas(MouseEvent event) {
        double x = event.getSceneX();
        double y = event.getSceneY();

        drawBackGround();
        drawCards(hand.getCards().size()-1);
        gc.setFill(Color.BLUE);
        gc.fillRect(x-5,y-5,10,10);
    }

    private void drawCards(int top) {
    }

    private void drawBackGround() {
            gc.setFill(Color.DIMGRAY);
            gc.fillRect(0,0,800,600);
    }


    private ObservableList<String> checkHand() {
        return FXCollections.observableArrayList(
                String.valueOf(hand.sumFaces()),
                hand.getHearts(),
                String.valueOf(hand.hasQueenOfSpades()),
                String.valueOf(hand.hasStraight())
                );
    }
}
