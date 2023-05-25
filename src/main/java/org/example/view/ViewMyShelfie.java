package org.example.view;

import org.example.Model.*;
import org.example.util.*;

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

    private int currentGameId = -1; //verrà assegnato dopo aver fatto join_game!!

    public void update(TurnView model/*risposta dal server*/, Choice arg/*evento che il client remoto ha scelto*/) {

        //se presente stampo qualcosa se no stringa vuota!
        System.err.println(model.getErrore());

        try {
            if (model.getMyShelfie().getGame(this.currentGameId).getStato().equals(StatoPartita.FINITA)){
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
            inGame(model, arg);
        }

         //.DEBUG
        System.err.println(this.toString());

    }

    public void inGame(TurnView model/*risposta dal server*/, Choice arg/*evento che il client remoto ha scelto*/){
        if (currentGameId == -1){ //inizializzazione di tutte le variabili di gioco
            joiningPart(model,arg);
        }else {
            //aggiorno client -> da fare ogni volta che avviene qualsiasi cosa!! -> da non mettere fuori perchè getMyShelfie() puo essere null!
            this.currentGame = model.getMyShelfie().getGame(this.currentGameId);
            this.player= this.currentGame.getPlayer(this.player.getId());//così ho a portata di mano la shelves aggiornata!

            //ho gia fatto join!
            choicePart( model, arg);
        }
    }

    //PRIMA ESECUZIONE
    @Override
    public void run() {
        try {
            //creazione del giocatore
            System.out.println("BENVENUTO NUOVO GIOCATORE! per iniziare a giocare devi immettere i tuoi dati");
            System.out.println("username: ");
            Scanner s = new Scanner(System.in);
            this.player = new Player(s.next());

            //fine creazione
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
                    System.out.println("--- WELCOME TO MY SHELFIE! ---");
                    /* Player chooses  POSSIBLE ONLY JOINGAME! */
                    ChoiceMyShelfie pc = ChoiceMyShelfie.JOIN_GAME;
                    Object argument = askPlayerArgumentMyshelfie(pc);

                    Choice c =new Choice(pc,player, argument);

                    System.out.println("in attesa del server... ");

                    setState(State.WAITING_FOR_OUTCOME);
                    setChanged();/*NOTIFICO AL SERVER che del client ha fatto scelta!!*/
                    notifyObservers(c);
                }else {
                    ChoiceMyShelfie pc = askPlayerChoiceMyShelfie();
                    Object argument = askPlayerArgumentMyshelfie(pc);

                    Choice c =new Choice(pc,player, argument);

                    System.out.println("in attesa del server... ");

                    setState(State.WAITING_FOR_OUTCOME);
                    setChanged();/*NOTIFICO AL SERVER che del client ha fatto scelta!!*/
                    notifyObservers(c);
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public ChoiceMyShelfie askPlayerChoiceMyShelfie() {
        Scanner s = new Scanner(System.in);
        System.out.println("is your turn! Make your choice: ");
        System.out.println(
                "Signs: " +
                        Arrays.stream(ChoiceMyShelfie.values())
                                .map(ChoiceMyShelfie::name)
                                .collect(
                                        Collectors.joining(",", "[", "]")));
        while (true) {
            String input = s.next();
            try {
                switch (ChoiceMyShelfie.valueOf(input)){
                    case SHOW_MY_SHELVES:
                        System.out.println("your current shelves is: ");
                        System.out.println("");
                        try {
                            printTilePositionShelves(this.player.getShelves().showShelves());
                        }catch (Exception e){
                            System.err.println("Error occurred displaying your shelves! ");
                            e.printStackTrace();
                        }
                        return askPlayerChoiceMyShelfie();
                    case SHOW_BOARD:
                        System.out.println(" current BOARD: ");
                        System.out.println("");
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
                System.out.println("Inserisci il numero di giocatori della partita: ");
                return  Integer.parseInt(s.next());
            case TERMINATE_TURNS:
                return this.currentGameId;//oggetto da passare come argomento è l'id della partita corrente.
            case DRAW_FROM_BOARD:
                try{
                    //faccio qui tutti i controlli così sono sicuro di passare al server solo i dati giusti tanto la board viene aggiornata a ogni turno!

                    System.out.println("Inserisci il numero di tessere da pescare: ");
                    int counter = Integer.parseInt(s.next());
                    ArrayList<TilePositionBoard> tilesToRemove = new ArrayList<TilePositionBoard>();
                    ArrayList<TilePositionBoard> boardPlacementsCopy = currentGame.getBoard().getPlacements();

                    for (int i = 0; i < counter; i++) {
                        System.out.println("Inserisci la coordinata x della tessera da pescare: ");
                        int x = Integer.parseInt(s.next());
                        System.out.println("Inserisci la coordinata y della tessera da pescare: ");
                        int y = Integer.parseInt(s.next());

                        for(TilePositionBoard item : boardPlacementsCopy){
                            if(item.getX() == x && item.getY() == y){
                                tilesToRemove.add(i, item);
                                break;
                            }
                        }

                        //tilesToRemove.get(0).setTile(new TileObj(TileType.BOOK, TileVariant.VARIANT_ONE));


                    }

                    int ordine[] = new int[tilesToRemove.size()];
                    ArrayList<TilePositionBoard> orderedTilesToRemove = new ArrayList<TilePositionBoard>();

                    while(true) {
                        try {
                            for (int i = 0; i < tilesToRemove.size(); i++) {
                                System.out.println("Inserisci l'ordine della tessera in posizione: x " + tilesToRemove.get(i).getX() + " y "+tilesToRemove.get(i).getY()+" da immettere nella libreria: ");
                                ordine[i] = Integer.parseInt(s.next());
                            }
                            //devo provare a fare rimozione!! solo per essere sicuro che i dati sono corretti; ordinamento effettivo verrà fatto dal controller
                            for (int i = 0; i < tilesToRemove.size(); i++) {
                                orderedTilesToRemove.add(tilesToRemove.get(ordine[i] - 1));
                            }
                            break;//ordinamento andato a buon fine
                        } catch (Exception e2) {
                            System.err.println("Error occurred while ordering tiles! ");
                            e2.printStackTrace();
                        }
                    }
                    //.DEBUG
                    //System.err.println("TESSERA CHE HAI SCELTO DI RIMUOVERE: "+tilesToRemove);
                    //for(int i = 0; i < orderedTilesToRemove.size();i++) {
                    //    System.out.println("tile: " + orderedTilesToRemove.get(i));
                    //}
                    System.out.println("inserisci la colonna della tua libreria dove mettere la tessera: ");
                    int colum_of_shelves = Integer.parseInt(s.next());

                    //check_input(tilesToRemove,colum_of_shelves);
                    return new Draw_from_board_Message(tilesToRemove,colum_of_shelves,this.currentGameId,ordine);
                }catch (Exception e){
                    System.err.println("generic error occurred! ");
                    e.printStackTrace();
                }
            case EXIT:
                return this.currentGameId;//oggetto da passare come argomento è l'id della partita corrente.

        }
        return null;
    }

    private void check_input(ArrayList<TilePositionBoard> tilesToRemove, int columOfShelves) throws Exception{
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
                System.err.println("errore nell'inserimento dei dati!\n"+e.getMessage()+ "`\n riprova! \n");

            }catch (PositionEmptyException e) {
                //non c'è bisogno di rimettere le tessere nella board!
                e.printStackTrace();
                System.err.println("errore nell'inserimento dei dati!\n"+e.getMessage()+ "`\n riprova! \n");
            }
    }

    public void joiningPart(TurnView model, Choice arg) {
        //USERNAME DEVE ESSERE UNIVOCO
        if (this.player != null) {
            if(arg.getPlayer().getUsername().equals( this.player.getUsername())){
                switch (model.getPlayerChoice().getStato()) {
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
                                        switch (model.getMyShelfie().getGames().get(i).getStato()) {//le partite saranno o in attesa o in corso!
                                            case IN_CORSO://non dovrebbe mai arrivarci!
                                                System.out.println();
                                                System.out.println("ti sei unito ad una partita e la partita e' in corso!");
                                                System.err.println("partita a cui ti sei unito in corso: " + model.getMyShelfie().getGames().get(i).toString());
                                                System.out.println();
                                                this.currentGameId = model.getMyShelfie().getGames().get(i).getCurrentGameId();
                                                //this.current_game = model.getMyShelfie().getGames().get(i);
                                                break;
                                            case IN_ATTESA://siccome non esiste una partita di un solo giocatore entrerò sempre qui!
                                                System.out.println("ti sei unito ad una partita e la partita e' in attesa di altri giocatori!");
                                                System.err.println("partita a cui ti sei unito in corso: " + model.getMyShelfie().getGames().get(i).toString());
                                                System.out.println();
                                                this.currentGameId = model.getMyShelfie().getGames().get(i).getCurrentGameId();
                                                //this.current_game = model.getMyShelfie().getGames().get(i);
                                                break;
                                        }
                                    }
                                }
                                //stampo i dati della partita a cui mi sono unito.
                                break;
                            default:
                                System.err.println("Devi prima unirti al gioco!");
                        }
                    }
                    default -> System.err.println("Errore stato! Ignoring event from " + model.toString() + ": " + arg.toString());
                }

                System.out.println("Il server ha risposto!");
                //this.setState(State.WAITING_FOR_PLAYER);
            }
        }

    }

    public void choicePart(TurnView model, Choice arg) {
        try {
            switch (model.getPlayerChoice().getStato()) {
                case CPU_CHOICE -> {
                    switch (model.getPlayerChoice().getChoice()) {


                        case TERMINATE_TURNS:
                            System.out.println(model.getMyShelfie().getGame(this.currentGameId).precCurrentPlayer().getUsername()+" ha terminato il turno! ");
                            System.out.println("Ora tocca a: " + model.getMyShelfie().getGame(this.currentGameId).getCurrentPlayer().getUsername());
                        break;

                        case JOIN_GAME:
                            System.out.println("Il player: "+model.getMyShelfie().getGame(this.currentGameId).getPlayers().get(model.getMyShelfie().getGame(this.currentGameId).getPlayers().size()-1).getUsername()+" si e' unito alla partita!");
                        break;
                        case DRAW_FROM_BOARD:
                            System.out.println("Il player: "+model.getMyShelfie().getGame(this.currentGameId).getCurrentPlayer().getUsername()+" HA PESCATO DALLA PLANCIA!");
                        break;
                        case EXIT:
                            System.out.println("Il player: "+model.getMyShelfie().getGame(this.currentGameId).getCurrentPlayer().getUsername()+" HA FORZATO LA CHIUSURA DEL GIOCO ALLA FINE DEL GIRO!");
                        break;
                        default:
                            System.err.println("Not implemented yet");
                    }
                }
                default -> System.err.println("Errore stato! Ignoring event from " + model.toString() + ": " + arg.toString());
            }
        } catch (Exception e) {
            System.out.println("Gioco che ha generato errore: " + model.getMyShelfie().getGame(this.currentGameId).toString());
            e.printStackTrace();
        }

        //se è il mio turno faccio qualcosa!!
        if (model.getMyShelfie().getGame(this.currentGameId).getCurrentPlayer() != null) {
            if (model.getMyShelfie().getGame(this.currentGameId).getCurrentPlayer().getId() == this.player.getId()) {
                System.out.println("Il server ha risposto!");
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
                ",\n current_game=" + currentGame +
                ",\n current_game_id=" + currentGameId +
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
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public void printTilePositionShelves(TilePositionShelves[][] shelves) {

        // Stampa la matrice 2D
        for (int y = 0; y < shelves.length; y++) {
            for (int x = 0; x < shelves[y].length; x++) {
                TilePositionShelves tile = shelves[y][x];
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

}

