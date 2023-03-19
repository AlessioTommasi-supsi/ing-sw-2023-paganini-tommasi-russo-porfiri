package org.example.Model;

import java.util.*;

/**
 * 
 */
public class Player {


    public Player() {
    }

    public Player(Player p) {
    }


    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private int playerPosition;

    /**
     * 
     */
    private boolean yourTurn;

    /**
     * @param id
     */
    public void Player(int id) {
        // TODO implement here
    }

    /**
     * @param pt
     */
    private void putTile(Set<TilePosition> pt) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getPunti() {
        // TODO implement here
        return 0;
    }

    /**
     * @param int pos 
     * @return
     */
    public void setPlayerPosition(int pos) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Shelves getShelves() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void addPunti() {
        // TODO implement here
    }

    /**
     * @param pos 
     * @return
     */
    private Set<TileObj> getFromBoard(Set<TilePosition> pos) {
        // TODO implement here
        return null;
    }

    /**
     * invocabile solo da partita
     * @return
     */
    public int calculatePoints() {
        // TODO implement here
        return 0;
    }

}