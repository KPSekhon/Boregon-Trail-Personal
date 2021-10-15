package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HytosToothTest {
    HytosTooth ht = new HytosTooth();

    @Test
    public void testConstructor () {
        assertEquals("The tooth of Hytos the troll", ht.getName());
        assertEquals(400, ht.getCost());
        assertEquals(0, ht.getDamage());
        assertFalse(ht.typeWeapon);
        assertEquals(0, ht.getHeartValue());
    }

    @Test
    public void testDamageChooser() {
        assertEquals(0, ht.damageChooser());
    }

    @Test
    public void testIsTypeWeapon() {
        assertFalse(ht.isTypeWeapon());
    }
}
