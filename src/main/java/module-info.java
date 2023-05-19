module com.example.knk2023 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.knk2023 to javafx.fxml;
    exports com.example.knk2023;
}