package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ImmortalPotionTest {

    ImmortalPotion ip = new ImmortalPotion();

    @Test
    public void testConstructor () {
        assertEquals("Temporary Immortal Potion",ip.getName());
        assertEquals(3,ip.getCost());
        assertEquals(0, ip.getDamage());
        assertFalse(ip.typeWeapon);
        assertEquals(27, ip.getHeartValue());
    }

    @Test
    public void testDamageChooser() {
        assertEquals(0, ip.damageChooser());
    }

    @Test
    public void testIsTypeWeapon() {
        assertFalse(ip.isTypeWeapon());
    }


}
