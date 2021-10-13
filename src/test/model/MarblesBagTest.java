package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MarblesBagTest {
    MarblesBag mp = new MarblesBag();

    @Test
    public void testConstructor () {
        assertEquals("Marbles Bag", mp.getName());
        assertEquals(1, mp.getCost());
        assertEquals(0, mp.getDamage());
        assertFalse(mp.typeWeapon);
        assertEquals(0, mp.getHeartValue());
    }

    @Test
    public void testDamageChooser() {
        assertEquals(0, mp.damageChooser());
    }

    @Test
    public void testIsTypeWeapon() {
        assertFalse(mp.isTypeWeapon());
    }

}
