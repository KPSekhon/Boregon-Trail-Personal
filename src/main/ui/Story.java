package ui;

import model.*;
import org.json.JSONObject;
import persistance.GameJsonReader;
import persistance.GameJsonWriter;
import persistance.Writable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

// This class represents the visual representation of the in-game story
public class Story {
    UI ui;
    VisibilityManager vm;
    Game1 game1;
    Player player;

    // MODIFIES: this
    // EFFECTS: instantiates the story
    public Story(Game1 game1, UI ui, VisibilityManager vm) {
        this.game1 = game1;
        this.ui = ui;
        this.vm = vm;
    }


    // MODIFIES: this, ui, game1
    // EFFECTS: sets up player name and story
    public void setup() {
        player = ui.player;
        ui.inventoryStatus = "close";
        EmptyWeapon emptyWeapon = new EmptyWeapon();
        player.setWeapon(emptyWeapon);
        ui.weaponNameLabel.setText(player.getWeaponName());
        ui.hpNumberLabel.setText("" + player.getPlayerHP());
        KentuckyRifle kentuckyRifle = new KentuckyRifle();
        Knife knife = new Knife();
        Sword sword = new Sword();
        ui.mainTextArea.setText("What would weapon would you like? \n"
                + "You have " + player.getWallet() + " dollars in your wallet \n"
                + kentuckyRifle.getName() + " costing " + kentuckyRifle.getCost() + " dollars.\n"
                + knife.getName() + " costing " + knife.getCost() + " dollars.\n"
                + sword.getName() + " costing " + sword.getCost() + " dollars.");
        ui.option1.setText("Kentucky Rifle");
        ui.option2.setText("Knife");
        ui.option3.setText("Sword");
        ui.option4.setText("");

        game1.nextPos1 = "Kentucky Rifle";
        game1.nextPos2 = "Knife";
        game1.nextPos3 = "Sword";
        game1.nextPos4 = "";
    }

    // MODIFIES: this
    // EFFECTS: completes command chosen by user to just before crossroad
    // This method references code from this link
    // Link:
    // https://www.youtube.com/watch?v=j99EeUjvLVQ&list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV&index=5&ab_channel=RyiSnow
    public void selectPosition(String nextPosition) {
        switch (nextPosition) {
            case "Kentucky Rifle":
                setupWeaponKentucky();
                break;
            case "Sword":
                setupWeaponSword();
                break;
            case "Knife":
                setupWeaponKnife();
                break;
            case "wait for saviour to arrive":
                waitForSaviour();
                break;
            case "start the trail":
                startTheTrail();
                break;
            case "Buy the supposed potion":
                purchaseImmortalPotion();
                break;
        }
        selectPositionCrossroad(nextPosition);
    }

    // MODIFIES: this
    // EFFECTS: completes command chosen by user to just before monster event
    private void selectPositionCrossroad(String nextPosition) {
        switch (nextPosition) {
            case "head to the crossroad":
            case "return to the crossroad":
            case "Leave the thing alone":
                crossroad();
                break;
            case "head west":
            case "head to Blue River":
                blueRiver();
                break;
            case "decideToDrinkWater":
                decideToDrinkMysteryWater();
                break;
            case "drink the water":
                drinkMysteryWater();
                break;
        }
        selectPositionCanyonBridgeOnwardsInitial(nextPosition);
    }

    // MODIFIES: this
    // EFFECTS: completes command chosen by user until initial encounter of monster
    private void selectPositionCanyonBridgeOnwardsInitial(String nextPosition) {
        switch (nextPosition) {
            case "head east":
            case "head to Stoole Rock":
                stooleRock();
                break;
            case "read the writing":
                readTheWriting();
                break;
            case "head north":
                monsterEncounterInitial();
                break;
            case "run for your life":
            case "return to crossroad":
                returnToCrossroad();
                break;
        }
        selectPositionCanyonBridgeOnwardsAdditional(nextPosition);
    }

