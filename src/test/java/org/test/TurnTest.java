package org.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.project.model.*;

public class TurnTest {

    private Turn turn;

    @BeforeEach
    public void setUp() {
        turn = new Turn();
    }

    @Test
    public void testSetAndGetMyShelfie() {
        MyShelfie myShelfie = new MyShelfie();
        turn.setMyShelfie(myShelfie);
        Assertions.assertEquals(myShelfie, turn.getMyShelfie());
    }

    @Test
    public void testSetAndGetPlayerChoice() {
        Choice choice = new Choice(ChoiceMyShelfie.JOIN_GAME, new Player("John"), 2);
        turn.setPlayerChoice(choice);
        Assertions.assertEquals(choice, turn.getPlayerChoice());
    }



    @Test
    public void testToString() {
        MyShelfie myShelfie = new MyShelfie();
        Choice choice = new Choice(ChoiceMyShelfie.JOIN_GAME, new Player("John"), 2);
        turn.setMyShelfie(myShelfie);
        turn.setPlayerChoice(choice);
        turn.error = "Errore di esempio";

        String expectedString = "Turn{'\n'" +
                "'\n'playerChoice=" + choice.toString() +
                "'\n', errore='Errore di esempio'" +
                "'\n', myShelfie=" + myShelfie.toString() +
                '}';

        Assertions.assertEquals(expectedString, turn.toString());
    }
}
