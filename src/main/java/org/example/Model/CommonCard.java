package org.example.Model;

import java.io.Serializable;
import java.util.*;


public abstract class CommonCard  implements Serializable {

    private int index ;

    private String Description = "non assegnato";

    public int getIndex() {
        return index;
    }


    public CommonCard(int extIndex){
        this.index = extIndex;
    }


    public CommonCard(int extIndex, String description){
        this.index = extIndex;
        this.Description = description;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public abstract boolean executeAlgorithm(Player player);
}