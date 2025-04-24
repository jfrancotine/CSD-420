module com.example.francocsscircle {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.francocsscircle to javafx.fxml;
    exports com.example.francocsscircle;
}