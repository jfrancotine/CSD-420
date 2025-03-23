//Jose Franco
//03/23/25
//M1 - Programming Assignment
//JavaFX program that displays four images randomly selected from a deck of 52 cards,
//hit button to refresh and select 4 more.

package com.example.rancardgen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class RanCarGen extends Application {

    private static final int CARD_COUNT = 52;
    private static final int DISPLAY_COUNT = 4;

    private final ImageView[] cardViews = new ImageView[DISPLAY_COUNT];

    @Override
    public void start(Stage primaryStage) {
        // title label
        Label titleLabel = new Label("Random Card Generator");
        titleLabel.setFont(Font.font("Comic Sans MS", 28));
        titleLabel.setAlignment(Pos.CENTER);

        // HBox for card images
        HBox cardBox = new HBox(10);
        cardBox.setPadding(new Insets(15));
        cardBox.setAlignment(Pos.CENTER);

        for (int i = 0; i < DISPLAY_COUNT; i++) {
            cardViews[i] = new ImageView();
            cardViews[i].setFitHeight(150);
            cardViews[i].setPreserveRatio(true);
            cardBox.getChildren().add(cardViews[i]);
        }

        // refresh button
        Button refreshButton = new Button("Shuffle Cards");
        refreshButton.setFont(Font.font("Arial", 16));

        // Lambda expression to handle button click
        refreshButton.setOnAction(e -> updateCards());

        // VBox layout
        VBox root = new VBox(20, titleLabel, cardBox, refreshButton);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));


        updateCards(); // Load initial cards

        Scene scene = new Scene(root, 650, 300);
        primaryStage.setTitle("Random Card Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    // Randomly selects and updates the images of 4 cards from the deck.

    private void updateCards() {
        ArrayList<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= CARD_COUNT; i++) {
            deck.add(i);
        }
        Collections.shuffle(deck);

        for (int i = 0; i < DISPLAY_COUNT; i++) {
            int cardNum = deck.get(i);
            String imagePath = "/cards/" + cardNum + ".png";
            Image img = new Image(getClass().getResourceAsStream(imagePath));
            cardViews[i].setImage(img);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
