package model.persistance;

import org.json.JSONObject;
// This class is for turning objects into JSON objects

public abstract class Writable {

    // MODIFIES: this
    // EFFECTS: This overloaded constructor method is to assist items that implement this
    // class to be able to be initialized via JSON
    public Writable(JSONObject json) {
        fromJson(json);
    }

    // MODIFIES: this
    // EFFECTS: default constructor
    public Writable() {
    }

    // EFFECTS: returns this as JSON object
    // This is taken from JsonSerializationDemo's Writeable interface
    public abstract JSONObject toJson();

    //EFFECTS: initializes file from JSONObject
    protected abstract void fromJson(JSONObject json);
}
