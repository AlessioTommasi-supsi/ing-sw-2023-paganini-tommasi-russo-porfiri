package org.project.ingsw2023PaganiniTommasiRussoPorfiri;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.view.TextualUI.DrawFromBoardMessage;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.view.TextualUI.ViewMyShelfie;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.UnaryOperator;

public class HelloController {
    @FXML
    private Pane mainPane;
    @FXML
    private Pane loginPane;
    @FXML
    private Label welcomeText;
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
    @FXML
    private Spinner choiceNumTileSpinner;
    @FXML
    private Button joinGameButton;
    @FXML
    private ImageView boardR0C4;
    @FXML
    private ImageView boardR0C5;
    @FXML
    private ImageView boardR1C3;
    @FXML
    private ImageView boardR1C4;
    @FXML
    private ImageView boardR1C5;
    @FXML
    private ImageView boardR2C2;
    @FXML
    private ImageView boardR2C3;
    @FXML
    private ImageView boardR2C4;
    @FXML
    private ImageView boardR2C5;
    @FXML
    private ImageView boardR2C6;
    @FXML
    private ImageView boardR3C0;
    @FXML
    private ImageView boardR3C1;
    @FXML
    private ImageView boardR3C2;
    @FXML
    private ImageView boardR3C3;
    @FXML
    private ImageView boardR3C4;
    @FXML
    private ImageView boardR3C5;
    @FXML
    private ImageView boardR3C6;
    @FXML
    private ImageView boardR3C7;
    @FXML
    private ImageView boardR4C0;
    @FXML
    private ImageView boardR4C1;
    @FXML
    private ImageView boardR4C2;
    @FXML
    private ImageView boardR4C3;
    @FXML
    private ImageView boardR4C4;
    @FXML
    private ImageView boardR4C5;
    @FXML
    private ImageView boardR4C6;
    @FXML
    private ImageView boardR4C7;
    @FXML
    private ImageView boardR4C8;
    @FXML
    private ImageView boardR5C1;
    @FXML
    private ImageView boardR5C2;
    @FXML
    private ImageView boardR5C3;
    @FXML
    private ImageView boardR5C4;
    @FXML
    private ImageView boardR5C5;
    @FXML
    private ImageView boardR5C6;
    @FXML
    private ImageView boardR5C7;
    @FXML
    private ImageView boardR5C8;
    @FXML
    private ImageView boardR6C2;
    @FXML
    private ImageView boardR6C3;
    @FXML
    private ImageView boardR6C4;
    @FXML
    private ImageView boardR6C5;
    @FXML
    private ImageView boardR6C6;
    @FXML
    private ImageView boardR7C3;
    @FXML
    private ImageView boardR7C4;
    @FXML
    private ImageView boardR7C5;
    @FXML
    private ImageView boardR8C3;
    @FXML
    private ImageView boardR8C4;
    @FXML
    private ImageView shelf1R0C0;
    @FXML
    private ImageView shelf1R0C1;
    @FXML
    private ImageView shelf1R0C2;
    @FXML
    private ImageView shelf1R0C3;
    @FXML
    private ImageView shelf1R0C4;
    @FXML
    private ImageView shelf1R1C0;
    @FXML
    private ImageView shelf1R1C1;
    @FXML
    private ImageView shelf1R1C2;
    @FXML
    private ImageView shelf1R1C3;
    @FXML
    private ImageView shelf1R1C4;
    @FXML
    private ImageView shelf1R2C0;
    @FXML
    private ImageView shelf1R2C1;
    @FXML
    private ImageView shelf1R2C2;
    @FXML
    private ImageView shelf1R2C3;
    @FXML
    private ImageView shelf1R2C4;
    @FXML
    private ImageView shelf1R3C0;
    @FXML
    private ImageView shelf1R3C1;
    @FXML
    private ImageView shelf1R3C2;
    @FXML
    private ImageView shelf1R3C3;
    @FXML
    private ImageView shelf1R3C4;
    @FXML
    private ImageView shelf1R4C0;
    @FXML
    private ImageView shelf1R4C1;
    @FXML
    private ImageView shelf1R4C2;
    @FXML
    private ImageView shelf1R4C3;
    @FXML
    private ImageView shelf1R4C4;
    @FXML
    private ImageView shelf1R5C0;
    @FXML
    private ImageView shelf1R5C1;
    @FXML
    private ImageView shelf1R5C2;
    @FXML
    private ImageView shelf1R5C3;
    @FXML
    private ImageView shelf1R5C4;
    @FXML
    private ImageView shelf2R0C0;
    @FXML
    private ImageView shelf2R0C1;
    @FXML
    private ImageView shelf2R0C2;
    @FXML
    private ImageView shelf2R0C3;
    @FXML
    private ImageView shelf2R0C4;
    @FXML
    private ImageView shelf2R1C0;
    @FXML
    private ImageView shelf2R1C1;
    @FXML
    private ImageView shelf2R1C2;
    @FXML
    private ImageView shelf2R1C3;
    @FXML
    private ImageView shelf2R1C4;
    @FXML
    private ImageView shelf2R2C0;
    @FXML
    private ImageView shelf2R2C1;
    @FXML
    private ImageView shelf2R2C2;
    @FXML
    private ImageView shelf2R2C3;
    @FXML
    private ImageView shelf2R2C4;
    @FXML
    private ImageView shelf2R3C0;
    @FXML
    private ImageView shelf2R3C1;
    @FXML
    private ImageView shelf2R3C2;
    @FXML
    private ImageView shelf2R3C3;
    @FXML
    private ImageView shelf2R3C4;
    @FXML
    private ImageView shelf2R4C0;
    @FXML
    private ImageView shelf2R4C1;
    @FXML
    private ImageView shelf2R4C2;
    @FXML
    private ImageView shelf2R4C3;
    @FXML
    private ImageView shelf2R4C4;
    @FXML
    private ImageView shelf2R5C0;
    @FXML
    private ImageView shelf2R5C1;
    @FXML
    private ImageView shelf2R5C2;
    @FXML
    private ImageView shelf2R5C3;
    @FXML
    private ImageView shelf2R5C4;
    @FXML
    private ImageView shelf3R0C0;
    @FXML
    private ImageView shelf3R0C1;
    @FXML
    private ImageView shelf3R0C2;
    @FXML
    private ImageView shelf3R0C3;
    @FXML
    private ImageView shelf3R0C4;
    @FXML
    private ImageView shelf3R1C0;
    @FXML
    private ImageView shelf3R1C1;
    @FXML
    private ImageView shelf3R1C2;
    @FXML
    private ImageView shelf3R1C3;
    @FXML
    private ImageView shelf3R1C4;
    @FXML
    private ImageView shelf3R2C0;
    @FXML
    private ImageView shelf3R2C1;
    @FXML
    private ImageView shelf3R2C2;
    @FXML
    private ImageView shelf3R2C3;
    @FXML
    private ImageView shelf3R2C4;
    @FXML
    private ImageView shelf3R3C0;
    @FXML
    private ImageView shelf3R3C1;
    @FXML
    private ImageView shelf3R3C2;
    @FXML
    private ImageView shelf3R3C3;
    @FXML
    private ImageView shelf3R3C4;
    @FXML
    private ImageView shelf3R4C0;
    @FXML
    private ImageView shelf3R4C1;
    @FXML
    private ImageView shelf3R4C2;
    @FXML
    private ImageView shelf3R4C3;
    @FXML
    private ImageView shelf3R4C4;
    @FXML
    private ImageView shelf3R5C0;
    @FXML
    private ImageView shelf3R5C1;
    @FXML
    private ImageView shelf3R5C2;
    @FXML
    private ImageView shelf3R5C3;
    @FXML
    private ImageView shelf3R5C4;
    @FXML
    private ImageView shelf4R0C0;
    @FXML
    private ImageView shelf4R0C1;
    @FXML
    private ImageView shelf4R0C2;
    @FXML
    private ImageView shelf4R0C3;
    @FXML
    private ImageView shelf4R0C4;
    @FXML
    private ImageView shelf4R1C0;
    @FXML
    private ImageView shelf4R1C1;
    @FXML
    private ImageView shelf4R1C2;
    @FXML
    private ImageView shelf4R1C3;
    @FXML
    private ImageView shelf4R1C4;
    @FXML
    private ImageView shelf4R2C0;
    @FXML
    private ImageView shelf4R2C1;
    @FXML
    private ImageView shelf4R2C2;
    @FXML
    private ImageView shelf4R2C3;
    @FXML
    private ImageView shelf4R2C4;
    @FXML
    private ImageView shelf4R3C0;
    @FXML
    private ImageView shelf4R3C1;
    @FXML
    private ImageView shelf4R3C2;
    @FXML
    private ImageView shelf4R3C3;
    @FXML
    private ImageView shelf4R3C4;
    @FXML
    private ImageView shelf4R4C0;
    @FXML
    private ImageView shelf4R4C1;
    @FXML
    private ImageView shelf4R4C2;
    @FXML
    private ImageView shelf4R4C3;
    @FXML
    private ImageView shelf4R4C4;
    @FXML
    private ImageView shelf4R5C0;
    @FXML
    private ImageView shelf4R5C1;
    @FXML
    private ImageView shelf4R5C2;
    @FXML
    private ImageView shelf4R5C3;
    @FXML
    private ImageView shelf4R5C4;
    @FXML
    private TextField usernameTextField;
    @FXML
    private ScrollPane choiceScrollPane;
    @FXML
    private Text choiceTextField1;
    @FXML
    private Button choiceSendButton;
    private ArrayList<TextFormatter<String>> textFormattersList1 = new ArrayList<>();
    private ArrayList<TextFormatter<String>> textFormattersList2 = new ArrayList<>();
    public ViewMyShelfie viewMyShelfie = null;
    @FXML
    private Text shp1Text;
    @FXML
    private Text shp2Text;
    @FXML
    private Text shp3Text;
    @FXML
    private Text shp4Text;
    @FXML
    private TextField c1Points;
    @FXML
    private TextField c2Points;
    @FXML
    private ImageView commonCard1ImageView;
    @FXML
    private ImageView commonCard2ImageView;
    @FXML
    private ImageView personalCardImageView;

