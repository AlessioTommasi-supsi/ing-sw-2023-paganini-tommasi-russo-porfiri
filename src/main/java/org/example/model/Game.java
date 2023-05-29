package org.example.model;

import com.google.gson.Gson;

import java.io.Reader;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * I giocatori entrano sequenzialmente all'interno della partita. La posizione del giocatore in partita è data in base all'ordine di entrata, quindi la posizione è l'indice dell'array
 *
 * All'inizio della partita creo istanza della plancia e i posizionamenti metto un'eccezione per le posizioni sempre irregolari, un'altra eccezione per le posizioni non giocabili perché non ci sono abbastanza giocatori. Al livello filosofico mi serve capire cosa devo comunicare e in che caso mi ritrovo
 */
public abstract class Game implements Serializable {

    private Player currentPlayer;
    private int currentGameId;
    private Board board;
    private ArrayList<Player> players;//ordinato in base all ordine nel quale i giocaori si sono uniti alla patrita e quindi anche in ordine di chi tocca a giocare!
    private int playerNumber;//numeri di giocatori che ci sono in questa partita!
    private Player dealer;
    private StatoPartita stato=StatoPartita.IN_ATTESA;
    private ArrayList<PersonalCard> personalCardDeck = new ArrayList<>();
    private int pointInitialization1 = 8;
    private int pointInitialization2 = 8;
    private int ranking[]=null;
    private ArrayList<Ranking> rank;
    private int[] commonCardScores;
    private CommonCard common1;
    private CommonCard common2;

    //quando e' a true devo completare il turno e poi finire la partita!
    private boolean full_library = false;


    public Game(int playerNumber, Player mazziere) {
        GsonParse(this.personalCardDeck);
        this.playerNumber = playerNumber;
        this.dealer =mazziere;
        players= new ArrayList<Player>();
        rank= new ArrayList<Ranking>();
        this.currentGameId = Globals.incrementGameId();
        mazziere.setPC(drawPersonal());
        //.DEBUG
        System.out.println(mazziere.toString());
        players.add(mazziere);
        this.board = new Board();
        buildBoard();

        drawCommon();

        //currentplayer viene detto solo quando la partita passa da in attesa ad in corso!

    }

    public Board getInstanceBoard() {
        return board;
    }