    // MODIFIES: this
    // EFFECTS: completes command chosen by user after initial encounter of monster
    private void selectPositionCanyonBridgeOnwardsAdditional(String nextPosition) {
        switch (nextPosition) {
            case "head to Canyon Bridge":
                monsterEncounterAdditional();
                break;
            case "fight Hytos":
                fightMonster();
                break;
            case "attack Hytos":
                attackMonster();
                break;
            case "move forwards":
                victory();
                break;
            case "limp away rich":
                unicornEnding();
                break;
        }
        selectGameChanger(nextPosition);
    }

    // MODIFIES: this
    // EFFECTS: completes command chosen by user for saving/loading or the endings
    private void selectGameChanger(String nextPosition) {
        switch (nextPosition) {
            case "accept the offer":
                happyEnding();
                break;
            case "continue to walk":
                badEnding();
                break;
        }
    }

    // MODIFIES: this, ui, game1
    // EFFECTS: sets all options to death of player scenario
    // and provides restart option
    private void setPlayerDeath() {
        HeartPoints hp = new HeartPoints(0);
        player.setHeartPoints(hp);
        ui.hpNumberLabel.setText("" + player.getPlayerHP());
        ui.option1.setText("");
        ui.option2.setText("");
        ui.option3.setText("");
        ui.option4.setText("");
        ui.inventoryButton.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.restartButton.setVisible(true);

        game1.nextPos1 = "";
        game1.nextPos2 = "";
        game1.nextPos3 = "";
        game1.nextPos4 = "";
        game1.currPos = "end";
    }

    // MODIFIES: this, ui, game1
    // EFFECTS: ends the game , provides player with satisfaction
    private void happyEnding() {
        ui.mainTextArea.setText(player.getName() + " is able to get to Oregon "
                + "and claim " + player.getName() + "'s inheritance \n"
                + "Game Over!");
        setPlayerDeath();
    }

    // MODIFIES: this, ui, game1
    // EFFECTS: ends the game , provides player with dissatisfaction
    private void badEnding() {
        ui.mainTextArea.setText(player.getName() + " ignores the offer and continues to walk into the"
                + " Maze Woods, where " + player.getName() + " gets lost until the end of their days \n"
                + "Game Over!");
        setPlayerDeath();
    }

    // MODIFIES: this, ui, game1
    // EFFECTS: displays options when player gets to the crossroad
    private void crossroad() {
        ui.mainTextArea.setText(player.getName() + " comes to a crossroad \n"
                + " What will " + player.getName() + " do?");
        ui.option1.setText("head west");
        ui.option2.setText("head east");
        ui.option3.setText("head north");
        ui.option4.setText("");

        game1.nextPos1 = "head west";
        game1.nextPos2 = "head east";
        game1.nextPos3 = "head north";
        game1.nextPos4 = "";
        game1.currPos = "return to the crossroad";
    }

    // MODIFIES: this,ui, and game1
    // EFFECTS: ends the game and takes player to Oregon
    private void unicornEnding() {
        ui.mainTextArea.setText(player.getName() + " encounters a sorceresses \n"
                + "The sorceresses offers " + player.getName()
                + " a ride on her flying horse to Oregon because she's going to visit "
                + "her sister in Seattle anyways");
        ui.option1.setText("accept the offer");
        ui.option2.setText("continue to walk");
        ui.option3.setText("");
        ui.option4.setText("");

        game1.nextPos1 = "accept the offer";
        game1.nextPos2 = "continue to walk";
        game1.nextPos3 = "";
        game1.nextPos4 = "";
    }

    //MODIFIES: this, ui, and game1
    //EFFECTS: the player initiates battle and gets attacked by Hytos the troll
    // if at some point player's HP is too low, ends program
    private void fightMonster() {
        int monsterAttack = game1.monster.attackChooser();
        player.loseHP(monsterAttack);
        ui.mainTextArea.setText(game1.monster.getName() + " attacks "
                + player.getName() + " for " + monsterAttack + " HP");
        if (lowPlayerHP()) {
            setPlayerDeath();
            ui.mainTextArea.setText(game1.monster.getName() + " attacks "
                    + player.getName() + " for " + monsterAttack + " HP \n"
                    + player.getName() + " has perished"
                    + "\n Game Over!");
        } else {
            ui.mainTextArea.setText(game1.monster.getName() + " attacks "
                    + player.getName() + " for " + monsterAttack + " HP \n"
                    + player.getName() + " has " + player.getPlayerHP() + " HP remaining");
            ui.hpNumberLabel.setText("" + player.getPlayerHP());
            hytosAttackSlots();
        }
    }

