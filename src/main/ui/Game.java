package ui;


import model.*;

import java.util.Random;
import java.util.Scanner;

// This class is used to run the game
// very heavily influenced by the Teller App
// https://www.youtube.com/watch?v=j99EeUjvLVQ&list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV&index=5&ab_channel=RyiSnow
// Linked video was used to determine how to implement choices based on chosen actions
// The video also has a heavy influence on this class

public class Game {
    private Scanner in = new Scanner(System.in);
    String nextPosition1;
    String nextPosition2;
    String nextPosition3;
    String nextPosition4;
    String nextPosition5;
    Player player;
    String position;
    Monster monster = new Monster();
    boolean alive = true;

    // EFFECTS: runs the game
    public Game() {
        runGame();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // influenced by TellerApp
    private void runGame() {
        String command;

        while (alive) {
            setupName();
            setupWeapon();
            command = in.nextLine();

            if (command.equals("q")) {
                alive = false;
            } else {
                processChoice(command);
            }
        }
        System.out.println("\n Game Over...");
    }

    // MODIFIES: this
    // EFFECTS: completes command chosen by user to just before crossroad
    // influenced by video (linked)
    private void selectPosition(String nextPosition) {
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
            case "look at inventory":
                lookAtInventory();
                break;
            case "head west":
            case "head to Blue River":
                blueRiver();
                break;
            case "drink the water":
                drinkMysteryWater();
                break;
            case "head east":
            case "head to Stoole Rock":
                stooleRock();
                break;
        }
        selectPositionCanyonBridgeOnwards(nextPosition);
    }

    // MODIFIES: this
    // EFFECTS: completes command chosen by user until end of Monster Battle
    private void selectPositionCanyonBridgeOnwards(String nextPosition) {
        switch (nextPosition) {
            case "head north":
                monsterEncounterInitial();
                break;
            case "read the writing":
                readTheWriting();
                break;
            case "run for your life":
            case "return to crossroad":
                returnToCrossroad();
                break;
            case "head to Canyon Bridge":
                monsterEncounterAdditional();
                break;
            case "fight Hytos":
                fightMonster();
                break;
            case "attack Hytos":
                attackMonster();
                break;
        }
        selectPositionVictoryOnwards(nextPosition);
    }

    // MODIFIES: this
    // EFFECTS: completes command chosen by user to after fighting Monster Battle
    private void selectPositionVictoryOnwards(String nextPosition) {
        switch (nextPosition) {
            case "move forwards":
                victory();
                break;
        }
    }

    //MODIFIES: this
    //EFFECTS: allows user to look at current inventory
    private void lookAtInventory() {
        System.out.println("You have the following items in your inventory");
        for (int i = 0; i < player.getInventorySize(); i++) {
            System.out.println(player.getInventoryItem(i).getName());
        }
        inventoryChecker();
        userInput();
    }

    //MODIFIES: this
    //EFFECTS: allows user to look at current inventory, for items that they have picked up
    // shows empty item slots, for slots that still have items to be added to
    private void inventoryChecker() {
        if (player.getInventoryItem(1) == null) {
            nextPosition1 = "";
        } else {
            nextPosition1 = "use " + player.getInventoryItem(1).getName();
        }
        if (player.getInventoryItem(2) == null) {
            nextPosition2 = "";
        } else {
            nextPosition2 = "use " + player.getInventoryItem(2).getName();
        }
        if (player.getInventoryItem(3) == null) {
            nextPosition3 = "";
        } else {
            nextPosition3 = "use " + player.getInventoryItem(3).getName();
        }
        if (player.getInventoryItem(4) == null) {
            nextPosition4 = "";
        } else {
            nextPosition4 = "use " + player.getInventoryItem(4).getName();
        }
        nextPosition5 = position;
        userInput();
    }

    //MODIFIES: this
    //EFFECTS: the player initiates battle and gets attacked by Hytos the troll
    // if at some point player's HP is too low, ends program
    private void fightMonster() {
        int monsterAttack = monster.attackChooser();
        player.loseHP(monsterAttack);
        System.out.println(monster.getName() + " attacks "
                + player.getName() + " for " + monsterAttack + " HP");
        if (lowPlayerHP()) {
            alive = false;
            processChoice("");
        } else {
            System.out.println(player.getName() + " has " + player.getPlayerHP() + " HP remaining");
            nextPosition1 = "attack Hytos";
            nextPosition2 = "run for your life";
            nextPosition3 = "";
            nextPosition4 = "";
            nextPosition5 = "";
            userInput();
        }
    }

