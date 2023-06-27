package org.test;

import org.junit.jupiter.api.Assertions;
import org.project.model.*;
import org.junit.Test;
public class ChoiceTest {

    @Test
    public void testToString() {
        Player player = new Player("John");
        ChoiceMyShelfie choice = ChoiceMyShelfie.JOIN_GAME;
        Integer argument = 2;
        Choice choiceObj = new Choice(choice, player, argument);

        String expectedString = "Choice{" +
                "choice=" + choice.toString() +
                ", state=null" +
                ", argument=" + argument.toString() +
                ", player=" + player.toString() +
                '}';

        Assertions.assertEquals(expectedString, choiceObj.toString());
    }
}

