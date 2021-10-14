package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TileChallengeTest {
    TileChallenge tc = new TileChallenge();
    Player p = new Player("billy");
    MarblesBag mb = new MarblesBag();

    @Test
    public void testChooseRandomValue(){
        boolean b = false;
        int k = tc.chooseRandomValue();
        if (k == 1 || k == 2 || k == 3)  {
            b = true;
        } else if (k == 4) {
            b = true;
        }
        assertTrue(b);
    }

    @Test
    public void testAssignValue() {
    }

}
