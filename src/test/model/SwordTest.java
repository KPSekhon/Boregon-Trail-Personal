package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwordTest {
    Sword s = new Sword();

    @Test
    public void testConstructor() {
        assertEquals("Sword", s.getName());
        assertEquals(6, s.getCost());
        assertEquals(6, s.getDamage());
        assertTrue(s.typeWeapon);
        assertEquals(0, s.getHeartValue());
    }

    @Test
    public void testDamageChooser() {
        boolean b = false;
        int k = s.damageChooser();
        if (k == 6 || k == 7 || k == 8)  {
            b = true;
        } else if (k == 9 || k == 10) {
            b = true;
        }
        assertTrue(b);
    }



    @Test
    public void testIsTypeWeapon() {
        assertTrue(s.isTypeWeapon());
    }
}
