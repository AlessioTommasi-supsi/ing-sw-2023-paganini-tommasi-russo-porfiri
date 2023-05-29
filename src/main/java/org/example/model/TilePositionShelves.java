package org.example.model;

import org.example.util.PositionAlreadyOccupiedException;

import java.io.Serializable;

public class TilePositionShelves implements Serializable {
    private int x;
    private int y;
    private TileObj tileInSlot;
    private boolean occupied;

    public TilePositionShelves(int abscissa, int ordinate){
        this.x= abscissa;
        this.y= ordinate;
        this.tileInSlot= null;
        this.occupied= false;
    }

    public TilePositionShelves(int abscissa, int ordinate, TileObj tile){
        this.x= abscissa;
        this.y= ordinate;
        this.tileInSlot= new TileObj(tile);
        this.occupied= true;
    }

    public TilePositionShelves(TilePositionShelves tp){
        this.x= tp.getX();
        this.y= tp.getY();
        this.tileInSlot= new TileObj(tp.getTile());
        this.occupied= tp.isOccupied();
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public boolean isOccupied(){
        return this.occupied;
    }

    public TileObj getTile() {
        if(this.tileInSlot!=null){
            TileObj tempTile = new TileObj(this.tileInSlot);
            return tempTile;
        }
        else return null;
    }

    public void setTile(TileObj tile) throws PositionAlreadyOccupiedException {
        if(!this.occupied){
            this.tileInSlot= tile;
            this.occupied= true;
        }
        else throw new PositionAlreadyOccupiedException();
    }

    @Override
    public String toString() {
        return
                "" + tileInSlot
                ;
    }
}
