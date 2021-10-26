package model.persistance;

import org.json.JSONObject;
import ui.Game;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class GameJsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    // source:JsonSerialization's constructor method
    public GameJsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads game from file and returns it;
    // throws IOException if an error occurs reading data from file
    // source:JsonSerialization's constructor method
    public JSONObject read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
//        return parseGame(jsonObject);
        return jsonObject;
    }

    // EFFECTS: reads source file as string and returns it
    // source:JsonSerialization's constructor method
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses game from JSON object and returns it
    // source:JsonSerialization's constructor method
    private Game parseGame(JSONObject jsonObject) {
        Game game = new Game();
        addFields(game, jsonObject);
        return game;
    }

    // MODIFIES: game
    // EFFECTS: parses fields from JSON object and adds them to game
    // source:JsonSerialization's constructor method
    private void addFields(Game game, JSONObject jsonObject) {
//        game.setPlayer((jsonObject.getJSONObject("player")));
//        game.setPosition((jsonObject.getString("position")));
//        game.setNextPosition1((jsonObject.getString("nextPosition1")));
//        game.setNextPosition2((jsonObject.getString("nextPosition2")));
//        game.setNextPosition3((jsonObject.getString("nextPosition3")));
//        game.setNextPosition4((jsonObject.getString("nextPosition4")));
//        game.setNextPosition5((jsonObject.getString("nextPosition5")));
//        game.setMonster((jsonObject.getJSONObject("monster")));
//        game.setAlive(jsonObject.getBoolean("alive"));
    }

}



