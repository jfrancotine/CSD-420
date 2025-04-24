//Jose Franco
//04/23/2025
//M7-Programming Assignment
//Integrating a CSS Style with JavaFX displaying 4 circles matching assignment.

package com.example.francocsscircle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class FrancoCSSCircle extends Application {

    @Override
    public void start(Stage primaryStage) {
        // First white circle inside black border box
        Circle c1 = new Circle(40);
        c1.getStyleClass().add("plaincircle");

        StackPane c1Box = new StackPane(c1);
        c1Box.getStyleClass().add("border");
        c1Box.setMinSize(80, 400);
        c1Box.setStyle("-fx-alignment: center;");

        // Second white circle (not inside the box)
        Circle c2 = new Circle(40);
        c2.getStyleClass().add("plaincircle");

        // Red circle
        Circle c3 = new Circle(40);
        c3.setId("redcircle");

        // Green circle
        Circle c4 = new Circle(40);
        c4.setId("greencircle");

        // Horizontal layout for all four circles
        HBox hbox = new HBox(10, c1Box, c2, c3, c4);
        hbox.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Scene and stylesheet
        Scene scene = new Scene(hbox);
        scene.getStylesheets().add("mystyle.css");

        primaryStage.setTitle("Franco CSS Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
