package model;

import model.persistance.GameJsonReader;
import model.persistance.GameJsonWriter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import ui.Game;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest {
    final String saveLocation = "./data/myFile.txt";
    GameJsonWriter gs = new GameJsonWriter(saveLocation);
    GameJsonReader gr = new GameJsonReader(saveLocation);

    @Test
    public void testWritePlayerWithItem() {
        Player player = new Player("bob");
        player.addItem(new ElfSword());
        try {
            gs.open();
            gs.write(player);
            gs.close();
            JSONObject json = gr.read();
            Player loadedPlayer = new Player(json);
            JSONArray inventory = json.getJSONArray("inventory");
            assertEquals(loadedPlayer.getWeapon().getName(),player.getWeapon().getName());
            assertEquals(inventory.length(),player.getInventorySize());
            assertEquals(loadedPlayer.getPlayerHP(), player.getPlayerHP());
            assertEquals(loadedPlayer.getName(), player.getName());
            assertEquals(loadedPlayer.getWallet(),player.getWallet());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("should not fail");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWritePlayerWhoStartsWithoutItem() {
        Player player = new Player("bob");
        EmptyWeapon emptyWeapon = new EmptyWeapon();
        ElfSword elfSword = new ElfSword();
        try {
            gs.open();
            gs.write(player);
            gs.close();
            JSONObject json = gr.read();
            Player loadedPlayer = new Player(json);
            JSONArray inventory = json.getJSONArray("inventory");
            assertEquals(inventory.length(),player.getInventorySize());
            assertEquals(loadedPlayer.getPlayerHP(), player.getPlayerHP());
            assertEquals(loadedPlayer.getName(), player.getName());
            assertEquals(loadedPlayer.getWallet(),player.getWallet());
            assertEquals(loadedPlayer.getWeapon().getName(), emptyWeapon.getName());
            loadedPlayer.addItem(elfSword);
            assertEquals(loadedPlayer.getWeaponName(),elfSword.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("should not fail");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteMonster() {
        Monster monster = new Monster();
        try {
            gs.open();
            gs.write(monster);
            gs.close();
            JSONObject json = gr.read();
            Monster monster1 = new Monster(json);
            assertEquals(monster1.getName(), monster.getName());
            assertEquals(monster1.getHP(),monster.getHP());
            assertEquals(monster1.getInitialHP(),monster.getInitialHP());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("should not fail");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
