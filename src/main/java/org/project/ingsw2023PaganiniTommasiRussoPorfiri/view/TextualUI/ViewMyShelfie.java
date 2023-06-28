package org.project.ingsw2023PaganiniTommasiRussoPorfiri.view.TextualUI;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.HelloApplication;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.HelloController;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils.*;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.view.SwingUI.LoginGUI;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ViewMyShelfie extends Observable<ChoiceMyShelfie> implements Runnable {

    private enum State {
        WAITING_FOR_PLAYER,
        WAITING_FOR_OUTCOME
    }

    private State state = State.WAITING_FOR_PLAYER;
    private final Object lock = new Object();

    private Player player;
    private Game currentGame = null;

    private boolean iAlreadyDrawn = false;

    public LoginGUI frameLogin = new LoginGUI(this);

    public HelloApplication frame;

    public HelloController controller;

    private int currentGameId = -1; //verrà assegnato dopo aver fatto join_game!!

    public void update(TurnView model/*risposta dal server*/, Choice arg/*evento che il client remoto ha scelto*/) {

        //se presente stampo qualcosa se no stringa vuota!
        System.err.println(model.getError());


        if (model.getError() != "") {
            switch (model.getError()){
                case "IllegalColumnException":
                case "IllegalSizeOfTilesException":
                case "DuplicatesInRequestedTilesException":
                case "TilesAreNotRemovableException":
                case "PositionEmptyException":
                case "WrongNumberOfTilesException":
                case "BoardDoesNotContainThisPositionException":
                    this.iAlreadyDrawn = false;
                break;

            }
        }



        try {
            if (model.getMyShelfie().getGame(this.currentGameId).getState().equals(GameStatus.OVER)){
                //caso in cui ho terminato una partita
                //stampa del ranking
                this.currentGame =model.getMyShelfie().getGame(this.currentGameId);
                System.out.println("RANKING: ");
                try {
                    this.currentGame.getRanking().stream()
                            .forEach((rank)->{System.out.println(rank.toString());});
                }catch (Exception e){
                    e.printStackTrace();
                }
                //CLEAR STATE
                currentGame = null;
                currentGameId = -1;
                this.player.setShelves(new Shelves());
                this.setState(State.WAITING_FOR_PLAYER);
            }else {
                inGame(model, arg);
            }
        } catch (Exception e){
            //.DEBUG
            //e.printStackTrace();
            inGame(model, arg);
        }

         //.DEBUG
        //System.err.println(this.toString());

    }

    public void inGame(TurnView model/*risposta dal server*/, Choice arg/*evento che il client remoto ha scelto*/){
        if (currentGameId == -1){ //inizializzazione di tutte le variabili di gioco
            joiningPart(model,arg);
        }else{
            //aggiorno client -> da fare ogni volta che avviene qualsiasi cosa!! -> da non mettere fuori perché getMyShelfie() puo essere null!
            this.currentGame = model.getMyShelfie().getGame(this.currentGameId);
            this.player= this.currentGame.getPlayer(this.player.getId());//così ho a portata di mano la shelves aggiornata!

            //ho gia fatto join!
            //faccio operazioni sse sono avvenute sul mio game!
            boolean isMyGame = false;
            for (Player p : this.currentGame.getPlayers()){
                if (p.getId() == arg.getPlayer().getId()){
                    isMyGame = true;
                }
            }
            if (isMyGame){ //se il player che ha fatto l'azione è presente nel mio game
                choicePart( model, arg);
            }
        }
    }

    //PRIMA ESECUZIONE
    @Override
    public void run() {
        try {
            //creazione del giocatore
            System.out.println("\n\n" +
                    "  __  __              _____   _              _    __   _        \n" +
                    " |  \\/  |            / ____| | |            | |  / _| (_)       \n" +
                    " | \\  / |  _   _    | (___   | |__     ___  | | | |_   _    ___ \n" +
                    " | |\\/| | | | | |    \\___ \\  | '_ \\   / _ \\ | | |  _| | |  / _ \\\n" +
                    " | |  | | | |_| |    ____) | | | | | |  __/ | | | |   | | |  __/\n" +
                    " |_|  |_|  \\__, |   |_____/  |_| |_|  \\___| |_| |_|   |_|  \\___|\n" +
                    "            __/ |                                               \n" +
                    "           |___/                                                \n");

            System.out.println("\nWELCOME NEW PLAYER! To start playing you must first enter your data");
            System.out.println("Username: ");
            Scanner s = new Scanner(System.in);
            this.player = new Player(s.next());

            texView();
            //fine creazione

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void texView(){
        //noinspection InfiniteLoopStatement
        while (true) {
            while (getState() == State.WAITING_FOR_OUTCOME) {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        System.err.println("Interrupted while waiting for server: " + e.getMessage());
                    }
                }
            }
            if (this.currentGame == null) {
                System.out.println("\n" +
                        "____          ________ _      _____ ____  __  __ ______   _______ ____    __  ____     __   _____ _    _ ______ _      ______ _____ ______   _ \n" +
                        " \\ \\        /  / ____ | |   / ____/  __ \\|  \\/  | ____| |__   __/ __   \\ |  \\/  \\ \\   / /  / ____| |  | |  ____| |    |  ____|_   _|  ____| | |\n" +
                        "  \\ \\  //\\  / /| |__  | |   | |   | |  | | \\  / | |__       | | | |  | | | \\  / |\\ \\_/ /  | (___ | |__| | |__  | |    | |__    | | | |__    | |\n" +
                        "   \\ \\//  \\/ / |  __| | |   | |   | |  | | |\\/| |  __|      | | | |  | | | |\\/| | \\   /    \\___ \\|  __  |  __| | |    |  __|   | | |  __|   | |\n" +
                        "    \\  //\\  /  | |____| |___| |___| |__| | |  | | |____     | | | |__| | | |  | |  | |     ____) | |  | | |____| |____| |     _| |_| |____  |_|\n" +
                        "     \\//  \\/   |______|______\\_____\\____/|_|  |_|______|    |_|  \\____/  |_|  |_|  |_|    |_____/|_|  |_|______|______|_|    |_____|______| (_)\n");

                /* Player chooses  POSSIBLE ONLY JOINGAME! */
                ChoiceMyShelfie pc = ChoiceMyShelfie.JOIN_GAME;
                Object argument = askPlayerArgumentMyshelfie(pc);

                Choice c =new Choice(pc,player, argument);

                System.out.println("Waiting for the server... ");

                setState(State.WAITING_FOR_OUTCOME);
                setChanged();/*NOTIFICO AL SERVER che del client ha fatto scelta!!*/
                notifyObservers(c);
            }else {
                ChoiceMyShelfie pc = askPlayerChoiceMyShelfie();
                Object argument = askPlayerArgumentMyshelfie(pc);

                Choice c =new Choice(pc,player, argument);

                System.out.println("Waiting for the server... ");

                setState(State.WAITING_FOR_OUTCOME);
                setChanged();/*NOTIFICO AL SERVER che del client ha fatto scelta!!*/
                notifyObservers(c);
            }

        }
    }

    public void deliverGuiRequest(Choice c){

        setState(State.WAITING_FOR_OUTCOME);
        setChanged();/*NOTIFICO AL SERVER che del client ha fatto scelta!!*/
        notifyObservers(c);
    }


    public ChoiceMyShelfie askPlayerChoiceMyShelfie() {
        Scanner s = new Scanner(System.in);
        System.out.println("\nNow is your turn! ");
        System.out.println(
                "Signs: " +
                        Arrays.stream(ChoiceMyShelfie.values())
                                .map(ChoiceMyShelfie::name)
                                .collect(
                                        Collectors.joining(",", "[", "]")));
        System.out.println("\nMake your choice: ");
        while (true) {
            String input = s.next();
            try {
                switch (ChoiceMyShelfie.valueOf(input)){
                    case SHOW_MY_SHELVES:
                        System.out.println("Your current shelves are: \n");
                        try {
                            printTilePositionShelves(this.player.getShelves().showShelves());
                        }catch (Exception e){
                            System.err.println("Error occurred displaying your shelves! ");
                            e.printStackTrace();
                        }
                        return askPlayerChoiceMyShelfie();
                    case SHOW_COMMON_CARDS:
                        System.out.println("Common Cards are:  \n");
                        try {
                            System.out.println("Common Card 1: " + this.currentGame.getCommon1().getDescription());
                            System.out.println("  point: " + this.currentGame.getPointCommonCard1());
                            System.out.println("Common Card 2: " + this.currentGame.getCommon2().getDescription());
                            System.out.println("  point: " + this.currentGame.getPointCommonCard2());
                        }catch (Exception e){
                            System.err.println("Error occurred displaying COMMON CARD! ");
                            e.printStackTrace();
                        }
                        return askPlayerChoiceMyShelfie();

                    case SHOW_PERSONAL_CARDS:
                        System.out.println("Your Personal Card is: \n");
                        try {
                            System.out.println("Personal Card: " + this.player.getPC().toString());
                        }catch (Exception e){
                            System.err.println("Error occurred displaying PERSONAL CARD! ");
                            e.printStackTrace();
                        }
                        return askPlayerChoiceMyShelfie();


                    case SHOW_BOARD:
                        System.out.println(" Current BOARD: \n");
                        try {
                            //V1
                            //this.current_game.getBoard().showBoard().stream().forEach(placement->System.out.println(placement.toString()));
                            //V2
                            printTilePositionBoard(this.currentGame.getBoard().showBoard());
                        }catch (Exception e){
                            System.err.println("Error occurred displaying your BOARD! ");
                            e.printStackTrace();
                        }
                        return askPlayerChoiceMyShelfie();
                    case DRAW_FROM_BOARD:
                        if (this.iAlreadyDrawn == true) {
                            System.out.println("You have already drawn a tile from the board! ");
                            return askPlayerChoiceMyShelfie();
                        }else {
                            this.iAlreadyDrawn = true;
                        }
                    break;

                    case TERMINATE_TURNS:
                        if (this.iAlreadyDrawn == false) {
                            System.out.println("You have to draw a tile from the board! ");
                            return askPlayerChoiceMyShelfie();
                        }else {
                            this.iAlreadyDrawn = false;
                        }
                }
                return ChoiceMyShelfie.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.err.println("I don't know this choice: " + input);
                System.err.println("Try again...");
            }
        }
    }

    private Object askPlayerArgumentMyshelfie(ChoiceMyShelfie pc) {
        System.out.println();
        Scanner s = new Scanner(System.in);

        switch (pc){
            case JOIN_GAME:
                System.out.println("Enter the number of players in the game: ");
                return  Integer.parseInt(s.next());

            case TERMINATE_TURNS:
                return this.currentGameId;//oggetto da passare come argomento è l'id della partita corrente.
            case DRAW_FROM_BOARD:
                try{
                    //faccio qui tutti i controlli così sono sicuro di passare al server solo i dati giusti tanto la board viene aggiornata a ogni turno!

                    System.out.println("Enter the number of tiles to draw: ");
                    int counter = Integer.parseInt(s.next());
                    ArrayList<TilePositionBoard> tilesToRemove = new ArrayList<TilePositionBoard>();
                    ArrayList<TilePositionBoard> boardPlacementsCopy = currentGame.getBoard().getPlacements();

                    for (int i = 0; i < counter; i++) {
                        System.out.println("Enter the x coordinate, corresponding to the row of the tile to draw: ");
                        int x = Integer.parseInt(s.next());
                        System.out.println("Enter the y coordinate, corresponding to the column of the tile to draw: ");
                        int y = Integer.parseInt(s.next());

                        for(TilePositionBoard item : boardPlacementsCopy){
                            if(item.getX() == x && item.getY() == y){
                                tilesToRemove.add(i, item);
                                break;
                            }
                        }

                        //tilesToRemove.get(0).setTile(new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));


                    }

                    int order[] = new int[tilesToRemove.size()];
                    ArrayList<TilePositionBoard> orderedTilesToRemove = new ArrayList<TilePositionBoard>();

                    while(true) {
                        try {
                            for (int i = 0; i < tilesToRemove.size(); i++) {
                                System.out.println("Enter in what order you want to insert the tile into position: x " + tilesToRemove.get(i).getX() + " y "+tilesToRemove.get(i).getY()+" to place in the library: ");
                                order[i] = Integer.parseInt(s.next());
                            }
                            //devo provare a fare rimozione!! solo per essere sicuro che i dati sono corretti; ordinamento effettivo verrà fatto dal controller
                            for (int i = 0; i < tilesToRemove.size(); i++) {
                                orderedTilesToRemove.add(tilesToRemove.get(order[i] - 1));
                            }
                            break;//ordinamento andato a buon fine
                        } catch (Exception e2) {
                            System.err.println("Error occurred while ordering tiles! ");
                            e2.printStackTrace();
                        }
                    }
                    //.DEBUG
                    //System.err.println("Tiles you have chosen to remove: "+tilesToRemove);
                    //for(int i = 0; i < orderedTilesToRemove.size();i++) {
                    //    System.out.println("tile: " + orderedTilesToRemove.get(i));
                    //}
                    System.out.println("Insert the column of your library where to put this tile: ");
                    int columOfShelves = Integer.parseInt(s.next());

                    //checkInput(tilesToRemove,columOfShelves);
                    return new DrawFromBoardMessage(tilesToRemove,columOfShelves,this.currentGameId,order);
                }catch (Exception e){
                    System.err.println("Generic error occurred! ");
                    e.printStackTrace();
                }
            case EXIT:
                return this.currentGameId;//oggetto da passare come argomento è l'id della partita corrente.

        }
        return null;
    }

    private void checkInput(ArrayList<TilePositionBoard> tilesToRemove, int columOfShelves) throws Exception{
        try {
            //PROVA A VEDERE SE FUNZIONA MA SECONDO ME NO! POICHE GAME RITORNATO DA SERVER E' FINAL!! (non piu) pero brutto!
            //RIMOZIONE DA BOARD:
            ArrayList<TileObj> tilesRemoved=this.currentGame.getBoard().removeTiles(tilesToRemove);

            //INSERIMENTO IN SHELVS:
            //this.player.putTilesInShelf(tilesRemoved,columOfShelves);

            }
            //ERRORI DI RIMOZIONE DA BOARD!
            catch (TilesAreNotRemovableException e){
                //non c'è bisogno di rimettere le tessere nella board!
                e.printStackTrace();
                System.err.println("Error entering data!\n"+e.getMessage()+ "`\n Retry! \n");

            }catch (PositionEmptyException e) {
                //non c'è bisogno di rimettere le tessere nella board!
                //e.printStackTrace();
                System.err.println("Error entering data!\n"+e.getMessage()+ "`\n Retry! \n");
            }
    }

    public void joiningPart(TurnView model, Choice arg) {
        //USERNAME DEVE ESSERE UNIVOCO
        if (this.player != null) {
            if(arg.getPlayer().getUsername().equals( this.player.getUsername())){
                switch (model.getPlayerChoice().getState()) {
                    case CPU_CHOICE -> {
                        switch (model.getPlayerChoice().getChoice()) {
                            case JOIN_GAME:

                                this.player.setId(arg.getPlayer().getId());
                                //aggiorno la variabile this.current_game_id e current_game
                                for (int i = 0; i < model.getMyShelfie().getGames().size(); i++) {
                                    boolean isPlayerInThisGame = false;
                                    for (int j = 0; j < model.getMyShelfie().getGames().get(i).getPlayers().size(); j++) {
                                        if (model.getMyShelfie().getGames().get(i).getPlayers().get(j).getId() == this.player.getId()) {
                                            isPlayerInThisGame = true;
                                            break;
                                        }
                                    }
                                    if (isPlayerInThisGame == true){
                                        switch (model.getMyShelfie().getGames().get(i).getState()) {//le partite saranno o in attesa o in corso!
                                            case IN_PROGRESS://non dovrebbe mai arrivarci!
                                                System.out.println("\nYou just joined the game and the match is under way!\n");
                                                //System.err.println("partita a cui ti sei unito in corso: " + model.getMyShelfie().getGames().get(i).toString());
                                                this.currentGameId = model.getMyShelfie().getGames().get(i).getCurrentGameId();
                                                this.currentGame = model.getMyShelfie().getGames().get(i);
                                                /*prova aggiornamento gui*/
                                                SwingUtilities.invokeLater(() -> {
                                                    this.frameLogin.usernameField.setText("You just joined the game and the match is under way!");
                                                    this.frameLogin.joinGameButton.setEnabled(false);
                                                    //grazie a me la partita si e'startata!
                                                    this.frameLogin.setVisible(false);

                                                });

                                                Platform.startup(() -> {
                                                    Platform.runLater(() -> {
                                                        //this.initFxGui();

                                                    });
                                                });

                                            break;
                                            case IN_WAIT://siccome non esiste una partita di un solo giocatore entrerò sempre qui!
                                                /*prova aggiornamento gui*/
                                                SwingUtilities.invokeLater(() -> {
                                                    this.frameLogin.usernameField.setText("You just joined a game and you are waiting for more players!");
                                                    this.frameLogin.joinGameButton.setEnabled(false);
                                                });

                                                System.out.println("\nYou just joined a game and you are waiting for more players!\n");
                                                //System.err.println("partita a cui ti sei unito in corso: " + model.getMyShelfie().getGames().get(i).toString());
                                                this.currentGameId = model.getMyShelfie().getGames().get(i).getCurrentGameId();
                                                //this.current_game = model.getMyShelfie().getGames().get(i);
                                            break;
                                        }
                                    }
                                }
                                //stampo i dati della partita a cui mi sono unito.
                                break;
                            default:
                                System.err.println("You have to join the game first!");
                        }
                    }
                    default -> System.err.println("Error state! Ignoring event from " + model.toString() + ": " + arg.toString());
                }

                System.out.println("The server answered!");
                //this.setState(State.WAITING_FOR_PLAYER);
            }
        }

    }

    public void choicePart(TurnView model, Choice arg) {
        try {
            switch (model.getPlayerChoice().getState()) {
                case CPU_CHOICE -> {
                    switch (model.getPlayerChoice().getChoice()) {


                        case TERMINATE_TURNS:
                            System.out.println(model.getMyShelfie().getGame(this.currentGameId).precCurrentPlayer().getUsername()+" ha terminato il turno! ");
                            System.out.println("Now is: " + model.getMyShelfie().getGame(this.currentGameId).getCurrentPlayer().getUsername() + " turn");
                        break;

                        case JOIN_GAME:
                            System.out.println("Player: "+model.getMyShelfie().getGame(this.currentGameId).getPlayers().get(model.getMyShelfie().getGame(this.currentGameId).getPlayers().size()-1).getUsername()+" just joined the game!");
                            /*prova aggiornamento gui*/
                            SwingUtilities.invokeLater(() -> {
                                this.frameLogin.joinGameButton.setEnabled(false);

                                //se la partaita non e'piu in attesa starto la gui!
                                if(model.getMyShelfie().getGame(this.currentGameId).getState() == GameStatus.IN_PROGRESS){
                                    this.frameLogin.setVisible(false);
                                }
                            });

                            Platform.startup(() -> {
                                Platform.runLater(() -> {
                                   // this.initFxGui();
                                });
                            });
                        break;
                        case DRAW_FROM_BOARD:
                            System.out.println("Player: "+model.getMyShelfie().getGame(this.currentGameId).getCurrentPlayer().getUsername()+" HA PESCATO DALLA PLANCIA!");
                        break;
                        case EXIT:
                            System.out.println("Player: "+model.getMyShelfie().getGame(this.currentGameId).getCurrentPlayer().getUsername()+" HA FORZATO LA CHIUSURA DEL GIOCO ALLA FINE DEL GIRO!");
                        break;
                        default:
                            System.err.println("Not implemented yet");
                    }
                }
                default -> System.err.println("Error state! Ignoring event from " + model.toString() + ": " + arg.toString());
            }
        } catch (Exception e) {
            System.out.println("This game generated an error: " + model.getMyShelfie().getGame(this.currentGameId).toString());
            e.printStackTrace();
        }

        //se è il mio turno faccio qualcosa!!
        // nota e' il mio turno sse la partita e. in corso
        if (model.getMyShelfie().getGame(this.currentGameId).getCurrentPlayer() != null) {
            if (model.getMyShelfie().getGame(this.currentGameId).getCurrentPlayer().getId() == this.player.getId()) {
                System.out.println("Server answered!");
                this.setState(State.WAITING_FOR_PLAYER);

            }

        }
    }


    private State getState() {
        synchronized (lock) {
            return state;
        }
    }

    private void setState(State state) {
        synchronized (lock) {
            this.state = state;
            lock.notifyAll();
        }
    }

    @Override
    public String toString() {
        return "View_my_shelfie{" +
                "\nstate=" + state +
                ",\n lock=" + lock +
                ",\n player=" + player +
                ",\n currentGame=" + currentGame +
                ",\n currentGameId=" + currentGameId +
                "\n}";
    }

    public void printTilePositionBoard(ArrayList<TilePositionBoard> board) {
        // Trova le dimensioni massime della matrice
        int maxX = 0;
        int maxY = 0;
        for (TilePositionBoard tile : board) {
            if (tile.getX() > maxX)
                maxX = tile.getX();
            if (tile.getY() > maxY)
                maxY = tile.getY();
        }

        // Crea la matrice 2D
        TilePositionBoard[][] matrix = new TilePositionBoard[maxX + 1][maxY + 1];
        for (TilePositionBoard tile : board) {
            matrix[tile.getX()][tile.getY()] = tile;
        }

        // Stampa la matrice 2D
        for (int y = 0; y <= maxY; y++) {
            for (int x = 0; x <= maxX; x++) {
                TilePositionBoard tile = matrix[x][y];
                if (tile != null) {
                    System.out.print(tile + " ");
                } else {
                    // Stampa uno spazio vuoto
                    System.out.print("------------------- ");
                }
            }
            System.out.println();
        }
    }

    public void printTilePositionShelves(TilePositionShelves[][] shelves) {

        // Stampa la matrice 2D
        for (int x = shelves.length-1; x > -1; x--) {
            for (int y = 0; y < shelves[y].length; y++) {
                TilePositionShelves tile = shelves[x][y];
                if (tile != null) {
                    System.out.print(tile + " ");
                } else {
                    // Stampa uno spazio vuoto
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    /*
    public void initFxGui(){
        this.frame = new HelloApplication();
        try {
            frame.start(new Stage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        this.controller = frame.getController();
        controller.updateBoard(this.currentGame.getBoard().getPlacements());
    }
    */

}

