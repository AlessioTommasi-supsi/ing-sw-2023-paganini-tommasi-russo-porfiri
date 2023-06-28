package org.project.ingsw2023PaganiniTommasiRussoPorfiri;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
    HelloController controller;

    public HelloController getController() {
        return controller;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        controller = fxmlLoader.getController();
        stage.setScene(scene);
        stage.setTitle("MyShelfie");
        stage.setWidth(1280d);
        stage.setHeight(720d);
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.setFullScreen(false);
        //stage.setFullScreenExitHint("");
        //stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();


        MessageService messageService = new MessageService();

        // Gestisci l'evento quando il messaggio viene ricevuto
        messageService.setOnSucceeded(event -> {
            String message = messageService.getValue();
            if (message != null) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Messaggio ricevuto");
                alert.setHeaderText(null);
                alert.setContentText(message);

                alert.showAndWait();
            }
        });
        messageService.start();


    }

    public static void main(String[] args) {
        launch();
    }


    private static class MessageService extends Service<String> {
        @Override
        protected Task<String> createTask() {
            return new Task<String>() {
                @Override
                protected String call() throws Exception {
                    // Simulazione della ricezione del messaggio in modo casuale
                    Random random = new Random();
                    int delay = random.nextInt(5000) + 1000; // Ritardo casuale tra 1 e 6 secondi
                    Thread.sleep(delay);

                    // Simulazione della ricezione del messaggio
                    if (random.nextBoolean()) {
                        return "Questo è un messaggio casuale";
                    } else {
                        return null; // Nessun messaggio ricevuto
                    }
                }
            };
        }
    }




}