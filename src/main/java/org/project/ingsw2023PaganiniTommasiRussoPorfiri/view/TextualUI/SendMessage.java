package org.project.ingsw2023PaganiniTommasiRussoPorfiri.view.TextualUI;

import java.io.Serializable;

public class SendMessage implements Serializable {
    private String message;
    private int currentGameId;

    public SendMessage(String message, int currentGameId){
        this.message = message;
        this.currentGameId = currentGameId;
    }

    public String getMessage() {
        return message;
    }

    public int getCurrentGameId() {
        return currentGameId;
    }
}
