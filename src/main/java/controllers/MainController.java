package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import main.window.WriteFile;

public class MainController {

    WriteFile writeFile = new WriteFile();

    @FXML
    private TextArea MainTextArea;

    @FXML
    private Button MainButton;


    public void initialize() {

        MainButton.setOnAction(actionEvent -> {
            wantToSave();
        });

        MainTextArea.addEventFilter(KeyEvent.KEY_TYPED, x -> {

                    if (MainTextArea.getText().endsWith("\n")) {
                        wantToSave();
                    }
                }
        );


    }

    private void wantToSave() {
        String text = MainTextArea.getText();
        writeFile.write(text.trim());
        MainTextArea.clear();
    }
}