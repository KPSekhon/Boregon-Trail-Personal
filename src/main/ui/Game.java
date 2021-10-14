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
    // EFFECTS: completes command chosen by user
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
        }
    }

    private void lookAtInventory() {
        System.out.println("You have the following items in your inventory");
        for (int i = 0; i < player.getInventorySize(); i++) {
            System.out.println(player.getInventoryItem(i).getName());
        }
        inventoryChecker();
        userInput();
    }

    private void inventoryChecker() {
        if (player.getInventoryItem(1).getHeartValue() == 0) {
            nextPosition1 = "";
        } else {
            nextPosition1 = "use " + player.getInventoryItem(1).getName();
        }
        if (player.getInventoryItem(2).getHeartValue() == 0) {
            nextPosition2 = "";
        } else {
            nextPosition2 = "use " + player.getInventoryItem(2).getName();
        }
        if (player.getInventoryItem(3).getHeartValue() == 0) {
            nextPosition3 = "";
        } else {
            nextPosition3 = "use " + player.getInventoryItem(3).getName();
        }
        if (player.getInventoryItem(4).getHeartValue() == 0) {
            nextPosition4 = "";
        } else {
            nextPosition4 = "use " + player.getInventoryItem(4).getName();
        }
        nextPosition5 = position;
        userInput();
    }

    private void fightMonster() {
        int monsterAttack = monster.attackChooser();
        player.loseHP(monsterAttack);
        System.out.println(monster.getName() + " attacks"
                + player.getName() + " for" + monsterAttack + " HP");
        System.out.println(player.getName() + " has " + player.getPlayerHP() + " HP remaining");
        nextPosition1 = "attack Hytos";
        nextPosition2 = "run for your life";
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "";
        userInput();
    }


    private void monsterEncounterInitial() {
        String trollYell = " Oye " + player.getName() + " , no one crosses Hytos's Canyon Bridge!!!";
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

    private void monsterEncounterAdditional() {
        monster.resetHp();
        String trollYell = " Oye " + player.getName() + " ,didn't I tell ya already, no one crosses Canyon Bridge!!!";
        System.out.println("A troll appears and yells" + trollYell
                + "the troll starts to charge at you");
        nextPosition1 = "fight the troll";
        nextPosition2 = "run for your life";
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "";
        userInput();
    }

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
        nextPosition1 = position;
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "";
        userInput();
    }

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

    private void userInput() {
        showChoices();
        String command;
        command = in.nextLine();
        processChoice(command);
    }

    private void startTheTrail() {
        System.out.println("While " + player.getName() + " is walking, a wizard pops out of nowhere."
                + "\n The wizard says for just 4 dollars they will give a magic potion that will "
                + "\nkeep you nourished and safe for the rest of your trip.");
        System.out.println("\t You have " + player.getWallet() + " dollars in your wallet remaining");
        nextPosition1 = "Buy the supposed potion";
        nextPosition2 = "Leave the thing alone";
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "";
        userInput();
    }

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

    private void setupName() {
        String command;
        System.out.println("What would you like to name your character?");
        command = in.next();
        this.player = new Player(command);
    }

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