    // MODIFIES: this, ui, game1
    // EFFECTS: sets all options to attacking Hytos the troll scenario
    private void hytosAttackSlots() {
        ui.option1.setText("attack Hytos");
        ui.option2.setText("run for your life");
        ui.option3.setText("");
        ui.option4.setText("");

        game1.nextPos1 = "attack Hytos";
        game1.nextPos2 = "run for your life";
        game1.nextPos3 = "";
        game1.nextPos4 = "";
    }

    //MODIFIES: this, ui, and game1
    //EFFECTS: applies chosen weapon's damage to monster HP and continues battle
    // This method references similar code to fit this game's purpose from video (linked)
    // Link:
    // https://www.youtube.com/watch?v=j99EeUjvLVQ&list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV&index=5&ab_channel=RyiSnow
    private void attackMonster() {
        int attack = player.getWeapon().damageChooser();
        String misfire = misfire(attack);
        game1.monster.loseHP(attack);
        if (game1.monster.getHP() > 0) {
            ui.mainTextArea.setText(misfire + "\n" + player.getName() + " attacks " + game1.monster.getName()
                    + "\n for " + attack + " HP"
                    + "\n" + game1.monster.getName() + " has " + game1.monster.getHP() + " HP remaining");
            hytosFightSlots();
        } else if (game1.monster.getHP() < 1) {
            ui.mainTextArea.setText(misfire + "\n" + player.getName() + " attacks " + game1.monster.getName()
                    + "\n for " + attack + " HP"
                    + "\n" + game1.monster.getName() + " has " + game1.monster.getHP() + " HP remaining \n"
                    + player.getName() + " is victorious!!!");
            ui.option1.setText("move forwards");
            ui.option2.setText("");
            ui.option3.setText("");
            ui.option4.setText("");

            game1.nextPos1 = "move forwards";
            game1.nextPos2 = "";
            game1.nextPos3 = "";
            game1.nextPos4 = "";
        }
    }

    // MODIFIES: this
    //EFFECTS: produces message if player's weapon damage is zero
    private String misfire(int i) {
        if (i == 0) {
            return "Oops, " + player.getName() + " dropped " + player.getName() + "'s weapon";
        } else {
            return "";
        }
    }

    // MODIFIES: this, ui, game1
    // EFFECTS: sets all options to fighting Hytos the troll scenario
    private void hytosFightSlots() {
        ui.option1.setText("fight Hytos");
        ui.option2.setText("run for your life");
        ui.option3.setText("");
        ui.option4.setText("");

        game1.nextPos1 = "fight Hytos";
        game1.nextPos2 = "run for your life";
        game1.nextPos3 = "";
        game1.nextPos4 = "";
    }

    // MODIFIES: this, ui, and game1
    // EFFECTS: progresses player after defeating Hytos the troll
    private void victory() {
        HytosTooth hytosTooth = new HytosTooth();
        player.addItem(hytosTooth);
        ui.mainTextArea.setText("You were able to injure " + game1.monster.getName() + " but they managed to get away."
                + "\n However, you were able to snag a tooth, a troll tooth, which is extremely valuable \n"
                + hytosTooth.getName() + ", a collectible item, was added to "
                + player.getName() + "'s inventory");
        ui.option1.setText(">");
        ui.option2.setText("");
        ui.option3.setText("");
        ui.option4.setText("");

        game1.nextPos1 = "limp away rich";
        game1.nextPos2 = "";
        game1.nextPos3 = "";
        game1.nextPos4 = "";
    }


    // MODIFIES: this, ui, game1
    // EFFECTS: displays message when monster additionally encounters Hytos the Troll
    private void monsterEncounterAdditional() {
        game1.monster.resetHp();
        String trollYell = " Oye " + player.getName() + " ,didn't I tell ya already, no one crosses Canyon Bridge!!!";
        ui.mainTextArea.setText("A troll appears and yells" + trollYell
                + "the troll starts to charge at you");
        hytosFightSlots();
    }

