package org.project.ingsw2023PaganiniTommasiRussoPorfiri.model;

import org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils.PositionAlreadyOccupiedException;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.utils.PositionEmptyException;

import java.io.Serializable;
import java.util.Objects;

public class TilePositionBoard implements Serializable {
    private int x;
    private int y;
    private TileObj tileInSlot;
    private boolean occupied;

    public TilePositionBoard(int abscissa, int ordinate){
        this.x= abscissa;
        this.y= ordinate;
        this.tileInSlot= null;
        this.occupied= false;
    }

    public TilePositionBoard(int abscissa, int ordinate, TileObj tile){
        this.x= abscissa;
        this.y= ordinate;
        this.tileInSlot= new TileObj(tile);
        this.occupied= true;
    }

    public TilePositionBoard(TilePositionBoard tp){
        this.x= tp.getX();
        this.y= tp.getY();
        try {
            this.tileInSlot = new TileObj(tp.getTile());
        }catch (Exception e){
            this.tileInSlot = null;
        }
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
        if(tileInSlot != null){
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

    public TileObj removeTile() throws PositionEmptyException {
        if(this.tileInSlot != null && this.occupied){
            TileObj tempTile = new TileObj(this.tileInSlot);
            this.tileInSlot= null;
            this.occupied=false;
            return tempTile;
        }
        else throw new PositionEmptyException();
    }

    @Override
    public String toString() {
        return "|" +
                "[" + x +
                "," + y +
                "]= " + tileInSlot +
                ",o=" + occupied+"|";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TilePositionBoard that = (TilePositionBoard) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
