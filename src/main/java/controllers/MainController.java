package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import main.window.WriteFile;

public class MainController {

    WriteFile writeFile = new WriteFile();

    @FXML
    private TextArea MainTextArea;

    @FXML
    private Slider MainSlider;

    @FXML
    private Label PriorityValue;

    @FXML
    private Button MainButton;


    public void initialize() {

        //IF BOTTOM CLICKED

        MainButton.setOnAction(actionEvent -> {
            wantToSave();
        });

        //IF ENTER PUSHED

        MainTextArea.addEventFilter(KeyEvent.KEY_TYPED, x -> {

                    if (MainTextArea.getText().endsWith("\n")) {
                        wantToSave();
                    }
                }
        );

        //VISUALISATION OF PRIORITY

        PriorityValue.textProperty().bind(MainSlider.valueProperty().asString());


    }

    private void wantToSave() {
        int pro=MainSlider.valueProperty().intValue();
        String text = MainTextArea.getText();
        writeFile.write(text.trim(), pro);
        MainTextArea.clear();
    }
}