package ui;


import model.EventLog;
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
        json.put("player", story.player.toJson());
        positionSaver(json);
        json.put("inventoryStatus", ui.inventoryStatus);
        json.put("option1", ui.option1.getText());
        json.put("option2", ui.option2.getText());
        json.put("option3", ui.option3.getText());
        json.put("option4", ui.option4.getText());
        json.put("itemButton1", ui.itemButton1.getText());
        json.put("itemButton2", ui.itemButton2.getText());
        json.put("itemButton3", ui.itemButton3.getText());
        json.put("itemButton4", ui.itemButton4.getText());
        json.put("itemButton5", ui.itemButton5.getText());
        json.put("mainTextArea", ui.mainTextArea.getText());
        json.put("weaponNameLabel", ui.weaponNameLabel.getText());
        json.put("hpNumberLabel", ui.hpNumberLabel.getText());
        json.put("monster", monster.toJson());
        json.put("progressBarValue", ui.progressBar.getValue());
        return json;
    }

    //EFFECTS: stores positions as an JsonObject
    private void positionSaver(JSONObject json) {
        json.put("currPos", currPos);
        json.put("nextPos1", nextPos1);
        json.put("nextPos2", nextPos2);
        json.put("nextPos3", nextPos3);
        json.put("nextPos4", nextPos4);
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
        ui.option1.setText(json.getString("option1"));
        ui.option2.setText(json.getString("option2"));
        ui.option3.setText(json.getString("option3"));
        ui.option4.setText(json.getString("option4"));
        ui.itemButton1.setText(json.getString("itemButton1"));
        ui.itemButton2.setText(json.getString("itemButton2"));
        ui.itemButton3.setText(json.getString("itemButton3"));
        ui.itemButton4.setText(json.getString("itemButton4"));
        ui.itemButton5.setText(json.getString("itemButton5"));
        ui.mainTextArea.setText(json.getString("mainTextArea"));
        ui.weaponNameLabel.setText(json.getString("weaponNameLabel"));
        ui.hpNumberLabel.setText(json.getString("hpNumberLabel"));
        setProgressBar(json.getInt("progressBarValue"));
    }

    // setters



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

    //MODIFIES:this
    //EFFECTS: if saved position is end, then the choices and inventory
    // options are not available, otherwise they are shown
    private void setCurrentPos(String currentPosition) {
        this.currPos = currentPosition;
        if (!(currPos == "end")) {
            ui.inventoryButton.setVisible(true);
            ui.choiceButtonPanel.setVisible(true);
        }
    }

    //MODIFIES: this
    //EFFECTS: if progress bar has not been ended, then it will show progress bar
    //otherwise it will not
    private void setProgressBar(int val) {
        ui.progressBar.setValue(val);
        if (ui.progressBar.getValue() == 99) {
            ui.progressBar.setVisible(false);
        } else {
            ui.progressBar.setVisible(true);
        }
    }

    //MODIFIES:this, ui, story
    //EFFECTS: sets same player across interloping classes
    private void setPlayer(Player player) {
        this.player = player;
        ui.setPlayer(player);
        story.player = player;
    }


}


