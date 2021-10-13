package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class FullHealthPotionTest {
    FullHealthPotion fhp = new FullHealthPotion();

    @Test
    public void testConstructor () {
        assertEquals("Full Health Potion", fhp.getName());
        assertEquals(5, fhp.getCost());
        assertEquals(0, fhp.getDamage());
        assertFalse(fhp.typeWeapon);
        assertEquals(10, fhp.getHeartValue());
    }

    @Test
    public void testDamageChooser() {
        assertEquals(0, fhp.damageChooser());
    }

    @Test
    public void testIsTypeWeapon() {
        assertFalse(fhp.isTypeWeapon());
    }

}