    // MODIFIES: this, ui, and game1
    // EFFECTS: displays options if player chooses to run away from Hytos the Troll
    private void returnToCrossroad() {
        ui.mainTextArea.setText(player.getName() + " returns to a crossroad");
        ui.option1.setText("head to Blue River");
        ui.option2.setText("head to Stoole Rock");
        ui.option3.setText("head to Canyon Bridge");
        ui.option4.setText("");
        game1.nextPos1 = "head to Blue River";
        game1.nextPos2 = "head to Stoole Rock";
        game1.nextPos3 = "head to Canyon Bridge";
        game1.nextPos4 = "";
        game1.currPos = "return to crossroad";
    }

    // MODIFIES: this, ui, and game1
    // EFFECTS: displays message when monster initially encounters Hytos the Troll
    private void monsterEncounterInitial() {
        ui.mainTextArea.setText("A troll appears and yells" + " Oye " + player.getName()
                + " , no one crosses Hytos's Canyon Bridge!!!"
                + "\n The troll starts to charge at you");
        hytosFightSlots();
    }

    //MODIFIES: this, ui, and game1
    //EFFECTS: prints out writing found at Stoole Rock location provides
    // return command to return to crossroad
    private void readTheWriting() {
        ui.mainTextArea.setText("The writing reads, “The path to Boregon Trail will have no avail "
                + "unless you are willing to face challenges from folk tale");
        ui.option1.setText(">");
        ui.option2.setText("");
        ui.option3.setText("");
        ui.option4.setText("");

        game1.nextPos1 = game1.currPos;
        game1.nextPos2 = "";
        game1.nextPos3 = "";
        game1.nextPos4 = "";
    }

    //MODIFIES: this, ui, and game1
    //EFFECTS: takes player to Stoole Rock location from crossroad and
    // displays available options
    private void stooleRock() {
        ui.mainTextArea.setText(player.getName() + " comes across a place called Stoole Rock"
                + "\n" + " and see a writing engraved on the wall");
        ui.option1.setText("read the writing");
        ui.option2.setText(game1.currPos);
        ui.option3.setText("");
        ui.option4.setText("");

        game1.nextPos1 = "read the writing";
        game1.nextPos2 = game1.currPos;
        game1.nextPos3 = "";
        game1.nextPos4 = "";
    }

    //MODIFIES: this, ui, and game1
    //EFFECTS: takes player to the Blue River location and display available options
    private void blueRiver() {
        ui.mainTextArea.setText(player.getName() + " finds an extremely blue river"
                + "\n" + player.getName() + " feels a bit thirsty");
        ui.option1.setText("drink the water");
        ui.option2.setText(game1.currPos);
        ui.option3.setText("");
        ui.option4.setText("");

        game1.nextPos1 = "decideToDrinkWater";
        game1.nextPos2 = game1.currPos;
        game1.nextPos3 = "";
        game1.nextPos4 = "";

    }

    //MODIFIES: this, ui, and game1
    //EFFECTS: displays player's decision and provides player with next option
    private void decideToDrinkMysteryWater() {
        ui.mainTextArea.setText(player.getName() + " has decided to drink the water");
        ui.option1.setText(">");
        ui.option2.setText("");
        ui.option3.setText("");
        ui.option4.setText("");

        game1.nextPos1 = "drink the water";
        game1.nextPos2 = "";
        game1.nextPos3 = "";
        game1.nextPos4 = "";
    }


