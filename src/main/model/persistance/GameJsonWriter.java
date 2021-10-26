package model.persistance;

import org.json.JSONArray;
import org.json.JSONObject;
import ui.Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// This class comes from JsonSerialization's JsonWriter class and is modified to suit the need of this Game
// Represents a writer that writes JSON representation of Game to file
public class GameJsonWriter {
    private PrintWriter writer;
    private final String saveLocation;
    private static final int TAB = 4;

    //EFFECTS: constructs writer to write to the designated saveLocation file
    // source:JsonSerialization's constructor method
    public GameJsonWriter(String saveLocation) {
        this.saveLocation = saveLocation;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    // source:JsonSerialization's constructor method
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(saveLocation));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of game to file
    // source:JsonSerialization's constructor method
    public void write(Writable json) {
        saveToFile(json.toJson().toString(TAB));
    }


    // MODIFIES: this
    // EFFECTS: closes writer
    // source:JsonSerialization's constructor method
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    // source:JsonSerialization's constructor method
    private void saveToFile(String json) {
        writer.print(json);
    }


}
