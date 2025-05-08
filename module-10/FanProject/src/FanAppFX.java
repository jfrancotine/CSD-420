//Jose Franco
//05/06/2025
//M10 - Programming Assignment
//JavaFX to view and update fan records in a MySQL database using JDBC

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.sql.*;

public class FanAppFX extends Application {

    //text fields for input
    private TextField idField = new TextField();
    private TextField firstNameField = new TextField();
    private TextField lastNameField = new TextField();
    private TextField teamField = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    private Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/databasedb";
        String user = "student1";
        String password = "pass";
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fan Database");

        //instructions
        Label instructions = new Label(""" 
            WELCOME TO THE DATABASE FANS APP!
            
            To display a fan's information:
              1. Enter the fan's ID (1–10).
              2. Click "Display".
            
            To update a fan's information:
              1. Enter the fan's ID (1–10).
              2. Edit First Name, Last Name, or Favorite Team.
              3. Click "Update".
            
            Make sure the ID exists before updating.
        """);
        instructions.setWrapText(true);
        instructions.setPadding(new Insets(10, 10, 10, 10));
        instructions.getStyleClass().add("instructions-label");

        // layout for input fields using GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setHgap(10);
        grid.setVgap(10);

        // add labels and input fields to the grid
        grid.add(new Label("ID:"), 0, 0);
        grid.add(idField, 1, 0);

        grid.add(new Label("First Name:"), 0, 1);
        grid.add(firstNameField, 1, 1);

        grid.add(new Label("Last Name:"), 0, 2);
        grid.add(lastNameField, 1, 2);

        grid.add(new Label("Favorite Team:"), 0, 3);
        grid.add(teamField, 1, 3);

        // buttons for display and update
        Button displayBtn = new Button("Display");
        Button updateBtn = new Button("Update");

        displayBtn.getStyleClass().add("action-button");
        updateBtn.getStyleClass().add("action-button");

        // add button actions
        displayBtn.setOnAction(e -> displayRecord());
        updateBtn.setOnAction(e -> updateRecord());

        // center buttons and add spacing
        HBox buttonBox = new HBox(50, displayBtn, updateBtn); // increased spacing between buttons
        buttonBox.setAlignment(Pos.CENTER); // center the buttons horizontally
        buttonBox.setPadding(new Insets(0, 0, 0, 0)); // space at the top and bottom of buttons

        // main vertical layout
        VBox layout = new VBox(instructions, grid, new Region(), buttonBox); // add a spacer above buttons
        layout.setSpacing(20); // increased spacing between instructions and form
        layout.setPadding(new Insets(20));

        // create the scene and apply custom CSS styles
        Scene scene = new Scene(layout);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // show the stage
        primaryStage.setScene(scene);
        primaryStage.sizeToScene(); // Resize window to fit content
        primaryStage.show();
    }

    // method to display a fan's record by ID
    private void displayRecord() {
        try (Connection conn = connect()) {
            String idText = idField.getText().trim();
            if (!idText.matches("\\d+")) {
                showAlert(Alert.AlertType.WARNING, "Please enter a valid numeric ID.");
                return;
            }

            int id = Integer.parseInt(idText);

            if (id < 1 || id > 10) {
                showAlert(Alert.AlertType.WARNING, "ID must be between 1 and 10.");
                return;
            }

            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT firstname, lastname, favoriteteam FROM fans WHERE ID = ?");
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                firstNameField.setText(rs.getString("firstname"));
                lastNameField.setText(rs.getString("lastname"));
                teamField.setText(rs.getString("favoriteteam"));
            } else {
                showAlert(Alert.AlertType.INFORMATION, "No record found with ID " + id);
            }

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error: " + e.getMessage());
        }
    }

    // method to update a fan's record by ID
    private void updateRecord() {
        try (Connection conn = connect()) {
            String idText = idField.getText().trim();
            if (!idText.matches("\\d+")) {
                showAlert(Alert.AlertType.WARNING, "Please enter a valid numeric ID.");
                return;
            }

            int id = Integer.parseInt(idText);

            if (id < 1 || id > 10) {
                showAlert(Alert.AlertType.WARNING, "ID must be between 1 and 10.");
                return;
            }

            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?");
            stmt.setString(1, firstNameField.getText());
            stmt.setString(2, lastNameField.getText());
            stmt.setString(3, teamField.getText());
            stmt.setInt(4, id);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Record updated successfully.");
                // Clear the input fields after the update
                idField.clear();
                firstNameField.clear();
                lastNameField.clear();
                teamField.clear();
            } else {
                showAlert(Alert.AlertType.WARNING, "No record found with ID " + id);
            }

        } catch (Exception e) {
            showAlert(Alert.AlertType.ERROR, "Error: " + e.getMessage());
        }
    }


    private void showAlert(Alert.AlertType type, String msg) {
        Alert alert = new Alert(type, msg, ButtonType.OK);
        alert.showAndWait();
    }
}
