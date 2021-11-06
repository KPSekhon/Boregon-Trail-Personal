package ui;

import model.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceHandler implements ActionListener {
    String input;
    Game1 game1;

    public ChoiceHandler(Game1 game1) {
        this.game1 = game1;
    }

    @Override
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
                game1.vm.titleToGame();
                game1.story.setup();
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
        }
    }
}
