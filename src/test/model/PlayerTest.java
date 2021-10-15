package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    Player player = new Player("Billy");
    MarblesBag marblesBag = new MarblesBag();
    Sword sword = new Sword();
    Monster m = new Monster();
    ElfSword e = new ElfSword();
    FullHealthPotion f = new FullHealthPotion();

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
    public void testAddHPTwice() {
        setup();
        player.addHP(5);
        assertEquals(15, player.getPlayerHP());
        player.addHP(5);
        assertEquals(20, player.getPlayerHP());
    }

    @Test
    public void testLoseHPWithinRange() {
        setup();
        assertEquals(5, player.loseHP(5));
    }

    @Test
    public void testLoseHPWithinRangeTwice() {
        setup();
        assertEquals(5, player.loseHP(5));
        assertEquals(0, player.loseHP(5));
    }

    @Test
    public void testLoseHPBeyondRange() {
        setup();
        assertEquals(0, player.loseHP(25));
    }
    @Test
    public void testLoseHPBeyondRangeTwice() {
        setup();
        assertEquals(0, player.loseHP(25));
        assertEquals(0, player.loseHP(25));
    }

    @Test
    public void testAddMoney() {
        setup();
        player.addMoney(5);
        assertEquals(15, player.getWallet());
    }

    @Test
    public void testAddMoneyTwice() {
        setup();
        player.addMoney(5);
        assertEquals(15, player.getWallet());
        player.addMoney(5);
        assertEquals(20, player.getWallet());
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
    public void testSpendMoneyWithinRangeTwice() {
        setup();
        player.addMoney(5);
        assertEquals(15, player.getWallet());
        assertTrue(player.spendMoney(5));
        setup();
        assertTrue(player.spendMoney(5));
        assertEquals(5, player.getWallet());
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
    public void testSpendMoneyBeyondRangeTwice() {
        setup();
        player.addMoney(5);
        assertEquals(15, player.getWallet());
        assertFalse(player.spendMoney(20));
        assertEquals(15, player.getWallet());
        assertFalse(player.spendMoney(30));
        assertEquals(15, player.getWallet());
    }

    @Test
    public void testAddItem() {
        setup();
        player.addItem(marblesBag);
        assertEquals(1, player.getInventorySize());
    }

    @Test
    public void testAddTwoItemsOneWeapon() {
        setup();
        player.addItem(marblesBag);
        assertEquals(1, player.getInventorySize());
        player.addItem(sword);
        assertEquals(2, player.getInventorySize());
        assertEquals(sword.getName(), player.getWeaponName());
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
    public void testLoseItemYouHaveMultipleItems() {
        setup();
        player.addItem(marblesBag);
        player.addItem(sword);
        assertEquals(2, player.getInventorySize());
        assertTrue(player.loseItem(marblesBag));
        assertEquals(1, player.getInventorySize());
    }

    @Test
    public void testLoseAllItemsYouHaveMultipleItems() {
        setup();
        player.addItem(marblesBag);
        player.addItem(sword);
        assertEquals(2, player.getInventorySize());
        assertTrue(player.loseItem(marblesBag));
        assertEquals(1, player.getInventorySize());
        assertTrue(player.loseItem(sword));
        assertEquals(0, player.getInventorySize());
    }

    @Test
    public void testLoseItemYouDoNotHave() {
        setup();
       assertFalse( player.loseItem(marblesBag));
       assertEquals(0, player.getInventorySize());
    }

    @Test
    public void testLoseItemsYouDoNotHave() {
        setup();
        assertFalse( player.loseItem(marblesBag));
        assertFalse( player.loseItem(sword));
        assertEquals(0, player.getInventorySize());
    }


    @Test
    public void testHealPlayer() {
        setup();
        player.loseHP(5);
        assertEquals(5, player.getPlayerHP());
        player.healPlayer(f);
        assertEquals(15, player.getPlayerHP());
    }

    @Test
    public void testHasItem() {
        setup();
        player.addItem(f);
        assertTrue(player.hasItem(f));
        assertEquals(1, player.getInventorySize());
    }

    @Test
    public void testHasItems() {
        setup();
        player.addItem(f);
        player.addItem(e);
        assertTrue(player.hasItem(f));
        assertTrue(player.hasItem(e));
        assertEquals(2, player.getInventorySize());
    }

    @Test
    public void testDoesNotHaveItem() {
        setup();
        assertFalse(player.hasItem(f));
        setup();
    }

    @Test
    public void testDoesNotHaveItems() {
        setup();
        assertFalse(player.hasItem(f));
        assertFalse(player.hasItem(e));
        setup();
    }
    @Test
    public void testGetWeapon() {
        setup();
        player.addItem(sword);
        assertEquals(sword, player.getWeapon());
    }

    @Test
    public void testGetInventoryItemWithinBounds() {
        setup();
        player.addItem(sword);
        assertEquals(1, player.getInventorySize());
        assertEquals(sword.getName(), player.getWeaponName());
        assertEquals(sword, player.getInventoryItem(0));
    }
    @Test
    public void testGetInventoryItemsWithinBounds() {
        setup();
        player.addItem(sword);
        assertEquals(1, player.getInventorySize());
        player.addItem(marblesBag);
        assertEquals(2, player.getInventorySize());
        assertEquals(sword.getName(), player.getWeaponName());
        assertEquals(sword, player.getInventoryItem(0));
        assertEquals(marblesBag, player.getInventoryItem(1));
    }

    @Test
    public void testGetInventoryItemOutsideBounds() {
        setup();
        EmptyItem emptyItem = new EmptyItem();
        assertEquals(emptyItem.getName(), player.getInventoryItem(0).getName());
        setup();
    }
    @Test
    public void testGetInventoryItemsOutsideBounds() {
        setup();
        EmptyItem emptyItem = new EmptyItem();
        assertEquals(emptyItem.getName(), player.getInventoryItem(0).getName());
        assertEquals(emptyItem.getName(), player.getInventoryItem(1).getName());
        setup();
    }


}
