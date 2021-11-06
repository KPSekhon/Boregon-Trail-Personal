package ui;


import model.Monster;

public class Game1 {
    ChoiceHandler choiceHandler = new ChoiceHandler(this);
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, vm);
    String nextPos1;
    String nextPos2;
    String nextPos3;
    String nextPos4;
    String currPos;
    String saveLocation = "./data/game1.json";
    Monster monster = new Monster();



    public static void main(String[] args) {
        new Game1();
    }

    public Game1() {
        ui.createVisualUI(choiceHandler);
        vm.showTitleScreen();

    }


}


