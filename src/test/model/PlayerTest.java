package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    Player player = new Player("Billy");
    MarblesBag marblesBag = new MarblesBag();

    @BeforeEach
    public void setup() {
        assertEquals(10, player.getPlayerHP());
        assertEquals(10, player.getWallet());
        assertEquals(0, player.getInventorySize());
    }

    @Test
    public void testConstructor() {
        setup();
        assertEquals("Billy", player.getName());
        assertEquals(10, player.getWallet());
        assertEquals(0, player.getInventorySize());
    }

    @Test
    public void testAddHP() {
        setup();
        player.addHP(5);
        assertEquals(15, player.getPlayerHP());
    }

    @Test
    public void testLoseHPWithinRange() {
        setup();
        assertEquals(5, player.loseHP(5));
    }

    @Test
    public void testLoseHPBeyondRange() {
        setup();
        assertEquals(0, player.loseHP(25));
    }

    @Test
    public void testAddMoney() {
        setup();
        player.addMoney(5);
        assertEquals(15, player.getWallet());
    }

    @Test
    public void testSpendMoneyWithinRange() {
        setup();
        player.addMoney(5);
        assertEquals(15, player.getWallet());
        assertTrue(player.spendMoney(5));
        setup();
    }

    @Test
    public void testSpendMoneyBeyondRange() {
        setup();
        player.addMoney(5);
        assertEquals(15, player.getWallet());
        assertFalse(player.spendMoney(20));
        assertEquals(15, player.getWallet());
    }

    @Test
    public void testAddItem() {
        setup();
        player.addItem(marblesBag);
        assertEquals(1, player.getInventorySize());
    }

    @Test
    public void testLoseItemYouHave() {
        setup();
        player.addItem(marblesBag);
        assertEquals(1, player.getInventorySize());
        assertTrue(player.loseItem(marblesBag));
        assertEquals(0, player.getInventorySize());

    }

    @Test
    public void testLoseItemYouDoNotHave() {
        setup();
       assertFalse( player.loseItem(marblesBag));
       assertEquals(0, player.getInventorySize());
    }
}