    //MODIFIES: this
    //EFFECTS: applies chosen weapon's damage to monster HP and continues battle
    private void attackMonster() {
        int attack = player.getWeapon().damageChooser();
        System.out.println(player.getName() + " attacks " + monster.getName()
                + "\n for " + attack + " HP");
        monster.loseHP(attack);
        System.out.println(monster.getName() + " has " + monster.getHP() + " HP remaining");
        if (monster.getHP() > 0) {
            nextPosition1 = "fight Hytos";
            nextPosition2 = "run for your life";
            nextPosition3 = "";
            nextPosition4 = "";
            nextPosition5 = "";
            userInput();
        } else if (monster.getHP() < 1) {
            nextPosition1 = "move forwards";
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
            nextPosition5 = "";
            position = "move forwards";
            userInput();
        }
    }

    // MODIFIES: this
    // EFFECTS: progresses player after defeating Hytos the troll
    private void victory() {
        HytosTooth hytosTooth = new HytosTooth();
        System.out.println("You were able to injure " + monster.getName() + " but they managed to get away."
                + "\n However, you were able to snag a tooth, a troll tooth, which is extremely valuable");
        player.addItem(hytosTooth);
        System.out.println(hytosTooth.getName() + ", a collectible item, was added to "
                + player.getName() + "'s inventory");
        nextPosition1 = "limp away rich";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "";
        position = "limp away rich";
    }


    // MODIFIES: this
    // EFFECTS: displays message when monster initially encounters Hytos the Troll
    private void monsterEncounterInitial() {
        System.out.println("A troll appears and yells" + " Oye " + player.getName()
                + " , no one crosses Hytos's Canyon Bridge!!!"
                + "\n The troll starts to charge at you");
        nextPosition1 = "fight Hytos";
        nextPosition2 = "run for your life";
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "";
        userInput();
    }

    // MODIFIES: this
    // EFFECTS: displays message when monster additionally encounters Hytos the Troll
    private void monsterEncounterAdditional() {
        monster.resetHp();
        String trollYell = " Oye " + player.getName() + " ,didn't I tell ya already, no one crosses Canyon Bridge!!!";
        System.out.println("A troll appears and yells" + trollYell
                + "the troll starts to charge at you");
        nextPosition1 = "fight Hytos";
        nextPosition2 = "run for your life";
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "";
        userInput();
    }

    // MODIFIES: this
    // EFFECTS: displays options if player chooses to run away from Hytos the Troll
    private void returnToCrossroad() {
        System.out.println(player.getName() + " returns to a crossroad");
        nextPosition1 = "head to Blue River";
        nextPosition2 = "head to Stoole Rock";
        nextPosition3 = "head to Canyon Bridge";
        nextPosition4 = "look at inventory";
        nextPosition5 = "";
        position = "return to crossroad";
        userInput();
    }

    // MODIFIES: this
    // EFFECTS: displays options when player gets to the crossroad
    private void crossroad() {
        System.out.println(player.getName() + " comes to a crossroad");
        nextPosition1 = "head west";
        nextPosition2 = "head east";
        nextPosition3 = "head north";
        nextPosition4 = "look at inventory";
        nextPosition5 = "";
        position = "return to the crossroad";
        userInput();
    }

    //MODIFIES: this
    //EFFECTS: takes player to the Blue River location and display available options
    private void blueRiver() {
        System.out.println(player.getName() + " finds an extremely blue river"
                + "\n" + player.getName() + " feels a bit thirsty");
        nextPosition1 = "drink the water";
        nextPosition2 = position;
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "";
        userInput();
    }

    //MODIFIES:this
    //EFFECTS: player drinks mystery water that can increase or decrease
    // the players HP by 2 heart points, then displays option to return to crossroad
    // Also, player can die if heartpoints get to low, so end command is also implemented
    private void drinkMysteryWater() {
        MysteryWater mysteryWater = new MysteryWater();
        System.out.println(player.getName() + " has decided to drink the water");
        int b = mysteryWater.getHeartValue();
        if (b == 2) {
            player.loseHP(b);
            System.out.println(player.getName() + " has gained 2 HP"
                    + "\n" + player.getName() + " has " + player.getPlayerHP() + " HP remaining");
        } else if (b == -2) {
            player.loseHP(b);
            System.out.println(player.getName() + " has lost 2 HP"
                    + "\n" + player.getName() + " has " + player.getPlayerHP() + " HP remaining");
        }
        if (lowPlayerHP()) {
            alive = false;
            position = "";
        } else {
            nextPosition1 = position;
            nextPosition2 = "";
            nextPosition3 = "";
            nextPosition4 = "";
            nextPosition5 = "";
            userInput();
        }
    }

