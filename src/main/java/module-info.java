module FirstApp {


    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires mysql.connector.java;
    requires com.google.protobuf;
    requires java.sql;

    opens controllers to javafx.fxml;

    exports controllers;
    exports main.window;


}