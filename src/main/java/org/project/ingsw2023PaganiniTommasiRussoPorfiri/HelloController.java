package org.project.ingsw2023PaganiniTommasiRussoPorfiri;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.TilePositionBoard;
import java.util.ArrayList;
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

    ArrayList<TextFormatter<String>> textFormattersList1 = new ArrayList<>();
    ArrayList<TextFormatter<String>> textFormattersList2 = new ArrayList<>();


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
        if()
    }

    public void updateBoard(ArrayList<TilePositionBoard> tilePositionBoards) {
        // TODO
        for (int i = 0; i < tilePositionBoards.size() && tilePositionBoards.get(i).isOccupied(); i++) {
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
        }
        //boardR1C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/Gatti1.1.png"));
        //boardR1C3.setImage(new javafx.scene.image.Image("file:src/main/resources/GraphicResources/itemTiles/"+tilePositionBoards.get(0).getTile().getType().getName()+""+tilePositionBoards.get(0).getTile().getVariant().getNumber()+".png"));
    }

    @FXML
    private void initialize() {
        // Operatore unario per limitare l'input ai numeri interi positivi di lunghezza == 1 oppure il backspace
        UnaryOperator<TextFormatter.Change> integerFilterXY = change -> {
            String newText = change.getControlNewText();
            if ((newText.matches("\\d*") && newText.length() == 1 && Integer.valueOf(newText) >= 0 && Integer.valueOf(newText) <= 8) || newText.isEmpty()) {
                return change;
            }
            return null;
        };

        //Creazione dei TextFormatter<String>
        for (int i = 0; i < 6; i++) {
            TextFormatter<String> textFormatter = new TextFormatter<>(integerFilterXY);
            textFormattersList1.add(textFormatter);
        }

        //Applicazione di ciascun TextFormatter a ciascun TextField che deve rispettare la caratteristica sopra
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

        //Proprietà dello Spinner
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 3);
        choiceNumTileSpinner.setValueFactory(valueFactory);
        choiceNumTileSpinner.setEditable(false);

        //Pressione invio comporta pressione joinGameButton
        loginPane.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                joinGameButton.fire(); // Simula un click sul Button
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

}