    //MODIFIES:this, ui, and game1
    //EFFECTS: player drinks mystery water that can increase or decrease
    // the players HP by 2 heart points, then displays option to return to crossroad
    // Also, player can die if heartpoints get to low, so end command is also implemented
    private void drinkMysteryWater() {
        MysteryWater mysteryWater = new MysteryWater();
        int b = mysteryWater.getHeartValue();
        if (b == 2) {
            player.addHP(b);
            ui.mainTextArea.setText(player.getName() + " has gained 2 HP"
                    + "\n" + player.getName() + " has " + player.getPlayerHP() + " HP remaining");
            ui.hpNumberLabel.setText("" + player.getPlayerHP());
            setReturnToPreviousSpot();
        } else if (b == -2) {
            player.loseHP(-b);
            if (lowPlayerHP()) {
                ui.mainTextArea.setText(player.getName() + " has perished"
                        + "\n Game Over!");
                setPlayerDeath();
            } else {
                ui.mainTextArea.setText(player.getName() + " has lost 2 HP"
                        + "\n" + player.getName() + " has " + player.getPlayerHP() + " HP remaining");
                ui.hpNumberLabel.setText("" + player.getPlayerHP());
                setReturnToPreviousSpot();
            }
        }
    }

    //MODIFIES: this, ui, and game1
    //EFFECTS: displays player's decision and provides player with next option
    // to return to currPos
    private void setReturnToPreviousSpot() {
        ui.option1.setText(">");
        ui.option2.setText("");
        ui.option3.setText("");
        ui.option4.setText("");

        game1.nextPos1 = game1.currPos;
        game1.nextPos2 = "";
        game1.nextPos3 = "";
        game1.nextPos4 = "";
    }

    // MODIFIES: this
    // EFFECTS: returns true if player HP is too low to continue
    private boolean lowPlayerHP() {
        return player.getPlayerHP() <= 0;
    }

    //MODIFIES: this, ui, and game1
    //EFFECTS: adds immortal potion to player's inventory if they can afford, and
    // displays advancement options
    private void purchaseImmortalPotion() {
        ImmortalPotion ip = new ImmortalPotion();
        if (player.getWallet() < ip.getCost()) {
            ui.mainTextArea.setText("The wizards laughs at you and calls you a peasant, then disappears"
                    + "\n never to be seen again");
        } else {
            player.spendMoney(ip.getCost());
            player.addItem(ip);
            ui.mainTextArea.setText("The wizards says ahh, you have come to your senses \n"
                    + ip.getName() + " has been added to your inventory \n"
                    + player.getName() + " has " + player.getWallet() + " dollars in your wallet remaining");
        }
        ui.option1.setText(">");
        ui.option2.setText("");
        ui.option3.setText("");
        ui.option4.setText("");

        game1.nextPos1 = "head to the crossroad";
        game1.nextPos2 = "";
        game1.nextPos3 = "";
        game1.nextPos4 = "";
    }

    // MODIFIES: this, ui, and game1
    // EFFECTS: starts wizard event after player decides to move forwards
    private void startTheTrail() {
        ui.mainTextArea.setText("While " + player.getName() + " is walking, a wizard pops out of nowhere."
                + "\n The wizard says for just 3 dollars they will give a magic potion that will "
                + "\nkeep you nourished and safe for the rest of your trip."
                + "\n You have " + player.getWallet() + " dollars in your wallet remaining");

        ui.option1.setText("Buy potion");
        ui.option2.setText("Leave it alone");
        ui.option3.setText("");
        ui.option4.setText("");

        game1.nextPos1 = "Buy the supposed potion";
        game1.nextPos2 = "Leave the thing alone";
        game1.nextPos3 = "";
        game1.nextPos4 = "";
    }

    // MODIFIES: this, ui, and game1
    // EFFECTS: this is an Easter egg kill command, that will kill the player in a variety of ways
    private void waitForSaviour() {

        int value = 0;
        Random b = new Random();
        for (int i = 0; i < 5; i++) {
            value = 1 + b.nextInt(3);
            setPlayerDeath();
        }
        if (value == 1) {
            ui.mainTextArea.setText("So " + player.getName() + " has chosen to wait for a saviour to arrive. "
                    + "\n Unfortunately " + player.getName() + " was trampled by a horse");
        } else if (value == 2) {
            ui.mainTextArea.setText("So " + player.getName() + " has chosen to wait for a saviour to arrive. "
                    + "\n Unfortunately " + player.getName() + " was trampled by a carriage going at high speeds");
        } else if (value == 3) {
            ui.mainTextArea.setText("So " + player.getName() + " has chosen to wait for a saviour to arrive. "
                    + "\n Unfortunately " + player.getName()
                    + " sat on a a rock and then was killed by a sinkhole that appeared"
                    + " out of nowhere");
        } else {
            ui.mainTextArea.setText("So " + player.getName() + " has chosen to wait for a saviour to arrive. "
                    + "\n Unfortunately " + player.getName() + " was trampled by a horse");
        }
    }

