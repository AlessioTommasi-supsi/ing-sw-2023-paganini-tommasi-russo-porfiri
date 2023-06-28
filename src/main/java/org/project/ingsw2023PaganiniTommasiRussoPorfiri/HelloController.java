package org.project.ingsw2023PaganiniTommasiRussoPorfiri;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.TilePositionBoard;
import javafx.util.Duration;

import java.util.ArrayList;
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
    @FXML
    ImageView boardR0C4;
    @FXML
    ImageView boardR0C5;
    @FXML
    ImageView boardR1C3;
    @FXML
    ImageView boardR1C4;
    @FXML
    ImageView boardR1C5;
    @FXML
    ImageView boardR2C2;
    @FXML
    ImageView boardR2C3;
    @FXML
    ImageView boardR2C4;
    @FXML
    ImageView boardR2C5;
    @FXML
    ImageView boardR2C6;
    @FXML
    ImageView boardR3C0;
    @FXML
    ImageView boardR3C1;
    @FXML
    ImageView boardR3C2;
    @FXML
    ImageView boardR3C3;
    @FXML
    ImageView boardR3C4;
    @FXML
    ImageView boardR3C5;
    @FXML
    ImageView boardR3C6;
    @FXML
    ImageView boardR3C7;
    @FXML
    ImageView boardR4C0;
    @FXML
    ImageView boardR4C1;
    @FXML
    ImageView boardR4C2;
    @FXML
    ImageView boardR4C3;

    @FXML
    ImageView boardR4C4;
    @FXML
    ImageView boardR4C5;
    @FXML
    ImageView boardR4C6;
    @FXML
    ImageView boardR4C7;
    @FXML
    ImageView boardR4C8;

    @FXML
    ImageView boardR5C1;
    @FXML
    ImageView boardR5C2;
    @FXML
    ImageView boardR5C3;

    @FXML
    ImageView boardR5C4;
    @FXML
    ImageView boardR5C5;
    @FXML
    ImageView boardR5C6;

    @FXML
    ImageView boardR5C7;

    @FXML
    ImageView boardR5C8;

    @FXML
    ImageView boardR6C2;

    @FXML
    ImageView boardR6C3;
    @FXML
    ImageView boardR6C4;

    @FXML
    ImageView boardR6C5;

    @FXML
    ImageView boardR6C6;

    @FXML
    ImageView boardR7C3;

    @FXML
    ImageView boardR7C4;

    @FXML
    ImageView boardR7C5;


    @FXML
    ImageView boardR8C3;

    @FXML
    ImageView boardR8C4;




    @FXML
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
        for (int i = 0; i < tilePositionBoards.size(); i++) {
            if(tilePositionBoards.get(i).isMe(0, 4)){
                boardR0C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/"+tilePositionBoards.get(i).getTile().getType().name()+""+tilePositionBoards.get(i).getTile().getVariant().name()+".png"));
    /*
    public void updateBoard(ArrayList<TilePositionBoard> tilePositionBoards) {
        // TODO
        img3_1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/Gatti1.1.png"));
    } */

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

            }
        }

        boardR1C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/Gatti1.1.png"));
        boardR1C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/"+tilePositionBoards.get(0).getTile().getType()+""+tilePositionBoards.get(0).getTile().getVariant()+".png"));
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