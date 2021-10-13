package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ElfSwordTest {
    ElfSword es = new ElfSword();
    @Test
    public void testConstructor () {
        assertEquals("Elf Sword",es.getName());
        assertEquals(0,es.getCost());
        assertEquals(50, es.getDamage());
        assertTrue(es.typeWeapon);
        assertEquals(0, es.getHeartValue());
    }

    @Test
    public void testDamageChooser() {
        assertEquals(50, es.damageChooser());
    }

    @Test
    public void testIsTypeWeapon() {
        assertTrue(es.isTypeWeapon());
    }


}
