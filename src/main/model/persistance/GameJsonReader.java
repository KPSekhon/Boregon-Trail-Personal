package model.persistance;

import org.json.JSONObject;
import ui.Game;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// This class is for reconstructing JSON objects stored within a file
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
            stream.forEach(contentBuilder::append);
        }

        return contentBuilder.toString();
    }

}



