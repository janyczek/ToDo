package main.window;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class MainWindow extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox MainPain = FXMLLoader.load(getClass().getResource("/MainWindow.fxml"));
        Scene scene = new Scene(MainPain);
        stage.setScene(scene);
        stage.setTitle("NEW THING TO DO");
        stage.show();

    }
}
