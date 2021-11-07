package ui;

// This class changes the panels that are displayed for the user
public class VisibilityManager {
    UI ui;

    //MODIFIES: this
    //EFFECTS: instantiates the UI
    public VisibilityManager(UI ui) {
        this.ui = ui;
    }

    //MODIFIES: this, game1, ui
    //EFFECTS: shows title screen, hides game screen and name input screen
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in making the method
    public void showTitleScreen() {
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        ui.persistencePanel.setVisible(false);

        ui.inputPanel.setVisible(false);
        ui.namePanel.setVisible(false);
    }

    //MODIFIES: this, game1, ui
    //EFFECTS: shows game screen, hides title screen and name input screen
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in making the method
    public void titleToGame() {
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
        ui.persistencePanel.setVisible(true);

        ui.inputPanel.setVisible(false);
        ui.namePanel.setVisible(false);
    }

    //MODIFIES: this, game1, ui
    //EFFECTS: shows name input screen, hides game screen and title screen
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in making the method
    public void playerInput() {
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        ui.persistencePanel.setVisible(false);

        ui.inputPanel.setVisible(true);
        ui.namePanel.setVisible(true);

    }
}
