package org.example.Model;

import java.util.*;

/**
 * 
 */
public class CommonCard {

    private int points;
    private TilePositionShelves correctPosition[];
    private CommonObjective commonCardGoal;
    private int index;
    /**
     * Default constructor
     */
    public CommonCard(int points, int correctPosition[], CommonObjective commonCardGoal, int index) {
        this.points = points;
        this.index = index;
    }

    public CommonCard drawCommon(int points, int indexAlreadyDrew) {
        Random rand = new Random();
        int index = rand.nextInt(12);
        while (index == indexAlreadyDrew) {
            index = rand.nextInt(12);
        }
        CommonCard commonCard = new CommonCard(points, null, null, index);
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