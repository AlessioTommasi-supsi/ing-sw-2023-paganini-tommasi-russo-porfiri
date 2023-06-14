package org.project.model;

import com.google.gson.Gson;

import java.io.Reader;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * I giocatori entrano sequenzialmente all'interno della partita. La posizione del giocatore in partita è data in base all'ordine di entrata, quindi la posizione è l'indice dell'array.
 */
public abstract class Game implements Serializable {

    private Player currentPlayer;
    private int currentGameId;
    private Board board;
    private ArrayList<Player> players;//ordinato in base all ordine nel quale i giocatori si sono uniti alla partita e quindi anche in ordine di chi tocca a giocare!
    private int playerNumber;//numeri di giocatori che ci sono in questa partita!
    private Player dealer;
    private GameStatus state = GameStatus.IN_WAIT;
    private ArrayList<PersonalCard> personalCardDeck = new ArrayList<>();
    private int pointInitialization1 = 8;
    private int pointInitialization2 = 8;
    private int ranking[]=null;
    private ArrayList<Ranking> rank;
    private int[] commonCardScores;
    private CommonCard common1;
    private CommonCard common2;

    //quando è a true devo completare il turno e poi finire la partita!
    private boolean fullLibrary = false;


    public Game(int playerNumber, Player mazziere) {
        GsonParse(this.personalCardDeck);
        this.playerNumber = playerNumber;
        this.dealer =mazziere;
        players= new ArrayList<Player>();
        rank= new ArrayList<Ranking>();
        this.currentGameId = Globals.incrementGameId();
        mazziere.setPC(drawPersonal());
        //.DEBUG
        //System.out.println(mazziere.toString());
        players.add(mazziere);
        this.board = new Board();
        buildBoard();

        drawCommon();

        //currentPlayer viene detto solo quando la partita passa da in attesa a in corso!

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


    public CommonCard getCommon2() {
        return common2;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public void setCurrentGameId(int currentGameId) {
        this.currentGameId = currentGameId;
    }

    public void setCommon1(CommonCard extP){
        common1 = extP;
    }

    public void setCommon2(CommonCard extP){
        common2 = extP;
    }

    public GameStatus getState() {
        return state;
    }

    public ArrayList<Ranking> getRanking() throws Exception{
        if(this.state != GameStatus.OVER){
            throw new Exception("You can't take the scores because the game isn't over yet!");
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

    public Player getPlayer(int idPlayer) {
        for (int i = 0; i < players.size(); i++) {
            if (idPlayer == players.get(i).getId()){
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

    public PersonalCard drawPersonal() {
        Random rand = new Random();
        int num = rand.nextInt(this.personalCardDeck.size());
        PersonalCard personalCard = this.personalCardDeck.get(num);
        this.personalCardDeck.remove(num);
        return personalCard;
    }

    // For testing purposes
    public PersonalCard drawPersonal(int i) {
        PersonalCard personalCard = this.personalCardDeck.get(i);
        this.personalCardDeck.remove(i);
        return personalCard;
    }

    public void addPlayer(Player p)throws Exception {
        if (this.state != GameStatus.IN_WAIT){
            throw new Exception("Players cannot be added unless the game is on hold!");
        }
        p.setPC(drawPersonal());
        //.DEBUG
        //System.out.println(p.toString());
        players.add(p);

        if (this.playerNumber == this.players.size()) {
            //System.err.println(this.toString() +"this.players.size()= "+this.players.size());
            this.state = GameStatus.IN_PROGRESS;
            this.currentPlayer = this.players.get(0);//il primo giocatore è quello che inizia!
        }

    }


    public void startPartita(){
        this.state = GameStatus.IN_PROGRESS;
    }

    public void fullLibrary(){
        if (this.fullLibrary ==false){ //aggiungo punti solo al primo player che mi completa la partita!
            this.fullLibrary = true;
            this.currentPlayer.addEndOfGamePoint();
        }
    }


    public void end() throws Exception {
        if (this.fullLibrary == true && (this.players.indexOf(this.currentPlayer) == 0/*ho terminato giro*/)) {
            this.state = GameStatus.OVER;

            //calcolo i punti di ogni giocatore e ne faccio il ranking
            //indice di ranking e Indice dei giocatori quando si sono uniti alla partita.

            int point[];

            //funzionalità ranking!
            point = new int[this.playerNumber];

            for (int i = 0; i < players.size(); i++) {
                players.get(i).calcOverallScore();
                point[i] = players.get(i).getScore();
            }

            this.ranking = new int[this.playerNumber];

            for (int i = 0; i < players.size(); i++) {
                rank.add(new Ranking(players.get(i), point[i]));
            }

            //ordino rank in base ai punti dal piu alto al piu basso
            Collections.sort(rank, new Comparator<Ranking>() {
                @Override
                public int compare(Ranking o1, Ranking o2) {
                    return o2.getPoints() - o1.getPoints();
                }
            });

            int index = 0;
            int max =point[0];
            //assegno il ranking
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
        commonCards.add(new CommonCard3Types(5));
        commonCards.add(new CommonCardShape(6));
        commonCards.add(new CommonCard3Types(7));
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
                ", state=" + state +
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