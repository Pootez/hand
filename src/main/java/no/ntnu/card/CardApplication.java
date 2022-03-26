package no.ntnu.card;

import javafx.application.Application;
import javafx.stage.Stage;

public class CardApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setMaxWidth(800);
        primaryStage.setMaxHeight(800);

        primaryStage.setTitle("Card thing :)");
        primaryStage.show();
    }

    @Override
    public void stop() {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
