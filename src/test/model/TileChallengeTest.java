package model;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class TileChallengeTest {
    TileChallenge tc = new TileChallenge();
    Player p = new Player("billy");
    MarblesBag mb = new MarblesBag();

    @Test
    public void testChooseRandomValue() {
        boolean b = false;
        int k = tc.chooseRandomValue();
        if (k == 1 || k == 2 || k == 3) {
            b = true;
        } else if (k == 4) {
            b = true;
        }
        assertTrue(b);
    }

    @Test
    public void testAssignValue() {
        int tc1 = 0;
        boolean b1 = false;
        int tc2 = 0;
        boolean b2 = false;
        tc.assignValue();
        if (tc1 == tc.getTileOne()) {
            b1 = true;
        } else if ((tc1 == tc.getTileTwo())) {
            b1 = true;
        } else if ((tc1 == tc.getTileThree())) {
            b1 = true;
        } else if ((tc1 == tc.getTileFour())) {
            b1 = true;
        }
        if (tc2 == tc.getTileOne()) {
            b2 = true;
        } else if ((tc2 == tc.getTileTwo())) {
            b2 = true;
        } else if ((tc2 == tc.getTileThree())) {
            b2 = true;
        } else if ((tc2 == tc.getTileFour())) {
            b2 = true;
        }
        assertTrue(b1);
        assertTrue(b2);
    }


    @Test
    public void testRollMarblesNoMarbles() {
        tc.assignValue();
        String hint1 = tc.rollMarbles(p);
        boolean c1 = false;
        assertFalse(p.hasItem(mb));
        if (Objects.equals(hint1, "\n juan is right ")) {
            assertEquals(0,tc.getTileOne());
            c1 = true;
        } else if (Objects.equals(hint1, "\n unos,... ")) {
            assertEquals(0,tc.getTileTwo());
            c1 = true;
        } else if (Objects.equals(hint1, "\n a triangle has ... sides ")) {
            assertEquals(0,tc.getTileThree());
            c1 = true;
        } else if (Objects.equals(hint1, "\n don't be such a square ")) {
            assertEquals(0,tc.getTileFour());
            c1 = true;
        }
        assertTrue(c1);
    }

    @Test
    public void testRollMarblesHasMarbles() {
        tc.assignValue();
        p.addItem(mb);
        assertTrue(p.hasItem(mb));
        tc.rollMarbles(p);
        int b = 0;
        String hint1 = tc.getHint();
        boolean c1 = false;
        if (Objects.equals(hint1, "\n juan is right " + "\n unos,... ")) {
            c1 = true;
            assertEquals(0,tc.getTileOne());
            assertEquals(0,tc.getTileTwo());
        } else if (Objects.equals(hint1, "\n juan is right " + "\n a triangle has ... sides ")) {
            c1 = true;
            assertEquals(0,tc.getTileOne());
            assertEquals(0,tc.getTileThree());
        } else if (Objects.equals(hint1, "\n juan is right " + "\n don't be such a square ")) {
            c1 = true;
            assertEquals(0,tc.getTileOne());
            assertEquals(0,tc.getTileFour());
        } else if (Objects.equals(hint1, "\n unos,... " + "\n a triangle has ... sides ")) {
            c1 = true;
            assertEquals(0,tc.getTileTwo());
            assertEquals(0,tc.getTileThree());
        } else if (Objects.equals(hint1, "\n unos,... " + "\n don't be such a square ")) {
            c1 = true;
            assertEquals(0,tc.getTileTwo());
            assertEquals(0,tc.getTileFour());
        } else if (Objects.equals(hint1, "\n a triangle has ... sides " + "\n don't be such a square ")) {
            c1 = true;
            assertEquals(0,tc.getTileThree());
            assertEquals(0,tc.getTileFour());
        }
        assertTrue(c1);
    }

    @Test
    public void getHintAfterEvent() {
        tc.assignValue();
        tc.rollMarbles(p);
        String hint1 = tc.getHint();
        boolean c1 = false;
        assertFalse(p.hasItem(mb));
        if (Objects.equals(hint1, "\n juan is right ")) {
            c1 = true;
        } else if (Objects.equals(hint1, "\n unos,... ")) {
            c1 = true;
        } else if (Objects.equals(hint1, "\n a triangle has ... sides ")) {
            c1 = true;
        } else if (Objects.equals(hint1, "\n don't be such a square ")) {
            c1 = true;
        }
        assertTrue(c1);
    }

    @Test
    public void getHintBeforeEvent() {
        assertEquals("", tc.hint);
    }

    @Test
    public void testGetTileOne() {
        assertEquals(1, tc.getTileOne());
    }

    @Test
    public void testGetTileTwo() {
        assertEquals(2, tc.getTileTwo());
    }
    @Test
    public void testGetTileThree() {
        assertEquals(3, tc.getTileThree());
    }

    @Test
    public void testGetTileFour() {
        assertEquals(4, tc.getTileFour());
    }



}
