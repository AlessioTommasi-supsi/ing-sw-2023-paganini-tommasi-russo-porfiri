package org.project.ingsw2023PaganiniTommasiRussoPorfiri;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.TilePositionBoard;
import javafx.util.Duration;

import java.util.ArrayList;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private Pane mainPane;
    @FXML
    private Label welcomeText;
    @FXML
    Pane loginPane;

    @FXML
    ImageView img3_1;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void hideLoginPane(ActionEvent actionEvent) {
        loginPane.setOpacity(0);
    }

    public void updateBoard(ArrayList<TilePositionBoard> tilePositionBoards) {
        // TODO
        img3_1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/Gatti1.1.png"));
    }

    @FXML
    private Pane mainPane;

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