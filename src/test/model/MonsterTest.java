package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MonsterTest {
    Monster m = new Monster();

    public void setup() {
        assertEquals(20, m.getHP());
    }

    @Test
    public void testConstructor() {
        setup();
        assertEquals("Hytos the troll", m.getName());
        assertEquals(20,m.getInitialHP());
        boolean b = false;
        int l = m.attackChooser();
        if (l == 1 || l == 2 || l == 3)  {
            b = true;
        }
        assertTrue(b);
    }

    @Test
    public void testLoseHPMoreThanStart() {
        setup();
        assertFalse(m.loseHP(30));
        assertEquals(0, m.getHP());
    }

    @Test
    public void testLoseHPLessThanStart() {
        setup();
        assertTrue(m.loseHP(10));
        assertEquals(10, m.getHP());
    }

    @Test
    public void testResetHP() {
        setup();
        assertTrue(m.loseHP(10));
        m.resetHp();
        assertEquals(20, m.getHP());
    }
}
