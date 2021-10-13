package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeartPointsTest {
    HeartPoints heartPoints = new HeartPoints(0);

    @BeforeEach
    public void setup() {
        assertEquals(0, heartPoints.getHp());
    }

    @Test
    public void testConstructor() {
        assertEquals(0,heartPoints.getHp());
    }

    @Test
    public void testAddHP() {
        setup();
        heartPoints.addHP(5);
        assertEquals(5, heartPoints.getHp());
    }

    @Test
    public void testRemoveHPMoreThanStart() {
        setup();
        heartPoints.addHP(5);
        assertEquals(5, heartPoints.getHp());
        assertFalse(heartPoints.removeHP(6));
        assertEquals(0, heartPoints.getHp());
    }

    @Test
    public void testRemoveHPLessThanStart() {
        setup();
        heartPoints.addHP(5);
        assertEquals(5, heartPoints.getHp());
        assertTrue(heartPoints.removeHP(3));
        assertEquals(2, heartPoints.getHp());
    }
}
