package no.ntnu.card;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CardApplication extends Application {

    private CardController ct;
    private ListView<String> results;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setWidth(800);
        primaryStage.setHeight(733);
        primaryStage.setMaxWidth(800);
        primaryStage.setMaxHeight(733);

        VBox root = new VBox();

        Canvas canvas = new Canvas(800,600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);
        root.setOnMouseMoved(event ->
                ct.updateCanvas(event));

        ObservableList<String> items = FXCollections.observableArrayList(
                "Sum of faces", "Cards of hearts", "Flush", "Queen of spades"
        );
        ListView<String> first = new ListView<>(items);
        ObservableList<String> resultsString = FXCollections.observableArrayList(
                "", "", "", ""
        );
        results = new ListView<>(resultsString);

        Button btn = new Button();
        btn.setText("Deal Hand");
        btn.setOnAction(event ->
                results.setItems(ct.onDrawHandClick()));

        HBox hBox = new HBox();
        hBox.getChildren().add(first);
        hBox.getChildren().add(results);
        hBox.getChildren().add(btn);
        root.getChildren().add(hBox);

        Scene scene = new Scene(root,800,800,Color.DIMGRAY);
        ct = new CardController(gc);
        primaryStage.setTitle("Card thing :)");
        primaryStage.setScene(scene);
        primaryStage.show();
        ct.drawBackGround();
    }

    @Override
    public void stop() {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
