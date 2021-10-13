package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnifeTest {
    Knife k = new Knife();

    @Test
    public void testConstructor() {
        assertEquals("Knife",
                k.getName());
        assertEquals(3, k.getCost());
        assertEquals(3, k.getDamage());
        assertTrue(k.typeWeapon);
        assertEquals(0, k.getHeartValue());
    }

    @Test
    public void testDamageChooser() {
        boolean b = false;
        int l = k.damageChooser();
        if (l == 1 || l == 2 || l == 3)  {
            b = true;
        }
        assertTrue(b);
        }


    @Test
    public void testIsTypeWeapon() {
        assertTrue(k.isTypeWeapon());
    }
}
