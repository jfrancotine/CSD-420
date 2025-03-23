module com.example.rancardgen {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rancardgen to javafx.fxml;
    exports com.example.rancardgen;
}