package org.example.Model;

import java.io.Serializable;
import java.util.*;


public abstract class CommonCard  implements Serializable {

    private int index;

    public int getIndex() {
        return index;
    }


    public CommonCard(int extIndex){
        this.index = extIndex;
    }


    public abstract boolean executeAlgorithm(Player player);
}