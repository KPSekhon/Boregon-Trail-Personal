package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class EmptyItemTest {
    EmptyItem eo = new EmptyItem();

    @Test
    public void testConstructor () {
        assertEquals("", eo.getName());
        assertEquals(0, eo.getCost());
        assertEquals(0, eo.getDamage());
        assertFalse(eo.typeWeapon);
        assertEquals(0, eo.getHeartValue());
    }

    @Test
    public void testDamageChooser() {
        assertEquals(0, eo.damageChooser());
    }

    @Test
    public void testIsTypeWeapon() {
        assertFalse(eo.isTypeWeapon());
    }
}