    @FXML
    private ImageView shelf3ImageView;
    @FXML
    private GridPane shelf3GridPane;
    @FXML
    private Text col0Shelf3;
    @FXML
    private Text col1Shelf3;
    @FXML
    private Text col2Shelf3;
    @FXML
    private Text col3Shelf3;
    @FXML
    private Text col4Shelf3;
    @FXML
    private ImageView shelf4ImageView;
    @FXML
    private GridPane shelf4GridPane;
    @FXML
    private Text col0Shelf4;
    @FXML
    private Text col1Shelf4;
    @FXML
    private Text col2Shelf4;
    @FXML
    private Text col3Shelf4;
    @FXML
    private Text col4Shelf4;
    @FXML
    private ImageView invisibleCat3P;
    @FXML
    private ImageView invisibleCat4P;












    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void hideLoginPane(ActionEvent actionEvent) {
        loginPane.setVisible(false);
        loginPane.setMouseTransparent(true);
        //loginPane.setDisable(true);
    }
    public void hideSecondSetOfCoordinates(){
        choiceX2TextField.setVisible(false);
        choiceY2TextField.setMouseTransparent(true);
    }
    public void hideThirdSetOfCoordinates(){
        choiceX3TextField.setVisible(false);
        choiceY3TextField.setMouseTransparent(true);
    }
    public void hideSecondInsertionOrderField(){
        choiceOrder2TextField.setVisible(false);
        choiceOrder2TextField.setMouseTransparent(true);
    }
    public void hideThirdInsertionOrderField(){
        choiceOrder3TextField.setVisible(false);
        choiceOrder3TextField.setMouseTransparent(true);
    }

    public void setPrivateCard(PersonalCard myPersonalCard) {
        int cardNumber = myPersonalCard.getPersonalCardNumber();
        String imagePath = "file:src/main/resources/GraphicResources/personalGoalCards/Personal_Goals" + cardNumber + ".png";
        personalCardImageView.setImage(new javafx.scene.image.Image(imagePath));
    }

    public void setCommonCards(CommonCard c1, CommonCard c2){
        int c1Index = c1.getIndex();
        int c2Index = c2.getIndex();
        String imagePath1 = "file:src/main/resources/GraphicResources/commonGoalCards/Common_Goals" + c1Index + ".jpg";
        commonCard1ImageView.setImage(new javafx.scene.image.Image(imagePath1));
        String imagePath2 = "file:src/main/resources/GraphicResources/commonGoalCards/Common_Goals" + c2Index + ".jpg";
        commonCard2ImageView.setImage(new javafx.scene.image.Image(imagePath2));
    }