    // MODIFIES: this
    // EFFECTS: returns true if player HP is too low to continue
    private boolean lowPlayerHP() {
        if (player.getPlayerHP() <= 0) {
            System.out.println(player.getName() + " has perished");
            return true;
        } else {
            return false;
        }
    }

    //MODIFIES: this
    //EFFECTS: takes player to Stoole Rock location from crossroad and
    // displays available options
    private void stooleRock() {
        System.out.println(player.getName() + " comes across a place called"
                + "\n" + " and see a writing engraved on the wall");
        nextPosition1 = "read the writing";
        nextPosition2 = position;
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "";
        userInput();
    }

    //MODIFIES: this
    //EFFECTS: prints out writing found at Stoole Rock location provides
    // return command to return to crossroad
    private void readTheWriting() {
        System.out.println("The writing reads, “The path to Boregon Trail will have no avail "
                + "unless you are willing to face challenges from folk tale");
        nextPosition1 = position;
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "";
        userInput();
    }


    //MODIFIES: this
    //EFFECTS: adds immortal potion to player's inventory if they can afford, and
    // displays advancement options
    private void purchaseImmortalPotion() {
        ImmortalPotion ip = new ImmortalPotion();
        if (player.getWallet() < ip.getCost()) {
            System.out.println("The wizards laughs at you and calls you a peasant, then disappears"
                    + "\n never to be seen again");
        } else {
            System.out.println("The wizards says ahh, you have come to your senses");
            player.spendMoney(ip.getCost());
            player.addItem(ip);
            System.out.println(ip.getName() + " has been added to your inventory");
            System.out.println("\t You have " + player.getWallet() + " dollars in your wallet remaining");
        }
        nextPosition1 = "head to the crossroad";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "";
        userInput();
    }

    // MODIFIES: this
    // EFFECTS: displays available options, intakes user command,
    // and processes their choices
    private void userInput() {
        showChoices();
        String command;
        command = in.nextLine();
        processChoice(command);
    }

    // MODIFIES: this
    // EFFECTS: starts wizard event after player decides to move forwards
    private void startTheTrail() {
        System.out.println("While " + player.getName() + " is walking, a wizard pops out of nowhere."
                + "\n The wizard says for just 3 dollars they will give a magic potion that will "
                + "\nkeep you nourished and safe for the rest of your trip.");
        System.out.println("\t You have " + player.getWallet() + " dollars in your wallet remaining");
        nextPosition1 = "Buy the supposed potion";
        nextPosition2 = "Leave the thing alone";
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "";
        userInput();
    }

    // MODIFIES: this
    // EFFECTS: adds Kentucky Rifle Weapon to player inventory, sets it as default weapon
    // and displays available options
    private void setupWeaponKentucky() {
        KentuckyRifle kentuckyRifle = new KentuckyRifle();
        player.addItem(kentuckyRifle);
        player.spendMoney(kentuckyRifle.getCost());
        System.out.println(kentuckyRifle.getName() + " has been added to your inventory"
                + "\n and it has been set as your default weapon");
        System.out.println("\t You have " + player.getWallet() + " dollars in your wallet remaining");
        System.out.println(player.getName() + " is a cautious person but they need to get to Oregon City \n"
                + " for their inheritance of 10,000 dollars. Instead of taking the long copyrighted trail \n"
                + "littered with dysentery," + player.getName() + " decides to take the mystical, \n"
                + "treacherous trail with an ironic name, the Boregon Trail.");
        nextPosition1 = "start the trail";
        nextPosition2 = "wait for saviour to arrive";
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "";
        userInput();
    }

