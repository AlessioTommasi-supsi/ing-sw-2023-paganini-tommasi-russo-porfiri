package org.project.ingsw2023PaganiniTommasiRussoPorfiri.model;

public enum ChoiceMyShelfie {
    DRAW_FROM_BOARD,
    TERMINATE_TURNS,
    JOIN_GAME,
    SHOW_MY_SHELVES,
    //Per guardare la mia libreria non richiamerò server ma verrà vista quella che ho in locale!
    //Ogni volta che immetto qualcosa con IMMMETTI_IN_LIBRERIA verrà aggiornata!

    SHOW_BOARD,
    SHOW_COMMON_CARDS,
    SHOW_PERSONAL_CARDS,
    SHOW_CHAT,
    SEND_MESSAGE,
    //.DEBUG
    EXIT
}
