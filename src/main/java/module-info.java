module FirstApp {


    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens controllers to javafx.fxml;

    exports controllers;
    exports main.window;


}