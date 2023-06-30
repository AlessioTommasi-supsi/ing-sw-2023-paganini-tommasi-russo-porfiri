package org.project.ingsw2023PaganiniTommasiRussoPorfiri;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class GuiApplication extends Application {
    GuiController controller;
    Scene scene;
    Stage stage;
    private static final Object lock = new Object();
    private static int threadCount = 0;

    public GuiController getController() {
        return controller;
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(GuiApplication.class.getResource("GameFxGui.fxml"));
        scene = new Scene(fxmlLoader.load());
        controller = fxmlLoader.getController();
        stage.setScene(scene);
        stage.setTitle("MyShelfie");
        stage.setResizable(false);
        stage.setMaximized(false);
        stage.setFullScreen(false);
        //stage.setFullScreenExitHint("");
        //stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            synchronized (lock) {
                threadCount++;
                launch();
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                threadCount--;
            }
        });

        /*
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        thread.start();
    }

    public Scene getScene() {
        return scene;
    }

    public Stage getStage() {
        return stage;
    }


}