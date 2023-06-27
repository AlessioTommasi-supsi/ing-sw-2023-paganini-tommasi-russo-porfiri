package org.project.ingsw2023PaganiniTommasiRussoPorfiri.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.distributed.*;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;

public class ControllerFX {
    private Turn model;
    private Client client;
    @FXML
    private Pane mainPane;
    // Pagina iniziale
    @FXML
    private TextField usernameField;
    @FXML
    private TextField gamePlayerNumber;
    @FXML
    private Button joinGameButton;
    // Pagina di gioco
    @FXML
    private Pane gamePane;
    @FXML
    private Pane boardPane;
    @FXML
    private GridPane boardGrid;
    @FXML
    private SplitPane allCardsSplitPane;
    @FXML
    private AnchorPane commonCardsAnchorPane;
    @FXML
    private SplitPane commonCardsSplitPane;
    @FXML
    private AnchorPane commonCard1AnchorPane;
    @FXML
    private AnchorPane commonCard2AnchorPane;
    @FXML
    private AnchorPane personalCardAnchorPane;
    @FXML
    private SplitPane shelvesSplitPane;
    @FXML
    private AnchorPane shelves1AnchorPane;
    @FXML
    private SplitPane shelves1SplitPane;
    @FXML
    private AnchorPane shelves2AnchorPane;
    @FXML
    private SplitPane shelves2SplitPane;
    @FXML
    private AnchorPane myShelfAnchorPane;
    @FXML
    private AnchorPane shelf2AnchorPane;
    @FXML
    private AnchorPane shelf3AnchorPane;
    @FXML
    private AnchorPane shelf4AnchorPane;
    @FXML
    private ScrollPane playerChoiceScrollPAne;

    @FXML
    Pane loginPane;


    public ControllerFX(Turn model, Client client) {
        this.model = model;
        this.client = client;
    }

    public void hideLoginPane(ActionEvent actionEvent) {
        loginPane.setOpacity(0);
    }

    public void Initialize(Client o) {

        /*backgroundImageView.setImage(new Image("@../GraphicResources/misc/sfondo parquet.jpg"));
        boardImageView.setImage(new Image("@../GraphicResources/boards/livingroom.png"));


        commonGoalCard1ImageView.setImage(new Image("@../GraphicResources/commonGoalCards/1.jpg"));
        commonGoalCard2ImageView.setImage(new Image("@../GraphicResources/commonGoalCards/2.jpg"));
        personalGoalCardImageView.setImage(new Image("@../GraphicResources/personalGoalCards/Personal_Goals6.png"));
        setupGridPane();*/
    }

    @FXML
    private void handleButtonClick() {
        int numberOfPlayers = Integer.parseInt(usernameField.getText());
        String nickname = usernameField.getText();

        // Verifica se sono stati inseriti il numero di giocatori e il nickname
        if (numberOfPlayers > 0 && numberOfPlayers <= 4 && !nickname.isEmpty()) {
            // Rimuovi il pane che sovrasta l'altro
            mainPane.getChildren().remove(loginPane);
        }
    }

    private void setupGridPane() {

    }

    @FXML
    protected void onHelloButtonClick() {
        //welcomeText.setText("Welcome to JavaFX Application!");
    }


}
