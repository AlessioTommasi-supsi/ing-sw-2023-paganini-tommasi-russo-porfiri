package org.project.ingsw2023PaganiniTommasiRussoPorfiri;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.TilePositionBoard;
import javafx.util.Duration;

import java.util.ArrayList;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class HelloController {
    @FXML
    private Pane mainPane;
    @FXML
    private Label welcomeText;
    @FXML
    Pane loginPane;
    @FXML
    private Pane mainPane;
    @FXML
    private TextField choiceX1TextField;
    @FXML
    private TextField choiceY1TextField;
    @FXML
    private TextField choiceX2TextField;
    @FXML
    private TextField choiceY2TextField;
    @FXML
    private TextField choiceX3TextField;
    @FXML
    private TextField choiceY3TextField;
    @FXML
    private TextField choiceOrder1TextField;
    @FXML
    private TextField choiceOrder2TextField;
    @FXML
    private TextField choiceOrder3TextField;
    @FXML
    private TextField choiceShelfColumnNumTextField;
    @FXML
    private TextField playerNumberTextField;

    ArrayList<TextFormatter<String>> textFormattersList = new ArrayList<>();
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void hideLoginPane(ActionEvent actionEvent) {
        loginPane.setVisible(false);
        loginPane.setMouseTransparent(true);
        //loginPane.setDisable(true);
    }

    public void updateBoard(ArrayList<TilePositionBoard> tilePositionBoards) {
        // TODO
        img3_1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/Gatti1.1.png"));
    }

    @FXML
    private void initialize() {
        // Operatore unario per limitare l'input ai numeri interi positivi di lunghezza == 1 oppure il backspace
        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if ((newText.matches("\\d*") && newText.length() == 1) || newText.isEmpty()) { // Accetta solo numeri non negativi
                return change;
            }
            return null;
        };

        //Creazione dei TextFormatter<String>
        for (int i = 0; i < 12; i++) {
            TextFormatter<String> textFormatter = new TextFormatter<>(integerFilter);
            textFormattersList.add(textFormatter);
        }

        //Applicazione di ciascun TextFormatter a ciascun TextField che deve rispettare la caratteristica sopra
        choiceX1TextField.setTextFormatter(textFormattersList.get(0));
        choiceY1TextField.setTextFormatter(textFormattersList.get(1));
        choiceX2TextField.setTextFormatter(textFormattersList.get(2));
        choiceY2TextField.setTextFormatter(textFormattersList.get(3));
        choiceX3TextField.setTextFormatter(textFormattersList.get(4));
        choiceY3TextField.setTextFormatter(textFormattersList.get(5));
        choiceOrder1TextField.setTextFormatter(textFormattersList.get(6));
        choiceOrder2TextField.setTextFormatter(textFormattersList.get(7));
        choiceOrder3TextField.setTextFormatter(textFormattersList.get(8));
        choiceShelfColumnNumTextField.setTextFormatter(textFormattersList.get(9));
        playerNumberTextField.setTextFormatter(textFormattersList.get(10));


    }






    /*
    public void initialize(URL location, ResourceBundle resources) {
        // Esempio di ridimensionamento del Pane dopo 5 secondi
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(event -> {
            mainPane.setPrefWidth(1280);
            mainPane.setPrefHeight(720);
        });
        delay.play();
    }*/

}