    public void UpdateCommonPoints(CommonCard c1, CommonCard c2){
        int scoreC1 = c1.getScore();
        int scoreC2 = c2.getScore();

        c1Points.setEditable(true);
        c2Points.setEditable(true);

        c1Points.setText(String.valueOf(scoreC1));
        c2Points.setText(String.valueOf(scoreC2));

        c1Points.setEditable(false);
        c2Points.setEditable(false);
    }

    public void verifyLoginInformationAdded(){
        //if()
    }


    public void updateBoard(ArrayList<TilePositionBoard> tilePositionBoards) {
        // TODO
        for (int i = 0; i < tilePositionBoards.size() ; i++) {
            if(tilePositionBoards.get(i).isOccupied()) {
                if (tilePositionBoards.get(i).isMe(0, 4)) {
                    boardR0C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(0, 5)) {
                    boardR0C5.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(1, 3)) {
                    boardR1C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(1, 4)) {
                    boardR1C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(1, 5)) {
                    boardR1C5.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(2, 2)) {
                    boardR2C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }
                if (tilePositionBoards.get(i).isMe(2, 3)) {
                    boardR2C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(2, 4)) {
                    boardR2C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(2, 5)) {
                    boardR2C5.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }
                if (tilePositionBoards.get(i).isMe(2, 6)) {
                    boardR2C6.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(3, 0)) {
                    boardR3C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(3, 1)) {
                    boardR3C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(3, 2)) {
                    boardR3C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(3, 3)) {
                    boardR3C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(3, 4)) {
                    boardR3C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(3, 5)) {
                    boardR3C5.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(3, 6)) {
                    boardR3C6.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(3, 7)) {
                    boardR3C7.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(4, 0)) {
                    boardR4C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(4, 1)) {
                    boardR4C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(4, 2)) {
                    boardR4C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }
                if (tilePositionBoards.get(i).isMe(4, 3)) {
                    boardR4C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(4, 4)) {
                    boardR4C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(4, 5)) {
                    boardR4C5.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(4, 6)) {
                    boardR4C6.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(4, 7)) {
                    boardR4C7.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }
                if (tilePositionBoards.get(i).isMe(4, 8)) {
                    boardR4C8.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }
                if (tilePositionBoards.get(i).isMe(5, 1)) {
                    boardR5C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(5, 2)) {
                    boardR5C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(5, 3)) {
                    boardR5C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }


                if (tilePositionBoards.get(i).isMe(5, 4)) {
                    boardR5C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(5, 5)) {
                    boardR5C5.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(5, 6)) {
                    boardR5C6.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }


                if (tilePositionBoards.get(i).isMe(5, 7)) {
                    boardR5C7.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(5, 8)) {
                    boardR5C8.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }


                if (tilePositionBoards.get(i).isMe(6, 2)) {
                    boardR6C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(6, 3)) {
                    boardR6C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(6, 4)) {
                    boardR6C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }


                if (tilePositionBoards.get(i).isMe(6, 5)) {
                    boardR6C5.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(6, 6)) {
                    boardR6C6.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }


                if (tilePositionBoards.get(i).isMe(7, 3)) {
                    boardR7C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(7, 4)) {
                    boardR7C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(7, 5)) {
                    boardR7C5.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }
                if (tilePositionBoards.get(i).isMe(8, 3)) {
                    boardR8C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }

                if (tilePositionBoards.get(i).isMe(8, 4)) {
                    boardR8C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));
                }
            }else {//rimuovi immagine
                if (tilePositionBoards.get(i).isMe(0, 4)) {
                    boardR0C4.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(0, 5)) {
                    boardR0C5.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(1, 3)) {
                    boardR1C3.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(1, 4)) {
                    boardR1C4.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(1, 5)) {
                    boardR1C5.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(2, 2)) {
                    boardR2C2.setImage(null);
                }
                if (tilePositionBoards.get(i).isMe(2, 3)) {
                    boardR2C3.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(2, 4)) {
                    boardR2C4.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(2, 5)) {
                    boardR2C5.setImage(null);
                }
                if (tilePositionBoards.get(i).isMe(2, 6)) {
                    boardR2C6.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(3, 0)) {
                    boardR3C0.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(3, 1)) {
                    boardR3C1.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(3, 2)) {
                    boardR3C2.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(3, 3)) {
                    boardR3C3.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(3, 4)) {
                    boardR3C4.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(3, 5)) {
                    boardR3C5.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(3, 6)) {
                    boardR3C6.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(3, 7)) {
                    boardR3C7.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(4, 0)) {
                    boardR4C0.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(4, 1)) {
                    boardR4C1.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(4, 2)) {
                    boardR4C2.setImage(null);
                }
                if (tilePositionBoards.get(i).isMe(4, 3)) {
                    boardR4C3.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(4, 4)) {
                    boardR4C4.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(4, 5)) {
                    boardR4C5.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(4, 6)) {
                    boardR4C6.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(4, 7)) {
                    boardR4C7.setImage(null);
                }
                if (tilePositionBoards.get(i).isMe(4, 8)) {
                    boardR4C8.setImage(null);
                }
                if (tilePositionBoards.get(i).isMe(5, 1)) {
                    boardR5C1.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(5, 2)) {
                    boardR5C2.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(5, 3)) {
                    boardR5C3.setImage(null);
                }


                if (tilePositionBoards.get(i).isMe(5, 4)) {
                    boardR5C4.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(5, 5)) {
                    boardR5C5.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(5, 6)) {
                    boardR5C6.setImage(null);
                }


                if (tilePositionBoards.get(i).isMe(5, 7)) {
                    boardR5C7.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(5, 8)) {
                    boardR5C8.setImage(null);
                }


                if (tilePositionBoards.get(i).isMe(6, 2)) {
                    boardR6C2.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(6, 3)) {
                    boardR6C3.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(6, 4)) {
                    boardR6C4.setImage(null);
                }


                if (tilePositionBoards.get(i).isMe(6, 5)) {
                    boardR6C5.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(6, 6)) {
                    boardR6C6.setImage(null);
                }


                if (tilePositionBoards.get(i).isMe(7, 3)) {
                    boardR7C3.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(7, 4)) {
                    boardR7C4.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(7, 5)) {
                    boardR7C5.setImage(null);
                }
                if (tilePositionBoards.get(i).isMe(8, 3)) {
                    boardR8C3.setImage(null);
                }

                if (tilePositionBoards.get(i).isMe(8, 4)) {
                    boardR8C4.setImage(null);
                }
            }
        }
        //boardR1C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/Gatti1.1.png"));
        //boardR1C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/"+tilePositionBoards.get(0).getTile().getType().getName()+""+tilePositionBoards.get(0).getTile().getVariant().getNumber()+".png"));
    }


    public void initShelves(ArrayList<Player> players){
        try {
            shp1Text.setText(players.get(0).getUsername());
            shp2Text.setText(players.get(1).getUsername());


            switch (players.size()) {
                case 2:
                    shelf3ImageView.setVisible(false);
                    String imagePath3 = "file:src/main/resources/GraphicResources/cat/cat-897x1024-left.png";
                    invisibleCat3P.setImage(new javafx.scene.image.Image(imagePath3));
                    invisibleCat3P.setVisible(true);
                    shelf3GridPane.setVisible(false);
                    col0Shelf3.setVisible(false);
                    col1Shelf3.setVisible(false);
                    col2Shelf3.setVisible(false);
                    col3Shelf3.setVisible(false);
                    col4Shelf3.setVisible(false);

                    shelf4ImageView.setVisible(false);
                    String imagePath4 = "file:src/main/resources/GraphicResources/cat/cat-897x1024.png";
                    invisibleCat4P.setImage(new javafx.scene.image.Image(imagePath4));
                    invisibleCat4P.setVisible(true);
                    shelf4GridPane.setVisible(false);
                    col0Shelf4.setVisible(false);
                    col1Shelf4.setVisible(false);
                    col2Shelf4.setVisible(false);
                    col3Shelf4.setVisible(false);
                    col4Shelf4.setVisible(false);
                    shp3Text.setText("[Only two players]");
                    shp4Text.setText("[Only two players]");
                break;

                case 3:
                    shelf3GridPane.setVisible(true);
                    shp3Text.setText(players.get(2).getUsername());
                    shelf3ImageView.setVisible(true);

                    col0Shelf3.setVisible(true);
                    col1Shelf3.setVisible(true);
                    col2Shelf3.setVisible(true);
                    col3Shelf3.setVisible(true);
                    col4Shelf3.setVisible(true);
                    invisibleCat3P.setVisible(true);

                    shelf4ImageView.setVisible(false);
                    String imagePath5 = "file:src/main/resources/GraphicResources/cat/cat-897x1024.png";
                    invisibleCat4P.setImage(new javafx.scene.image.Image(imagePath5));
                    invisibleCat4P.setVisible(true);
                    shelf4GridPane.setVisible(false);
                    col0Shelf4.setVisible(false);
                    col1Shelf4.setVisible(false);
                    col2Shelf4.setVisible(false);
                    col3Shelf4.setVisible(false);
                    col4Shelf4.setVisible(false);
                    shp4Text.setText("[Only three players]");
                break;

                case 4:
                    shelf3GridPane.setVisible(true);
                    shelf3ImageView.setVisible(true);

                    col0Shelf3.setVisible(true);
                    col1Shelf3.setVisible(true);
                    col2Shelf3.setVisible(true);
                    col3Shelf3.setVisible(true);
                    col4Shelf3.setVisible(true);
                    invisibleCat3P.setVisible(false);

                    shelf4ImageView.setVisible(true);


                    shelf4GridPane.setVisible(true);
                    shp3Text.setText(players.get(2).getUsername());
                    shp4Text.setText(players.get(3).getUsername());
                break;

            }


        }catch (Exception e){
            //index out og bound e vengono inizializzati meno di 4 giocatori
            e.printStackTrace();
        }

    }
    public void updateShelves(ArrayList<Player> players){
        try {
            upupdateShelves1(players);
            upupdateShelves2(players);


            switch (players.size()) {
                case 3:
                    upupdateShelves3(players);
                break;
                case 4:
                    upupdateShelves3(players);
                    upupdateShelves4(players);
                break;
            }


        }catch (Exception e){
            //index out og bound e vengono inizializzati meno di 4 giocatori
            e.printStackTrace();
        }

        //this.shelf1R0C0 = players.get(0).getShelves().getTilePosition(0, 0).getTile();
        //shelf1R0C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositionBoards.get(i).getTile().getType().getName() + "" + tilePositionBoards.get(i).getTile().getVariant().getNumber() + ".png"));

    }


    public void upupdateShelves1(ArrayList<Player> players){
        //Shelves mazziere = #shelf1
        //TilePositionShelves[6][5]
        TilePositionShelves[][] tilePositions = players.get(0).getShelves().showShelves();

        if (tilePositions[0][0].isOccupied()){
            shelf1R0C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][0].getTile().getType().getName() + "" + tilePositions[0][0].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[0][1].isOccupied()){
            shelf1R0C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][1].getTile().getType().getName() + "" + tilePositions[0][1].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[0][2].isOccupied()){
            shelf1R0C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][2].getTile().getType().getName() + "" + tilePositions[0][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[0][3].isOccupied()){
            shelf1R0C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][3].getTile().getType().getName() + "" + tilePositions[0][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[0][4].isOccupied()){
            shelf1R0C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][4].getTile().getType().getName() + "" + tilePositions[0][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[1][0].isOccupied()){
            shelf1R1C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][0].getTile().getType().getName() + "" + tilePositions[1][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[1][1].isOccupied()){
            shelf1R1C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][1].getTile().getType().getName() + "" + tilePositions[1][1].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[1][2].isOccupied()){
            shelf1R1C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][2].getTile().getType().getName() + "" + tilePositions[1][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[1][3].isOccupied()){
            shelf1R1C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][3].getTile().getType().getName() + "" + tilePositions[1][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[1][4].isOccupied()){
            shelf1R1C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][4].getTile().getType().getName() + "" + tilePositions[1][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][0].isOccupied()){
            shelf1R2C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][0].getTile().getType().getName() + "" + tilePositions[2][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][1].isOccupied()){
            shelf1R2C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][1].getTile().getType().getName() + "" + tilePositions[2][1].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][2].isOccupied()){
            shelf1R2C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][2].getTile().getType().getName() + "" + tilePositions[2][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][3].isOccupied()){
            shelf1R2C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][3].getTile().getType().getName() + "" + tilePositions[2][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][4].isOccupied()){
            shelf1R2C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][4].getTile().getType().getName() + "" + tilePositions[2][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[3][0].isOccupied()){
            shelf1R3C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][0].getTile().getType().getName() + "" + tilePositions[3][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[3][1].isOccupied()){
            shelf1R3C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][1].getTile().getType().getName() + "" + tilePositions[3][1].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[3][2].isOccupied()){
            shelf1R3C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][2].getTile().getType().getName() + "" + tilePositions[3][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[3][3].isOccupied()){
            shelf1R3C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][3].getTile().getType().getName() + "" + tilePositions[3][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[3][4].isOccupied()){
            shelf1R3C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][4].getTile().getType().getName() + "" + tilePositions[3][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[4][0].isOccupied()){
            shelf1R4C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][0].getTile().getType().getName() + "" + tilePositions[4][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[4][1].isOccupied()){
            shelf1R4C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][1].getTile().getType().getName() + "" + tilePositions[4][1].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[4][2].isOccupied()){
            shelf1R4C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][2].getTile().getType().getName() + "" + tilePositions[4][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[4][3].isOccupied()){
            shelf1R4C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][3].getTile().getType().getName() + "" + tilePositions[4][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[4][4].isOccupied()){
            shelf1R4C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][4].getTile().getType().getName() + "" + tilePositions[4][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[5][0].isOccupied()){
            shelf1R5C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][0].getTile().getType().getName() + "" + tilePositions[5][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[5][1].isOccupied()){
            shelf1R5C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][1].getTile().getType().getName() + "" + tilePositions[5][1].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[5][2].isOccupied()){
            shelf1R5C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][2].getTile().getType().getName() + "" + tilePositions[5][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[5][3].isOccupied()){
            shelf1R5C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][3].getTile().getType().getName() + "" + tilePositions[5][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[5][4].isOccupied()){
            shelf1R5C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][4].getTile().getType().getName() + "" + tilePositions[5][4].getTile().getVariant().getNumber() + ".png"));
        }
    }

    public void upupdateShelves2(ArrayList<Player> players){
        //TilePositionShelves[6][5]
        TilePositionShelves[][] tilePositions = players.get(1).getShelves().showShelves();

        if (tilePositions[0][0].isOccupied()){
            shelf2R0C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][0].getTile().getType().getName() + "" + tilePositions[0][0].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[0][1].isOccupied()){
            shelf2R0C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][1].getTile().getType().getName() + "" + tilePositions[0][1].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[0][2].isOccupied()){
            shelf2R0C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][2].getTile().getType().getName() + "" + tilePositions[0][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[0][3].isOccupied()){
            shelf2R0C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][3].getTile().getType().getName() + "" + tilePositions[0][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[0][4].isOccupied()){
            shelf2R0C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][4].getTile().getType().getName() + "" + tilePositions[0][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[1][0].isOccupied()){
            shelf2R1C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][0].getTile().getType().getName() + "" + tilePositions[1][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[1][1].isOccupied()){
            shelf2R1C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][1].getTile().getType().getName() + "" + tilePositions[1][1].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[1][2].isOccupied()){
            shelf2R1C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][2].getTile().getType().getName() + "" + tilePositions[1][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[1][3].isOccupied()){
            shelf2R1C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][3].getTile().getType().getName() + "" + tilePositions[1][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[1][4].isOccupied()){
            shelf2R1C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][4].getTile().getType().getName() + "" + tilePositions[1][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][0].isOccupied()){
            shelf2R2C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][0].getTile().getType().getName() + "" + tilePositions[2][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][1].isOccupied()){
            shelf2R2C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][1].getTile().getType().getName() + "" + tilePositions[2][1].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][2].isOccupied()){
            shelf2R2C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][2].getTile().getType().getName() + "" + tilePositions[2][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][3].isOccupied()){
            shelf2R2C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][3].getTile().getType().getName() + "" + tilePositions[2][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][4].isOccupied()){
            shelf2R2C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][4].getTile().getType().getName() + "" + tilePositions[2][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[3][0].isOccupied()){
            shelf2R3C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][0].getTile().getType().getName() + "" + tilePositions[3][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[3][1].isOccupied()){
            shelf2R3C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][1].getTile().getType().getName() + "" + tilePositions[3][1].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[3][2].isOccupied()){
            shelf2R3C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][2].getTile().getType().getName() + "" + tilePositions[3][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[3][3].isOccupied()){
            shelf2R3C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][3].getTile().getType().getName() + "" + tilePositions[3][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[3][4].isOccupied()){
            shelf2R3C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][4].getTile().getType().getName() + "" + tilePositions[3][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[4][0].isOccupied()){
            shelf2R4C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][0].getTile().getType().getName() + "" + tilePositions[4][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[4][1].isOccupied()){
            shelf2R4C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][1].getTile().getType().getName() + "" + tilePositions[4][1].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[4][2].isOccupied()){
            shelf2R4C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][2].getTile().getType().getName() + "" + tilePositions[4][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[4][3].isOccupied()){
            shelf2R4C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][3].getTile().getType().getName() + "" + tilePositions[4][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[4][4].isOccupied()){
            shelf2R4C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][4].getTile().getType().getName() + "" + tilePositions[4][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[5][0].isOccupied()){
            shelf2R5C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][0].getTile().getType().getName() + "" + tilePositions[5][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[5][1].isOccupied()){
            shelf2R5C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][1].getTile().getType().getName() + "" + tilePositions[5][1].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[5][2].isOccupied()){
            shelf2R5C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][2].getTile().getType().getName() + "" + tilePositions[5][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[5][3].isOccupied()){
            shelf2R5C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][3].getTile().getType().getName() + "" + tilePositions[5][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[5][4].isOccupied()){
            shelf2R5C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][4].getTile().getType().getName() + "" + tilePositions[5][4].getTile().getVariant().getNumber() + ".png"));
        }
    }

    public void upupdateShelves3(ArrayList<Player> players){
        TilePositionShelves[][] tilePositions = players.get(2).getShelves().showShelves();

        if (tilePositions[0][0].isOccupied()){
            shelf3R0C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][0].getTile().getType().getName() + "" + tilePositions[0][0].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[0][1].isOccupied()){
            shelf3R0C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][1].getTile().getType().getName() + "" + tilePositions[0][1].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[0][2].isOccupied()){
            shelf3R0C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][2].getTile().getType().getName() + "" + tilePositions[0][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[0][3].isOccupied()){
            shelf3R0C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][3].getTile().getType().getName() + "" + tilePositions[0][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[0][4].isOccupied()){
            shelf3R0C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][4].getTile().getType().getName() + "" + tilePositions[0][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[1][0].isOccupied()){
            shelf3R1C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][0].getTile().getType().getName() + "" + tilePositions[1][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[1][1].isOccupied()){
            shelf3R1C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][1].getTile().getType().getName() + "" + tilePositions[1][1].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[1][2].isOccupied()){
            shelf3R1C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][2].getTile().getType().getName() + "" + tilePositions[1][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[1][3].isOccupied()){
            shelf3R1C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][3].getTile().getType().getName() + "" + tilePositions[1][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[1][4].isOccupied()){
            shelf3R1C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][4].getTile().getType().getName() + "" + tilePositions[1][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][0].isOccupied()){
            shelf3R2C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][0].getTile().getType().getName() + "" + tilePositions[2][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][1].isOccupied()){
            shelf3R2C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][1].getTile().getType().getName() + "" + tilePositions[2][1].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][2].isOccupied()){
            shelf3R2C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][2].getTile().getType().getName() + "" + tilePositions[2][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][3].isOccupied()){
            shelf3R2C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][3].getTile().getType().getName() + "" + tilePositions[2][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][4].isOccupied()){
            shelf3R2C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][4].getTile().getType().getName() + "" + tilePositions[2][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[3][0].isOccupied()){
            shelf3R3C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][0].getTile().getType().getName() + "" + tilePositions[3][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[3][1].isOccupied()){
            shelf3R3C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][1].getTile().getType().getName() + "" + tilePositions[3][1].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[3][2].isOccupied()){
            shelf3R3C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][2].getTile().getType().getName() + "" + tilePositions[3][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[3][3].isOccupied()){
            shelf3R3C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][3].getTile().getType().getName() + "" + tilePositions[3][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[3][4].isOccupied()){
            shelf3R3C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][4].getTile().getType().getName() + "" + tilePositions[3][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[4][0].isOccupied()){
            shelf3R4C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][0].getTile().getType().getName() + "" + tilePositions[4][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[4][1].isOccupied()){
            shelf3R4C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][1].getTile().getType().getName() + "" + tilePositions[4][1].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[4][2].isOccupied()){
            shelf3R4C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][2].getTile().getType().getName() + "" + tilePositions[4][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[4][3].isOccupied()){
            shelf3R4C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][3].getTile().getType().getName() + "" + tilePositions[4][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[4][4].isOccupied()){
            shelf3R4C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][4].getTile().getType().getName() + "" + tilePositions[4][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[5][0].isOccupied()){
            shelf3R5C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][0].getTile().getType().getName() + "" + tilePositions[5][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[5][1].isOccupied()){
            shelf3R5C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][1].getTile().getType().getName() + "" + tilePositions[5][1].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[5][2].isOccupied()){
            shelf3R5C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][2].getTile().getType().getName() + "" + tilePositions[5][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[5][3].isOccupied()){
            shelf3R5C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][3].getTile().getType().getName() + "" + tilePositions[5][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[5][4].isOccupied()){
            shelf3R5C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][4].getTile().getType().getName() + "" + tilePositions[5][4].getTile().getVariant().getNumber() + ".png"));
        }
    }

    public void upupdateShelves4(ArrayList<Player> players){
        TilePositionShelves[][] tilePositions = players.get(3).getShelves().showShelves();

        if (tilePositions[0][0].isOccupied()){
            shelf4R0C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][0].getTile().getType().getName() + "" + tilePositions[0][0].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[0][1].isOccupied()){
            shelf4R0C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][1].getTile().getType().getName() + "" + tilePositions[0][1].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[0][2].isOccupied()){
            shelf4R0C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][2].getTile().getType().getName() + "" + tilePositions[0][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[0][3].isOccupied()){
            shelf4R0C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][3].getTile().getType().getName() + "" + tilePositions[0][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[0][4].isOccupied()){
            shelf4R0C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[0][4].getTile().getType().getName() + "" + tilePositions[0][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[1][0].isOccupied()){
            shelf4R1C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][0].getTile().getType().getName() + "" + tilePositions[1][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[1][1].isOccupied()){
            shelf4R1C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][1].getTile().getType().getName() + "" + tilePositions[1][1].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[1][2].isOccupied()){
            shelf4R1C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][2].getTile().getType().getName() + "" + tilePositions[1][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[1][3].isOccupied()){
            shelf4R1C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][3].getTile().getType().getName() + "" + tilePositions[1][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[1][4].isOccupied()){
            shelf4R1C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[1][4].getTile().getType().getName() + "" + tilePositions[1][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][0].isOccupied()){
            shelf4R2C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][0].getTile().getType().getName() + "" + tilePositions[2][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][1].isOccupied()){
            shelf4R2C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][1].getTile().getType().getName() + "" + tilePositions[2][1].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][2].isOccupied()){
            shelf4R2C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][2].getTile().getType().getName() + "" + tilePositions[2][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][3].isOccupied()){
            shelf4R2C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][3].getTile().getType().getName() + "" + tilePositions[2][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[2][4].isOccupied()){
            shelf4R2C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[2][4].getTile().getType().getName() + "" + tilePositions[2][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[3][0].isOccupied()){
            shelf4R3C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][0].getTile().getType().getName() + "" + tilePositions[3][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[3][1].isOccupied()){
            shelf4R3C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][1].getTile().getType().getName() + "" + tilePositions[3][1].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[3][2].isOccupied()){
            shelf4R3C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][2].getTile().getType().getName() + "" + tilePositions[3][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[3][3].isOccupied()){
            shelf4R3C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][3].getTile().getType().getName() + "" + tilePositions[3][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[3][4].isOccupied()){
            shelf4R3C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[3][4].getTile().getType().getName() + "" + tilePositions[3][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[4][0].isOccupied()){
            shelf4R4C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][0].getTile().getType().getName() + "" + tilePositions[4][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[4][1].isOccupied()){
            shelf4R4C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][1].getTile().getType().getName() + "" + tilePositions[4][1].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[4][2].isOccupied()){
            shelf4R4C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][2].getTile().getType().getName() + "" + tilePositions[4][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[4][3].isOccupied()){
            shelf4R4C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][3].getTile().getType().getName() + "" + tilePositions[4][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[4][4].isOccupied()){
            shelf4R4C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[4][4].getTile().getType().getName() + "" + tilePositions[4][4].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[5][0].isOccupied()){
            shelf4R5C0.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][0].getTile().getType().getName() + "" + tilePositions[5][0].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[5][1].isOccupied()){
            shelf4R5C1.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][1].getTile().getType().getName() + "" + tilePositions[5][1].getTile().getVariant().getNumber() + ".png"));
        }
        if (tilePositions[5][2].isOccupied()){
            shelf4R5C2.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][2].getTile().getType().getName() + "" + tilePositions[5][2].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[5][3].isOccupied()){
            shelf4R5C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][3].getTile().getType().getName() + "" + tilePositions[5][3].getTile().getVariant().getNumber() + ".png"));
        }

        if (tilePositions[5][4].isOccupied()){
            shelf4R5C4.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/" + tilePositions[5][4].getTile().getType().getName() + "" + tilePositions[5][4].getTile().getVariant().getNumber() + ".png"));
        }
    }



    public void setEnableSendButton(boolean enable){
        this.choiceSendButton.setDisable(!enable);
    }

    public void DrawFromBoard(){
        int counter = (int)choiceNumTileSpinner.getValue();

        ArrayList<TilePositionBoard> tilesToRemove = new ArrayList<TilePositionBoard>();
        ArrayList<TilePositionBoard> boardPlacementsCopy = this.viewMyShelfie.getCurrentGame().getBoard().getPlacements();

        int x1 = Integer.parseInt(choiceX1TextField.getText());
        int x2;
        int x3;

        int y1 = Integer.parseInt(choiceY1TextField.getText());
        int y2;
        int y3;

        for(TilePositionBoard item : boardPlacementsCopy){
            if(item.getX() == x1 && item.getY() == y1){
                tilesToRemove.add(item);
                break;
            }
        }

        switch(counter){
            case 2:

                x2= Integer.parseInt(choiceX2TextField.getText());
                y2 = Integer.parseInt(choiceY2TextField.getText());

                for(TilePositionBoard item : boardPlacementsCopy){
                    if(item.getX() == x2 && item.getY() == y2){
                        tilesToRemove.add( item);
                        break;
                    }
                }
            break;

            case 3:
                x2= Integer.parseInt(choiceX2TextField.getText());
                y2 = Integer.parseInt(choiceY2TextField.getText());
                x3 = Integer.parseInt(choiceX3TextField.getText());
                y3 = Integer.parseInt(choiceY3TextField.getText());

                for(TilePositionBoard item : boardPlacementsCopy){
                    if(item.getX() == x2 && item.getY() == y2){
                        tilesToRemove.add(item);
                    }
                    if(item.getX() == x3 && item.getY() == y3){
                        tilesToRemove.add(item);
                    }
                }

            break;
        }

        int columOfShelves = Integer.parseInt(choiceShelfColumnNumTextField.getText());

        int order[] = new int[tilesToRemove.size()];

        //.DEBUG
        //this.showInfoMessage("Tiles to remove: " + tilesToRemove.size() + "Counter: " + counter , this.viewMyShelfie.frame.getStage());

        try{
            switch (tilesToRemove.size()){
                case 1:
                    order[0] = Integer.parseInt(choiceOrder1TextField.getText());
                case 2:
                    order[0] = Integer.parseInt(choiceOrder1TextField.getText());;
                    order[1] = Integer.parseInt(choiceOrder2TextField.getText());
                    break;
                case 3:
                    order[0] = Integer.parseInt(choiceOrder1TextField.getText());;
                    order[1] = Integer.parseInt(choiceOrder2TextField.getText());
                    order[2] = Integer.parseInt(choiceOrder3TextField.getText());
                    break;
            }
        } catch (Exception e) {
            //.DEBUG
            //caso in cui la carta pescata non e' in una posizione corretta!
            //e.printStackTrace();
        }


        DrawFromBoardMessage message = new DrawFromBoardMessage(tilesToRemove,columOfShelves,this.viewMyShelfie.getCurrentGame().getCurrentGameId(), order);

        ChoiceMyShelfie pc = ChoiceMyShelfie.DRAW_FROM_BOARD;

        Choice c = new Choice(pc, this.viewMyShelfie.getPlayer(),message);

        this.viewMyShelfie.iAlreadyDrawn = true;
        this.setEnableSendButton(false);

        this.viewMyShelfie.deliverGuiRequest(c);
    }

    public void terminateTurn(){
        this.viewMyShelfie.deliverGuiRequest( new Choice(ChoiceMyShelfie.TERMINATE_TURNS, this.viewMyShelfie.getPlayer(),this.viewMyShelfie.getCurrentGame().getCurrentGameId()));
        this.setEnableSendButton(false);
    }

    @FXML
    private void initialize() {
        choiceX2TextField.setDisable(true);
        choiceX2TextField.setOpacity(0.5);
        choiceY2TextField.setDisable(true);
        choiceY2TextField.setOpacity(0.5);
        choiceX3TextField.setDisable(true);
        choiceX3TextField.setOpacity(0.5);
        choiceY3TextField.setDisable(true);
        choiceY3TextField.setOpacity(0.5);
        choiceOrder2TextField.setDisable(true);
        choiceOrder2TextField.setOpacity(0.5);
        choiceOrder3TextField.setDisable(true);
        choiceOrder3TextField.setOpacity(0.5);

        c1Points.setEditable(false);
        c2Points.setEditable(false);

        UnaryOperator<TextFormatter.Change> integerFilterXY = change -> {
            String newText = change.getControlNewText();
            if ((newText.matches("\\d*") && newText.length() == 1 && Integer.valueOf(newText) >= 0
                    && Integer.valueOf(newText) <= 8) || newText.isEmpty()) {
                return change;
            }
            return null;
        };


        for (int i = 0; i < 6; i++) {
            TextFormatter<String> textFormatter = new TextFormatter<>(integerFilterXY);
            textFormattersList1.add(textFormatter);
        }

        choiceX1TextField.setTextFormatter(textFormattersList1.get(0));
        choiceY1TextField.setTextFormatter(textFormattersList1.get(1));
        choiceX2TextField.setTextFormatter(textFormattersList1.get(2));
        choiceY2TextField.setTextFormatter(textFormattersList1.get(3));
        choiceX3TextField.setTextFormatter(textFormattersList1.get(4));
        choiceY3TextField.setTextFormatter(textFormattersList1.get(5));


        UnaryOperator<TextFormatter.Change> integerFilterChoiceOrder = change -> {
            String newText = change.getControlNewText();
            if ((newText.matches("\\d*") && newText.length() == 1 && Integer.valueOf(newText) >= 1 &&
                    Integer.valueOf(newText) <= 3) || newText.isEmpty()) {
                return change;
            }
            return null;
        };

        for (int i = 0; i < 3; i++) {
            TextFormatter<String> textFormatter = new TextFormatter<>(integerFilterChoiceOrder);
            textFormattersList2.add(textFormatter);
        }

        choiceOrder1TextField.setTextFormatter(textFormattersList2.get(0));
        choiceOrder2TextField.setTextFormatter(textFormattersList2.get(1));
        choiceOrder3TextField.setTextFormatter(textFormattersList2.get(2));


        UnaryOperator<TextFormatter.Change> integerFilterColumn = change -> {
            String newText = change.getControlNewText();
            if ((newText.matches("\\d*") && newText.length() == 1 &&
                    Integer.valueOf(newText) >= 0 && Integer.valueOf(newText) <= 4) || newText.isEmpty()) {
                return change;
            }
            return null;
        };

        TextFormatter<String> textFormatterColumn = new TextFormatter<>(integerFilterColumn);
        choiceShelfColumnNumTextField.setTextFormatter(textFormatterColumn);


        UnaryOperator<TextFormatter.Change> integerFilterPlayerNum = change -> {
            String newText = change.getControlNewText();
            if ((newText.matches("\\d*") && newText.length() == 1 &&
                    Integer.valueOf(newText) >= 2 && Integer.valueOf(newText) <= 4) || newText.isEmpty()) {
                return change;
            }
            return null;
        };

        TextFormatter<String> textFormatterPlayer = new TextFormatter<>(integerFilterPlayerNum);
        playerNumberTextField.setTextFormatter(textFormatterPlayer);


        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 3);
        choiceNumTileSpinner.setValueFactory(valueFactory);
        choiceNumTileSpinner.setEditable(false);


        loginPane.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                joinGameButton.fire();
            }
        });


        BooleanBinding isFieldsEmpty = Bindings.createBooleanBinding(
                () -> usernameTextField.getText().isEmpty() || playerNumberTextField.getText().isEmpty(),
                usernameTextField.textProperty(),
                playerNumberTextField.textProperty()
        );
        joinGameButton.disableProperty().bind(isFieldsEmpty);


        choiceNumTileSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {

            int value = (int) newValue;
            if (value == 1) {
                choiceX2TextField.setDisable(true);
                choiceX2TextField.setOpacity(0.5);
                choiceY2TextField.setDisable(true);
                choiceY2TextField.setOpacity(0.5);
                choiceX3TextField.setDisable(true);
                choiceX3TextField.setOpacity(0.5);
                choiceY3TextField.setDisable(true);
                choiceY3TextField.setOpacity(0.5);
                choiceOrder2TextField.setDisable(true);
                choiceOrder2TextField.setOpacity(0.5);
                choiceOrder3TextField.setDisable(true);
                choiceOrder3TextField.setOpacity(0.5);
            } else if (value == 2) {
                choiceX2TextField.setDisable(false);
                choiceX2TextField.setOpacity(1);
                choiceY2TextField.setDisable(false);
                choiceY2TextField.setOpacity(1);
                choiceX3TextField.setDisable(true);
                choiceX3TextField.setOpacity(0.5);
                choiceY3TextField.setDisable(true);
                choiceY3TextField.setOpacity(0.5);
                choiceOrder2TextField.setDisable(false);
                choiceOrder2TextField.setOpacity(1);
                choiceOrder3TextField.setDisable(true);
                choiceOrder3TextField.setOpacity(0.5);
            } else if (value == 3) {
                choiceX2TextField.setDisable(false);
                choiceX2TextField.setOpacity(1);
                choiceY2TextField.setDisable(false);
                choiceY2TextField.setOpacity(1);
                choiceX3TextField.setDisable(false);
                choiceX3TextField.setOpacity(1);
                choiceY3TextField.setDisable(false);
                choiceY3TextField.setOpacity(1);
                choiceOrder2TextField.setDisable(false);
                choiceOrder2TextField.setOpacity(1);
                choiceOrder3TextField.setDisable(false);
                choiceOrder3TextField.setOpacity(1);
        }
        });
    }

    public void showError(String ErrorMessage, Stage stage) {
        MessageService messageService = new MessageService(ErrorMessage);

        messageService.setOnSucceeded(event -> {
            String message = messageService.getValue();
            if (message != null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(message);

                alert.initOwner(stage);

                alert.setX(stage.getX() + stage.getWidth() / 2 - alert.getWidth() / 2);
                alert.setY(stage.getY() + stage.getHeight() / 2 - alert.getHeight() / 2);

                alert.showAndWait();
            }
        });
        messageService.start();
    }

    public void showInfoMessage(String msg, Stage stage) {
        MessageService messageService = new MessageService(msg);

        messageService.setOnSucceeded(event -> {
            String message = messageService.getValue();
            if (message != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText(message);

                alert.initOwner(stage);

                alert.setX(stage.getX() + stage.getWidth() / 2 - alert.getWidth() / 2);
                alert.setY(stage.getY() + stage.getHeight() / 2 - alert.getHeight() / 2);

                alert.showAndWait();
            }
        });
        messageService.start();
    }

    private static class MessageService extends Service<String> {
        String message;
        public  MessageService(String message) {
            this.message = message;
        }
        @Override
        protected Task<String> createTask() {
            return new Task<String>() {
                @Override
                protected String call() throws Exception {
                        return "Message: " + message;
                }
            };
        }
    }

}