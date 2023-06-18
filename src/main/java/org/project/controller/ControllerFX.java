package org.project.controller;

import javafx.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControllerFX {

    @FXML
    private Button myButton;

    @FXML
    private TextField inputTextField;

    @FXML
    private Label outputLabel;

    // Inizializzazione del controller
    @FXML
    private void initialize() {
    }

    @FXML
    private void handleButtonClicked() {
        String input = inputTextField.getText();
        String output = processInput(input);
        outputLabel.setText(output);
    }

    private String processInput(String input) {
        // Logica per elaborare l'input
        return "Risultato: " + input;
    }
}

