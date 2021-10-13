package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KentuckyRifleTest {
    KentuckyRifle kf = new KentuckyRifle();

    @Test
    public void testConstructor() {
        assertEquals("Kentucky Rifle with 4 bullets",
                kf.getName());
        assertEquals(8, kf.getCost());
        assertEquals(12, kf.getDamage());
        assertTrue(kf.typeWeapon);
        assertEquals(0, kf.getHeartValue());
    }

    @Test
    public void testDamageChooser() {
        boolean b = kf.damageChooser() == 0 || kf.damageChooser() == 12;
        assertTrue(b);
    }

    @Test
    public void testIsTypeWeapon() {
        assertTrue(kf.isTypeWeapon());
    }

}
