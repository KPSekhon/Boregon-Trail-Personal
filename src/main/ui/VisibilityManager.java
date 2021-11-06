package ui;

public class VisibilityManager {
    UI ui;
    Story story;

    public VisibilityManager(UI ui) {
        this.ui = ui;
    }

    public void showTitleScreen() {
        // Show the title screen
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        // Hide the game screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);

        // Hide Input
        ui.inputPanel.setVisible(false);
        ui.namePanel.setVisible(false);
    }

    public void titleToGame() {
        // Hide the title screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        // Show  the game screen
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);

        // Hide Input
        ui.inputPanel.setVisible(false);
        ui.namePanel.setVisible(false);
    }

    public void playerInput() {
        // Hide the title screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        // Hide the game screen
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);

        // Show Input
        ui.inputPanel.setVisible(true);
        ui.namePanel.setVisible(true);

    }
}