    // MODIFIES: this, ui, and game1
    // EFFECTS: adds Kentucky Rifle Weapon to player inventory, sets it as default weapon
    // and displays available options
    private void setupWeaponKentucky() {
        KentuckyRifle kentuckyRifle = new KentuckyRifle();
        player.addItem(kentuckyRifle);
        player.spendMoney(kentuckyRifle.getCost());
        ui.weaponNameLabel.setText("Kentucky Rifle");
        ui.mainTextArea.setText(kentuckyRifle.getName() + " has been added to your inventory"
                + " and it has been set as your default weapon. \n"
                + " You have " + player.getWallet() + " dollars in your wallet remaining \n"
                + player.getName() + " is a cautious person but they need to get to Oregon City \n"
                + " for their inheritance of 10,000 dollars. Instead of taking the long copyrighted trail "
                + "littered with dysentery, " + player.getName() + " decides to take the mystical, \n"
                + "treacherous trail with an ironic name, the Boregon Trail.");

        ui.option1.setText("start trail");
        ui.option2.setText("wait");
        ui.option3.setText("");
        ui.option4.setText("");

        game1.nextPos1 = "start the trail";
        game1.nextPos2 = "wait for saviour to arrive";
        game1.nextPos3 = "";
        game1.nextPos4 = "";
    }

    // MODIFIES: this, ui, and game1
    // EFFECTS: adds Knife Weapon to player inventory, sets it as default weapon
    //  and displays available options
    private void setupWeaponKnife() {
        Knife knife = new Knife();
        player.addItem(knife);
        player.spendMoney(knife.getCost());
        ui.weaponNameLabel.setText(player.getWeaponName());
        ui.mainTextArea.setText(knife.getName() + " has been added to your inventory"
                + " and it has been set as your default weapon. \n"
                + " You have " + player.getWallet() + " dollars in your wallet remaining \n"
                + player.getName() + " is a cautious person but they need to get to Oregon City \n"
                + " for their inheritance of 10,000 dollars. Instead of taking the long copyrighted trail "
                + "littered with dysentery, " + player.getName() + " decides to take the mystical, \n"
                + "treacherous trail with an ironic name, the Boregon Trail.");

        ui.option1.setText("start trail");
        ui.option2.setText("wait");
        ui.option3.setText("");
        ui.option4.setText("");

        game1.nextPos1 = "start the trail";
        game1.nextPos2 = "wait for saviour to arrive";
        game1.nextPos3 = "";
        game1.nextPos4 = "";
    }


    // MODIFIES: this, ui, and game1
    // EFFECTS: adds Sword Weapon to player inventory, sets it as default weapon
    //  and displays available options
    private void setupWeaponSword() {
        Sword sword = new Sword();
        player.addItem(sword);
        player.spendMoney(sword.getCost());
        ui.weaponNameLabel.setText(player.getWeaponName());
        ui.mainTextArea.setText(sword.getName() + " has been added to your inventory"
                + " and it has been set as your default weapon. \n"
                + " You have " + player.getWallet() + " dollars in your wallet remaining \n"
                + player.getName() + " is a cautious person but they need to get to Oregon City \n"
                + " for their inheritance of 10,000 dollars. Instead of taking the long copyrighted trail "
                + "littered with dysentery, " + player.getName() + " decides to take the mystical, \n"
                + "treacherous trail with an ironic name, the Boregon Trail.");

        ui.option1.setText("start trail");
        ui.option2.setText("wait");
        ui.option3.setText("");
        ui.option4.setText("");

        game1.nextPos1 = "start the trail";
        game1.nextPos2 = "wait for saviour to arrive";
        game1.nextPos3 = "";
        game1.nextPos4 = "";
    }






}
