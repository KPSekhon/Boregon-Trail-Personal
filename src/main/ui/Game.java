package ui;


import model.*;

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
    Item inventoryItem1 = player.getInventoryItem(0);
    Item inventoryItem2 = player.getInventoryItem(1);
    Item inventoryItem3 = player.getInventoryItem(2);
    Item inventoryItem4 = player.getInventoryItem(3);
    Item inventoryItem5 = player.getInventoryItem(4);
    String position;

    // EFFECTS: runs the game
    public Game() {
        runGame();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    // influenced by TellerApp
    private void runGame() {
        boolean alive = true;
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
        }
    }

    private void lookAtInventory() {
        System.out.println("You have the following items in your inventory");
        for (int i = 0; i < player.getInventorySize(); i++) {
            System.out.println(player.getInventoryItem(i).getName());
        }
        inventoryChecker();
        showChoices();
        String command;
        command = in.next();
        processChoice(command);
    }

    private void inventoryChecker() {
        if (inventoryItem2.getHeartValue() == 0) {
            nextPosition1 = "";
        } else {
            nextPosition1 = "use " + inventoryItem2;
        }
        if (inventoryItem3.getHeartValue() == 0) {
            nextPosition2 = "";
        } else {
            nextPosition2 = "use " + inventoryItem3;
        }
        if (inventoryItem4.getHeartValue() == 0) {
            nextPosition3 = "";
        } else {
            nextPosition3 = "use " + inventoryItem4;
        }
        if (inventoryItem5.getHeartValue() == 0) {
            nextPosition4 = "";
        } else {
            nextPosition4 = "use " + inventoryItem5;
        }
        nextPosition5 = "return";
    }

    private void setupWeaponKentucky() {
        KentuckyRifle kentuckyRifle = new KentuckyRifle();
        player.addItem(kentuckyRifle);
        player.spendMoney(kentuckyRifle.getCost());
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
        showChoices();
        String command;
        command = in.next();
        processChoice(command);
    }

    private void setupWeaponKnife() {
        Knife knife = new Knife();
        player.addItem(knife);
        player.spendMoney(knife.getCost());
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
        showChoices();
        String command;
        command = in.next();
        processChoice(command);
    }

    private void setupWeaponSword() {
        Sword sword = new Sword();
        player.addItem(sword);
        player.spendMoney(sword.getCost());
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
        showChoices();
        String command;
        command = in.next();
        processChoice(command);
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
        System.out.println(player.getName() + " has the following options");
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
        String command;
        System.out.println("What would weapon would you like? \n"
                + "you have " + player.getWallet() + " dollars in your wallet");
        KentuckyRifle kentuckyRifle = new KentuckyRifle();
        Knife knife = new Knife();
        Sword sword = new Sword();
        System.out.println("\t" + kentuckyRifle.getName() + " costing " + kentuckyRifle.getCost() + " dollars.");
        System.out.println("\t" + knife.getName() + " costing " + knife.getCost() + " dollars.");
        System.out.println("\t" + sword.getName() + " costing " + sword.getCost() + " dollars.");
        nextPosition1 = "Kentucky Rifle";
        nextPosition2 = "Knife";
        nextPosition3 = "Sword";
        showChoices();
        command = in.nextLine();
        processChoice(command);
    }
}