    // MODIFIES: this
    // EFFECTS: adds Knife Weapon to player inventory, sets it as default weapon
    //  and displays available options
    private void setupWeaponKnife() {
        Knife knife = new Knife();
        player.addItem(knife);
        player.spendMoney(knife.getCost());
        System.out.println(knife.getName() + " has been added to your inventory"
                + "\n and it has been set as your default weapon");
        System.out.println("\t You have " + player.getWallet() + " dollars in your wallet remaining");
        System.out.println(player.getName() + " is a cautious person but they need to get to Oregon City \n"
                + " for their inheritance of 10,000 dollars. Instead of taking the long copyrighted trail \n"
                + "littered with dysentery," + player.getName() + " decides to take the mystical, \n"
                + "treacherous trail with an ironic name, the Boregon Trail.");
        nextPosition1 = "start the trail";
        nextPosition2 = "wait for saviour to arrive";
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "";
        userInput();
    }

    // MODIFIES: this
    // EFFECTS: this is an easter egg kill command, that will kill the player in a variety of ways
    private void waitForSaviour() {
        System.out.println("So " + player.getName() + " has chosen to wait for a saviour to arrive. Unfortunately");
        int value = 0;
        Random b = new Random();
        for (int i = 0; i < 5; i++) {
            value = 1 + b.nextInt(3);
        }
        if (value == 1) {
            System.out.println(player.getName() + " was trampled by a horse");
        } else if (value == 2) {
            System.out.println(player.getName() + " was trampled by a carriage going at high speeds");
        } else if (value == 3) {
            System.out.println(player.getName() + "sat on a a rock and then was killed by a sinkhole that appeared"
                    + "\n out of nowhere");
        } else {
            System.out.println(player.getName() + " was trampled by a horse");
        }
        alive = false;
    }

    // MODIFIES: this
    // EFFECTS: adds Sword Weapon to player inventory, sets it as default weapon
    //  and displays available options
    private void setupWeaponSword() {
        Sword sword = new Sword();
        player.addItem(sword);
        player.spendMoney(sword.getCost());
        System.out.println(sword.getName() + " has been added to your inventory"
                + "\n and it has been set as your default weapon");
        System.out.println("\t You have " + player.getWallet() + " dollars in your wallet remaining");
        System.out.println(player.getName() + " is a cautious person but they need to get to Oregon City \n"
                + " for their inheritance of 10,000 dollars. Instead of taking the long copyrighted trail \n"
                + "littered with dysentery," + player.getName() + " decides to take the mystical, \n"
                + "treacherous trail with an ironic name, the Boregon Trail.");
        nextPosition1 = "start the trail";
        nextPosition2 = "wait for saviour to arrive";
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "";
        userInput();
    }


    //MODIFIES: this
    //EFFECTS: process user choice
    // influenced by video (linked) and TellerApp
    private void processChoice(String command) {
        if (command.equals(nextPosition1)) {
            selectPosition(nextPosition1);
        } else if (command.equals(nextPosition2)) {
            selectPosition(nextPosition2);
        } else if (command.equals(nextPosition3)) {
            selectPosition(nextPosition3);
        } else if (command.equals(nextPosition4)) {
            selectPosition(nextPosition4);
        } else if (command.equals(nextPosition5)) {
            selectPosition(nextPosition5);
        }
    }


    // EFFECTS: displays options to player
    // influenced by TellerApp and video (linked)
    private void showChoices() {
        System.out.println(player.getName() + " has the following options:");
        System.out.println(nextPosition1);
        System.out.println(nextPosition2);
        System.out.println(nextPosition3);
        System.out.println(nextPosition4);
        System.out.println(nextPosition5);
    }

    // MODIFIES: this
    // EFFECTS: sets up player name
    private void setupName() {
        String command;
        System.out.println("What would you like to name your character?");
        command = in.next();
        this.player = new Player(command);
    }

    // MODIFIES: this
    // EFFECTS: displays weapon choices and takes user input to decide
    // which one is assigned to player as default weapon
    private void setupWeapon() {
        System.out.println("What would weapon would you like? \n"
                + "You have " + player.getWallet() + " dollars in your wallet");
        KentuckyRifle kentuckyRifle = new KentuckyRifle();
        Knife knife = new Knife();
        Sword sword = new Sword();
        System.out.println("\t" + kentuckyRifle.getName() + " costing " + kentuckyRifle.getCost() + " dollars.");
        System.out.println("\t" + knife.getName() + " costing " + knife.getCost() + " dollars.");
        System.out.println("\t" + sword.getName() + " costing " + sword.getCost() + " dollars.");
        nextPosition1 = "Kentucky Rifle";
        nextPosition2 = "Knife";
        nextPosition3 = "Sword";
        nextPosition4 = "";
        nextPosition5 = "";
        userInput();
    }
}



