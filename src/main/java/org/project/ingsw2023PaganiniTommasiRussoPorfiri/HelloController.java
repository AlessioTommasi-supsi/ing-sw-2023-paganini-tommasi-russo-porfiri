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
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.Choice;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.ChoiceMyShelfie;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.Player;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.TilePositionBoard;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.view.TextualUI.DrawFromBoardMessage;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.view.TextualUI.ViewMyShelfie;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.UnaryOperator;

public class HelloController {
    @FXML
    private Pane mainPane;
    @FXML
    Pane loginPane;
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
    private TextField usernameTextField;
    @FXML
    private ScrollPane choiceScrollPane;

    @FXML
    Text choiceTextField1;

    @FXML
    Button choiceSendButton;

    ArrayList<TextFormatter<String>> textFormattersList1 = new ArrayList<>();
    ArrayList<TextFormatter<String>> textFormattersList2 = new ArrayList<>();

    public ViewMyShelfie viewMyShelfie=null;

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

    public void updateShelves(ArrayList<Player> players){
        //TODO
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

        int o1= Integer.parseInt(choiceOrder1TextField.getText());
        int o2;
        int o3;

        for(TilePositionBoard item : boardPlacementsCopy){
            if(item.getX() == x1 && item.getY() == y1){
                tilesToRemove.add(o1-1, item);
                break;
            }
        }

        switch(counter){
            case 2:
                x2= Integer.parseInt(choiceX2TextField.getText());
                y2 = Integer.parseInt(choiceY2TextField.getText());
                o2= Integer.parseInt(choiceOrder2TextField.getText());

                for(TilePositionBoard item : boardPlacementsCopy){
                    if(item.getX() == x2 && item.getY() == y2){
                        tilesToRemove.add(o2-1, item);
                        break;
                    }
                }
            break;

            case 3:
                x2= Integer.parseInt(choiceX2TextField.getText());
                y2 = Integer.parseInt(choiceY2TextField.getText());
                x3 = Integer.parseInt(choiceX3TextField.getText());
                y3 = Integer.parseInt(choiceY3TextField.getText());
                o2= Integer.parseInt(choiceOrder2TextField.getText());
                o2= Integer.parseInt(choiceOrder3TextField.getText());

                for(TilePositionBoard item : boardPlacementsCopy){
                    if(item.getX() == x2 && item.getY() == y2){
                        tilesToRemove.add(o2-1, item);
                        break;
                    }
                    if(item.getX() == x3 && item.getY() == y3){
                        tilesToRemove.add(o2-1, item);
                        break;
                    }
                }
            break;
        }

        int columOfShelves = Integer.parseInt(choiceShelfColumnNumTextField.getText());

        int order[] = {1,2,3};

        DrawFromBoardMessage message = new DrawFromBoardMessage(tilesToRemove,columOfShelves,this.viewMyShelfie.getCurrentGame().getCurrentGameId(), order);

        ChoiceMyShelfie pc = ChoiceMyShelfie.DRAW_FROM_BOARD;

        Choice c = new Choice(pc, this.viewMyShelfie.getPlayer(),message);

        this.viewMyShelfie.deliverGuiRequest(c);
        this.viewMyShelfie.iAlreadyDrawn = true;
        this.setEnableSendButton(false);


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

        UnaryOperator<TextFormatter.Change> integerFilterXY = change -> {
            String newText = change.getControlNewText();
            if ((newText.matches("\\d*") && newText.length() == 1 && Integer.valueOf(newText) >= 0 && Integer.valueOf(newText) <= 8) || newText.isEmpty()) {
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
            if ((newText.matches("\\d*") && newText.length() == 1 && Integer.valueOf(newText) >= 1 && Integer.valueOf(newText) <=3) || newText.isEmpty()) {
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
            if ((newText.matches("\\d*") && newText.length() == 1 && Integer.valueOf(newText) >= 0 && Integer.valueOf(newText) <= 4) || newText.isEmpty()) {
                return change;
            }
            return null;
        };

        TextFormatter<String> textFormatterColumn = new TextFormatter<>(integerFilterColumn);
        choiceShelfColumnNumTextField.setTextFormatter(textFormatterColumn);


        UnaryOperator<TextFormatter.Change> integerFilterPlayerNum = change -> {
            String newText = change.getControlNewText();
            if ((newText.matches("\\d*") && newText.length() == 1 && Integer.valueOf(newText) >= 2 && Integer.valueOf(newText) <= 4) || newText.isEmpty()) {
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

    public void showError(String ErrorMessage, Stage stage) {
        MessageService messageService = new MessageService(ErrorMessage);

        messageService.setOnSucceeded(event -> {
            String message = messageService.getValue();
            if (message != null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Errore");
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
                alert.setTitle("Messaggio");
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
                        return "Messaggio: "+message;
                }
            };
        }
    }

}