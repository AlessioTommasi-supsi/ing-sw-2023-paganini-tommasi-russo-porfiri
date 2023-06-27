package org.project.ingsw2023PaganiniTommasiRussoPorfiri.view.JavaFxUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class GameGUIFx extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameGUIFx.class.getResource("../../../../../resources/org.project/gameGUI-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MyShelfie");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}
