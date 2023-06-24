package org.project.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
//import javafx.scene.layout.SplitPane;

public class ControllerFX {
    @FXML
    private Label welcomeText;
    @FXML
    private Pane mainPane;
    @FXML
    private ImageView backgroundImageView;
    @FXML
    private ImageView boardImageView;
    @FXML
    private GridPane gridPane;
    //@FXML
    //private SplitPane splitPane1;
    @FXML
    private AnchorPane anchorPane1;
    @FXML
    private ImageView commonGoalCard1ImageView;
    @FXML
    private ImageView commonGoalCard2ImageView;
    @FXML
    private SplitPane splitPane2;
    @FXML
    private AnchorPane anchorPane2;
    @FXML
    private ImageView personalGoalCardImageView;
    @FXML
    private SplitPane splitPane3;
    @FXML
    private AnchorPane anchorPane3;
    @FXML
    private SplitPane splitPane4;
    @FXML
    private AnchorPane anchorPane4;

    public ControllerFX() {
    }

    public void initialize() {
        backgroundImageView.setImage(new Image("@../GraphicResources/misc/sfondo parquet.jpg"));
        boardImageView.setImage(new Image("@../GraphicResources/boards/livingroom.png"));

        commonGoalCard1ImageView.setImage(new Image("@../GraphicResources/commonGoalCards/1.jpg"));
        commonGoalCard2ImageView.setImage(new Image("@../GraphicResources/commonGoalCards/2.jpg"));
        personalGoalCardImageView.setImage(new Image("@../GraphicResources/personalGoalCards/Personal_Goals6.png"));
        setupGridPane();
    }

    private void setupGridPane() {

    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


}