    public ArrayList<Player> getPlayers() {
        return  players;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public Player getDealer() {
        return dealer;
    }


    public int[] getCommonCardScores() {
        return commonCardScores;
    }

    public void setCommonCardScores(int[] commonCardScores) {
        this.commonCardScores = commonCardScores;
    }

    public CommonCard getCommon1() {
        return common1;
    }

    public void setCommon1(CommonCard common1) {
        this.common1 = common1;
    }

    public CommonCard getCommon2() {
        return common2;
    }

    public void setCommon2(CommonCard common2) {
        this.common2 = common2;
    }

    public StatoPartita getStato() {
        return stato;
    }

    public ArrayList<Ranking> getRanking() throws Exception{
        if(this.stato != StatoPartita.FINITA){
            throw new Exception("non puoi prendere i punteggi perché la partita non e'ancora finita!");
        }
        return rank;
    }

    public ArrayList<Ranking> getRank() {
        return rank;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getCurrentGameId() {
        return currentGameId;
    }

    public Board getBoard() {
        return board;
    }

    public int getPointInitialization1() {
        return pointInitialization1;
    }

    public int getPointInitialization2() {
        return pointInitialization2;
    }

    public Player getPlayer(int id_player) {
        for (int i = 0; i < players.size(); i++) {
            if (id_player == players.get(i).getId()){
                return players.get(i);
            }
        }
        return null;
    }

    private void GsonParse(ArrayList<PersonalCard> personalCardParsers) {
        try {
            // create Gson instance

            try {
                Gson gson = new Gson();

                // create a reader
                Reader reader = Files.newBufferedReader(Paths.get("PersonalCard.json"));

                // convert a JSON string to a User object
                PersonalCard[] user = gson.fromJson(reader,PersonalCard[].class);

                System.out.println(user[0].toString());
                personalCardParsers.add(user[0]);

                personalCardParsers.add(user[1]);
                personalCardParsers.add(user[2]);
                personalCardParsers.add(user[3]);
                personalCardParsers.add(user[4]);
                personalCardParsers.add(user[5]);
                personalCardParsers.add(user[6]);
                personalCardParsers.add(user[7]);
                personalCardParsers.add(user[8]);
                personalCardParsers.add(user[9]);
                personalCardParsers.add(user[10]);
                personalCardParsers.add(user[11]);

                // close reader
                reader.close();

            }catch (Exception e){
                e.printStackTrace();
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private PersonalCard drawPersonal() {
        Random rand = new Random();
        int num = rand.nextInt(this.personalCardDeck.size());
        PersonalCard personalCard = this.personalCardDeck.get(num);
        this.personalCardDeck.remove(num);
        return personalCard;
    }



    public void addPlayer(Player p)throws Exception {
        if (this.stato != StatoPartita.IN_ATTESA){
            throw new Exception("non si possono aggiungere giocatori se la partita non è in attesa!");
        }
        p.setPC(drawPersonal());
        //.DEBUG
        System.out.println(p.toString());
        players.add(p);

        if (this.playerNumber == this.players.size()) {
            //System.err.println(this.toString() +"this.players.size()= "+this.players.size());
            this.stato = StatoPartita.IN_CORSO;
            this.currentPlayer = this.players.get(0);//il primo giocatore è quello che inizia!
        }

    }


    public void start_partita(){
        this.stato = StatoPartita.IN_CORSO;
    }

    public void full_library(){
        if (this.full_library==false){ //aggiungo punti solo al primo player che mi completa la partita!
            this.full_library = true;
            this.currentPlayer.add_end_of_game_point();
        }
    }


    public void end() throws Exception {
        if (this.full_library == true && (this.players.indexOf(this.currentPlayer) == 0/*ho terminato giro*/)) {
            this.stato = StatoPartita.FINITA;

            //calcolo i punti di ogni giocatore e ne faccio il ranking
            //indice di ranking e Indice dei giocatori quando si sono uniti alla partita.

            int point[];

            //funzionalita ranking!
            point = new int[this.playerNumber];

            for (int i = 0; i < players.size(); i++) {
                players.get(i).calcOverallScore();
                point[i] = players.get(i).getScore();
            }

            this.ranking = new int[this.playerNumber];

            for (int i = 0; i < players.size(); i++) {
                //point[i] = players.get(i).getShelves().getScore();
                rank.add(new Ranking(players.get(i), point[i]));
            }

            int index = 0;
            int max =point[0];

            for (int j = 0; j < this.playerNumber; j++) {
                for (int i = 1; i < players.size() ; i++) {
                    if (point[i] > max) {
                        max = point[i];
                        index = i;
                    }
                }
                point[index] = -1;
                this.ranking[j] = index;
            }
            //fine funzionalità ranking
        }
    }

    public void drawCommon() {
        ArrayList<CommonCard> commonCards = new ArrayList<CommonCard>();
        commonCards.add(new CommonCardShape(0));
        commonCards.add(new CommonCardDiagonal(1));
        commonCards.add(new CommonCardAngles(2));
        commonCards.add(new CommonCard3Types(3));
        commonCards.add(new CommonCardShape(4));
        commonCards.add(new CommonCardAllDifferentTypes(5));
        commonCards.add(new CommonCardShape(6));
        commonCards.add(new CommonCardAllDifferentTypes(7));
        commonCards.add(new CommonCard3Types(8));
        commonCards.add(new CommonCardX(9));
        commonCards.add(new CommonCard8Tiles(10));
        commonCards.add(new CommonCardStair(11));
        Random rand = new Random();
        int index1 = rand.nextInt(12);
        this.common1 = commonCards.get(index1);
        int index2 = rand.nextInt(12);
        while(index2==index1) {
            index2 = rand.nextInt(12);
        }
        common2 = commonCards.get(index2);
    }







    @Override
    public String toString() {
        return "Game{" +
                "board=" + board +
                ", players=" + players.toString() +
                ", playerNumber=" + playerNumber +
                ", dealer=" + dealer +
                ", stato=" + stato +
                ", ranking=" + Arrays.toString(ranking) +
                ", rank=" + rank +
                '}';
    }


    public void setBoard(ArrayList<TilePositionBoard> extP){
        this.board.setPlacements(extP);
        this.board.addTiles();
    }


    public abstract void buildBoard();  //Factory Method

    public abstract void defineCommonCardScores();


    

    //Metodo che aggiorna i punti del player corrente
    //se il player ha completato la commonCard1 aggiungi i punti altrimenti no
    //viene eseguito a ogni volta che tocca in giocatore!
    /*Abbiamo deciso stare qui perché:
    * perché i punteggi dati dalle common card sono in relazione stretta con il gioco, siccome ogni currentPlayet a ogni turno
    * aggiorna gli obbiettivi comuni completati.
    *
    * ATTENZIONE: .Alessio
    *   -ricordati da richiamarlo a ogni turno prima di terminaTURN
    *   -totale punteggio è in Player.score -> ranking aggiornato automaticamente ingame con la funzione Game::end()
    *
    * */
    public void updatePointsCommon() {
        int pointsToSub = 0;  //punti da sottrarre a ogni completamento
        if ((this.playerNumber == 4) || (this.playerNumber == 3)) {
            pointsToSub = 2;
        } else if (this.playerNumber == 2) {
            pointsToSub = 4;
        }
        //se il player non ha ancora completato la commonCard
        if (!currentPlayer.isCommonCard1Completed()) {
            //se il player completa l'obiettivo aggiungi i punti altrimenti no
            if (this.common1.executeAlgorithm(currentPlayer)) {
                currentPlayer.setScore(currentPlayer.getScore() + this.pointInitialization1);   //aggiorna i punti
                this.pointInitialization1 = this.pointInitialization1 - pointsToSub; // sottrai i punti
                currentPlayer.setCommonCard1Completed(true);
            }
        }
        if (!currentPlayer.isCommonCard2Completed()) {
            if (common2.executeAlgorithm(currentPlayer)) {
                currentPlayer.setScore(currentPlayer.getScore() + this.pointInitialization2);
                this.pointInitialization2 = this.pointInitialization2 - pointsToSub;
                currentPlayer.setCommonCard2Completed(true);
            }
        }
    }

    public void nextCurrentPlayer() {
        this.currentPlayer = this.players.get((this.players.indexOf(this.currentPlayer) + 1) % this.players.size());
    }

    public Player precCurrentPlayer() {
        return this.players.indexOf(this.currentPlayer) - 1 % this.players.size() > 0 ? this.players.get((this.players.indexOf(this.currentPlayer) - 1) % this.players.size()) : this.players.get(this.players.size() - 1);
    }

    /*NON FUNZIONANTE
    public ArrayList setRanking() {
        for(Player p : players){
            p.calcOverallScore();
        }

        Collections.sort(players, new Comparator<Player>()) {
            @Override
            public int compare(Player p1, Player p2) {
                return p2.getScore() - p1.getScore();
            }
        }

        this.rank.addAll(players);
    }
     */
}