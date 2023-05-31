package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;

public class CommonCardAllDifferentTypes extends CommonCard implements Serializable {

    String form;
    public CommonCardAllDifferentTypes(int index) {
        super(index);

    }

    public boolean executeAlgorithm(Player player) {
        int counter = 0;
        ArrayList<TileType> types = new ArrayList<>();
        switch(form) {

        }
        return false;
    }


}
