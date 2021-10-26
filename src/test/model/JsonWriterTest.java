package model;

import model.persistance.GameJsonReader;
import model.persistance.GameJsonWriter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import ui.Game;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest {
    final String saveLocation = "./data/myFile.txt";
    GameJsonWriter gs = new GameJsonWriter(saveLocation);
    GameJsonReader gr = new GameJsonReader(saveLocation);

    @Test
    public void testWrite() {
        Player player = new Player("bob");
        player.addItem(new ElfSword());
        try {
            gs.open();
            gs.write(player);
            gs.close();
            JSONObject json = gr.read();
            System.out.println(json);
            Player loadedp = new Player(json);
            gs.open();
            gs.write(loadedp);
            gs.close();
            JSONObject json1 = gr.read();
//            JSONArray inventory = json.getJSONArray("inventory");
//            JSONObject rawItem = inventory.getJSONObject(0);
           System.out.println(json1);
//            System.out.println(rawItem);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("should not fail");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
