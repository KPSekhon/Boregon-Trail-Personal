package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MysteryWaterTest {
    MysteryWater mw = new MysteryWater();

    @Test
    public void testConstructor () {
        assertEquals("Mysterious Water Bottle", mw.getName());
        assertEquals(0, mw.getCost());
        assertEquals(0, mw.getDamage());
        assertFalse(mw.typeWeapon);
        boolean b = false;
        int m = mw.randomHealthTrait();
        if (m == -2 || m == 2 )  {
            b = true;
        }
        assertTrue(b);
    }

    @Test
    public void testDamageChooser() {
        assertEquals(0, mw.damageChooser());
    }

    @Test
    public void testIsTypeWeapon() {
        assertFalse(mw.isTypeWeapon());
    }

}
