module com.example.st200535561assignment1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.st200535561assignment1 to javafx.fxml;
    exports com.example.st200535561assignment1;
}