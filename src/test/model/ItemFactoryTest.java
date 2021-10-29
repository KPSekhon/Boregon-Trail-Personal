package model;

import model.exceptions.UnknownItemException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static model.ItemFactory.getItem;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ItemFactoryTest {

    @Test
    public void getItemEmptyName() {
        try {
            JSONObject json = new JSONObject();
            EmptyItem emptyItem = new EmptyItem();
            json = emptyItem.toJson();
            Item b = getItem(json);
            assertEquals(b.getName(), emptyItem.getName());
            assertEquals(b.getCost(), emptyItem.getCost());
            assertEquals(b.getDamage(), emptyItem.getDamage());
            assertEquals(b.getHeartValue(), emptyItem.getHeartValue());
        } catch (UnknownItemException e) {
            fail("This should have been identified");
        }
    }


    @Test
    public void getFullHealthPotion() {
        try {
            JSONObject json = new JSONObject();
            FullHealthPotion fhp = new FullHealthPotion();
            json = fhp.toJson();
            Item b = getItem(json);
            assertEquals(b.getName(), fhp.getName());
            assertEquals(b.getCost(), fhp.getCost());
            assertEquals(b.getDamage(), fhp.getDamage());
            assertEquals(b.getHeartValue(), fhp.getHeartValue());
        } catch (UnknownItemException e) {
            fail("This should have been identified");
        }
    }

    @Test
    public void getHytosTooth() {
        try {
            JSONObject json = new JSONObject();
            HytosTooth tooth = new HytosTooth();
            json = tooth.toJson();
            Item b = getItem(json);
            assertEquals(b.getName(), tooth.getName());
            assertEquals(b.getCost(), tooth.getCost());
            assertEquals(b.getDamage(), tooth.getDamage());
            assertEquals(b.getHeartValue(), tooth.getHeartValue());
        } catch (UnknownItemException e) {
            fail("This should have been identified");
        }
    }
    @Test
    public void getImmortalPotion() {
        try {
            JSONObject json = new JSONObject();
            ImmortalPotion ip = new ImmortalPotion();
            json = ip.toJson();
            Item b = getItem(json);
            assertEquals(b.getName(), ip.getName());
            assertEquals(b.getCost(), ip.getCost());
            assertEquals(b.getDamage(), ip.getDamage());
            assertEquals(b.getHeartValue(), ip.getHeartValue());
        } catch (UnknownItemException e) {
            fail("This should have been identified");
        }
    }

    @Test
    public void getMarblesBag() {
        try {
            JSONObject json = new JSONObject();
            MarblesBag marblesBag = new MarblesBag();
            json = marblesBag.toJson();
            Item b = getItem(json);
            assertEquals(b.getName(), marblesBag.getName());
            assertEquals(b.getCost(), marblesBag.getCost());
            assertEquals(b.getDamage(), marblesBag.getDamage());
            assertEquals(b.getHeartValue(), marblesBag.getHeartValue());
        } catch (UnknownItemException e) {
            fail("This should have been identified");
        }
    }

    @Test
    public void getElfSword() {
        try {
            JSONObject json = new JSONObject();
            ElfSword elfSword = new ElfSword();
            json = elfSword.toJson();
            Item b = getItem(json);
            assertEquals(b.getName(), elfSword.getName());
            assertEquals(b.getCost(), elfSword.getCost());
            assertEquals(b.getDamage(), elfSword.getDamage());
            assertEquals(b.getHeartValue(), elfSword.getHeartValue());
        } catch (UnknownItemException e) {
            fail("This should have been identified");
        }
    }
    @Test
    public void getBrokenWeapon() {
        try {
            JSONObject json = new JSONObject();
            EmptyWeapon ew = new EmptyWeapon();
            json = ew.toJson();
            Item b = getItem(json);
            assertEquals(b.getName(), ew.getName());
            assertEquals(b.getCost(), ew.getCost());
            assertEquals(b.getDamage(), ew.getDamage());
            assertEquals(b.getHeartValue(), ew.getHeartValue());
        } catch (UnknownItemException e) {
            fail("This should have been identified");
        }
    }

    @Test
    public void getKentuckyRifle() {
        try {
            JSONObject json = new JSONObject();
            KentuckyRifle kentuckyRifle = new KentuckyRifle();
            json = kentuckyRifle.toJson();
            Item b = getItem(json);
            assertEquals(b.getName(), kentuckyRifle.getName());
            assertEquals(b.getCost(), kentuckyRifle.getCost());
            assertEquals(b.getDamage(), kentuckyRifle.getDamage());
            assertEquals(b.getHeartValue(), kentuckyRifle.getHeartValue());
        } catch (UnknownItemException e) {
            fail("This should have been identified");
        }
    }

    @Test
    public void getKnife() {
        try {
            JSONObject json = new JSONObject();
            Knife knife = new Knife();
            json = knife.toJson();
            Item b = getItem(json);
            assertEquals(b.getName(), knife.getName());
            assertEquals(b.getCost(), knife.getCost());
            assertEquals(b.getDamage(), knife.getDamage());
            assertEquals(b.getHeartValue(), knife.getHeartValue());
        } catch (UnknownItemException e) {
            fail("This should have been identified");
        }
    }

    @Test
    public void getSword() {
        try {
            JSONObject json = new JSONObject();
            Sword sword = new Sword();
            json = sword.toJson();
            Item b = getItem(json);
            assertEquals(b.getName(), sword.getName());
            assertEquals(b.getCost(), sword.getCost());
            assertEquals(b.getDamage(), sword.getDamage());
            assertEquals(b.getHeartValue(), sword.getHeartValue());
        } catch (UnknownItemException e) {
            fail("This should have been identified");
        }
    }

}
