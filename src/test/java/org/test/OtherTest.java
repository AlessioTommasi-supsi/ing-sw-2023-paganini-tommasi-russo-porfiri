package org.test;

import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.project.ingsw2023PaganiniTommasiRussoPorfiri.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class OtherTest {

    @Test
    public void otherTests() {
        TileType type = TileType.CAT;
        assertNotEquals(type.getName(), "");
        TileVariant variant = TileVariant.VARIANT_ONE;
        assertEquals(variant.getNumber(), 1);
        Player player = new Player("player1");
        Ranking rank = new Ranking(player, 8);
        assertNotEquals(rank.toString(), "");
        Turn model = new Turn();
        Choice choice = new Choice(ChoiceMyShelfie.SHOW_COMMON_CARDS, player, "");
        model.setPlayerChoice(choice);
        TurnView turnView = new TurnView(model);
        Choice choice1 = turnView.getPlayerChoice();
        assertEquals(choice1, turnView.getPlayerChoice());
        assertNotEquals(turnView.toString(), "");
    }
}
