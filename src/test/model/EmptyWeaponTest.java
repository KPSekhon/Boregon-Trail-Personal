package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmptyWeaponTest {
    EmptyWeapon ew = new EmptyWeapon();

    @Test
    public void testConstructor () {
        assertEquals("broken weapon", ew.getName());
        assertEquals(0, ew.getCost());
        assertEquals(0, ew.getDamage());
        assertTrue(ew.typeWeapon);
        assertEquals(0, ew.getHeartValue());
    }

    @Test
    public void testDamageChooser() {
        assertEquals(0, ew.damageChooser());
    }

    @Test
    public void testIsTypeWeapon() {
        assertTrue(ew.isTypeWeapon());
    }
}
