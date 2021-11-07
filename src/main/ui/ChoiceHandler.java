package ui;

import model.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This class handles the in-game choices made by clicking the buttons
public class ChoiceHandler implements ActionListener {
    String input;
    Game1 game1;

    //MODIFIES: this
    // EFFECTS: instantiates the game choice handler acts upon
    public ChoiceHandler(Game1 game1) {
        this.game1 = game1;
    }

    @Override
    //MODIFIES: game1,this
    //EFFECTS: completes action associated with the button pressed
    // This method references code from linked playlist:
    // link - https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    public void actionPerformed(ActionEvent e) {
        this.input = e.getActionCommand();
        String name;

        switch (input) {
            case "start":
                game1.vm.playerInput();
                break;
            case "enter":
                name = game1.ui.nameInput.getText();
                game1.ui.setPlayer(new Player(name));
                game1.player = game1.ui.player;
                game1.vm.titleToGame();
                game1.story.setup();
                break;
        }
        actionPerformedContinued();
    }

    //MODIFIES: game1, this
    //EFFECTS: completes action associated with the button pressed
    // This method references code from linked playlist:
    // link - https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    public void actionPerformedContinued() {
        switch (input) {
            case "choice1":
                game1.story.selectPosition(game1.nextPos1);
                break;
            case "choice2":
                game1.story.selectPosition(game1.nextPos2);
                break;
            case "choice3":
                game1.story.selectPosition(game1.nextPos3);
                break;
            case "choice4":
                game1.story.selectPosition(game1.nextPos4);
                break;
            case "save":
                game1.saveGame();
                break;
            case "load":
                game1.loadGame();
                break;

        }
    }
}
