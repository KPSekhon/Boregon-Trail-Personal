package ui;


import model.Monster;
import model.Player;
import org.json.JSONObject;
import persistance.GameJsonReader;
import persistance.GameJsonWriter;
import persistance.Writable;

import java.io.FileNotFoundException;
import java.io.IOException;

// This class represents the visual GUI representation of the game
public class Game1 extends Writable {
    ChoiceHandler choiceHandler = new ChoiceHandler(this);
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, vm);
    String nextPos1;
    String nextPos2;
    String nextPos3;
    String nextPos4;
    String currPos = "";
    Player player;
    String saveLocation = "./data/game1.json";
    Monster monster = new Monster();


    public static void main(String[] args) {
        new Game1();
    }

    // MODIFIES: ui, Visibility Manager, ChoiceHandler
    // EFFECTS: create screen and begins chain of game commands
    public Game1() {
        ui.createVisualUI(choiceHandler);
        vm.showTitleScreen();

    }

    //EFFECTS: stores Game as an JsonObject
    // Source: JSonSerializationDemo
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("player", player.toJson());
        json.put("currPos", currPos);
        json.put("nextPos1", nextPos1);
        json.put("nextPos2", nextPos2);
        json.put("nextPos3", nextPos3);
        json.put("nextPos4", nextPos4);
        json.put("mainField", ui.mainTextArea.getText());
        json.put("monster", monster.toJson());
        return json;
    }
    public void getUistuff(){
    }

    // EFFECTS: saves the game to a file
    public void saveGame() {
        GameJsonWriter gs = new GameJsonWriter(saveLocation);
        try {
            gs.open();
            gs.write(this);
            gs.close();
            ui.mainTextArea.setText("Saved game to " + saveLocation);
        } catch (FileNotFoundException e) {
            ui.mainTextArea.setText("Unable to write to file: " + saveLocation);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads game from file
    public void loadGame() {
        GameJsonReader gr = new GameJsonReader(saveLocation);
        try {
            fromJson(gr.read());
            String previous = ui.mainTextArea.getText();
            ui.mainTextArea.setText("Loaded game from " + saveLocation + "\n"
                    + previous);
        } catch (IOException e) {
            ui.mainTextArea.setText("Unable to read from file: " + saveLocation);
        }
    }

    @Override
    // MODIFIES: this
    // EFFECTS: transforms JSONObject into Game
    protected void fromJson(JSONObject json) {
        setPlayer(new Player(json.getJSONObject("player")));
        setCurrentPos(json.getString("currPos"));
        setNextPos1((json.getString("nextPos1")));
        setNextPos2((json.getString("nextPos2")));
        setNextPos3((json.getString("nextPos3")));
        setNextPos4((json.getString("nextPos4")));
        setMonster(new Monster(json.getJSONObject("monster")));
        setMainText((json.getString("mainField")));
    }

    // setters
    private void setMainText(String mainText) {
        ui.mainTextArea.setText(mainText);
    }

    private void setMonster(Monster monster) {
        this.monster = monster;
    }

    private void setNextPos1(String nextPos1) {
        this.nextPos1 = nextPos1;
    }

    private void setNextPos2(String nextPos2) {
        this.nextPos2 = nextPos2;
    }

    private void setNextPos3(String nextPos3) {
        this.nextPos3 = nextPos3;
    }

    private void setNextPos4(String nextPos4) {
        this.nextPos4 = nextPos4;
    }

    private void setCurrentPos(String currentPosition) {
        this.currPos = currentPosition;
    }

    private void setPlayer(Player player) {
        this.player = player;
    }


}


