package org.example.Model;

import java.io.Serializable;
import java.util.*;

/**
 * 
 */
public abstract class CommonCard  implements Serializable {

    boolean objectiveAlreadyCompleted;

    public CommonCard drawCommon(int points, List<CommonCard> commonCardList) {
        Random rand = new Random();
        int index = rand.nextInt(commonCardList.size());
        CommonCard commonCard = null;
        if((index == 0)
            || (index == 4)
            || (index == 6)
            || (index == 1)
            || (index == 9)) {
            commonCard = new CommonCardForm(0, index);
        } else if ((index == 5) || (index == 7)) {
            commonCard = new CommonCardRowColumn(0, index);
        } else if ((index == 3) || (index == 8)) {
            commonCard = new CommonCardRowColumnMinMax(0, index);
        } else if ((index == 11)
                || (index == 10)
                || (index == 2)) {
            commonCard = new CommonCardPosition(0, index);
        }
        commonCardList.remove(index);
        return commonCard;
    }



}