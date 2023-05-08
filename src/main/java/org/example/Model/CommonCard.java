package org.example.Model;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public class CommonCard  implements Serializable {

    private int points;
    private TilePositionShelves correctPosition[];
    private int index;
    /**
     * Default constructor
     */
    public CommonCard(int points, int correctPosition[], int index) {
        this.points = points;
        this.index = index;
    }

    public CommonCard drawCommon(int points, int indexAlreadyDrew) {
        Random rand = new Random();
        int index = rand.nextInt(12);
        while (index == indexAlreadyDrew) {
            index = rand.nextInt(12);
        }
        CommonCard commonCard = new CommonCard(points, null, index);
        indexAlreadyDrew = index;
        return commonCard;
    }

    /**
     * 
     */

    /**
     * 
     */
    public void CommonCard() {


        // TODO implement here
    }

}