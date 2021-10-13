package ui;
// This class is to run the game
// very heavily influenced by the Teller App


import model.KentuckyRifle;
import model.Knife;
import model.Player;
import model.Sword;


import java.util.Scanner;

public class Game {
    private Scanner in = new Scanner(System.in);
    String nextPosition1;
    String nextPosition2;
    String nextPosition3;
    String nextPosition4;
    String nextPosition5;
    Player player;

    // EFFECTS: runs the game
    public Game() {
        runGame();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runGame() {
        boolean alive = true;
        String command;

        while (alive) {
            setup();
            command = in.next();
            command = command.toLowerCase();
            showChoices();

            if (command.equals("q")) {
                alive = false;
            } else {
                processChoice(command);
            }
        }
        System.out.println("\n You died");
    }

    // MODIFIES: this
    // EFFECTS: completes command chosen by user
    private void selectPosition(String nextPosition) {
        switch (nextPosition) {
            case "Kentucky Rifle with 4 bullets":
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

    private void setupWeaponKentucky() {
        KentuckyRifle kentuckyRifle = new KentuckyRifle();
        player.addItem(kentuckyRifle);
        player.spendMoney(kentuckyRifle.getCost());
        System.out.println("\t You have" + player.getWallet() + " dollars in your wallet remaining");
        System.out.println(player.getName() + " is a cautious person but they need to get to Oregon City \n"
                + " for their inheritance of 10,000 dollars. Instead of taking the long copyrighted trail \n"
                + "littered with dysentery," + player.getName() + " decides to take the mystical, \n"
                + "treacherous trail with an ironic name, the Boregon Trail.");
        nextPosition1 = "start the trail";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "look at inventory";
    }

    private void setupWeaponKnife() {
        Knife knife = new Knife();
        player.addItem(knife);
        player.spendMoney(knife.getCost());
        System.out.println("\t You have" + player.getWallet() + " dollars in your wallet remaining");
        System.out.println(player.getName() + " is a cautious person but they need to get to Oregon City \n"
                + " for their inheritance of 10,000 dollars. Instead of taking the long copyrighted trail \n"
                + "littered with dysentery," + player.getName() + " decides to take the mystical, \n"
                + "treacherous trail with an ironic name, the Boregon Trail.");
        nextPosition1 = "start the trail";
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "look at inventory";
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
        nextPosition2 = "";
        nextPosition3 = "";
        nextPosition4 = "";
        nextPosition5 = "look at inventory";
    }


    //MODIFIES: this
    //EFFECTS: process user choice
    private void processChoice(String command) {
        switch (command) {
            case "case1":
                selectPosition(nextPosition1);
                break;
            case "case2":
                selectPosition(nextPosition2);
                break;
            case "case3":
                selectPosition(nextPosition3);
                break;
            case "case4":
                selectPosition(nextPosition4);
                break;
            case "case5":
                selectPosition(nextPosition5);
                break;
        }
    }

    // EFFECTS: displays options to player
    private void showChoices() {
        System.out.println("\n You have the following options");
        System.out.println(nextPosition1);
        System.out.println(nextPosition2);
        System.out.println(nextPosition3);
        System.out.println(nextPosition4);
        System.out.println(nextPosition5);
    }

    private void setup() {
        String command;
        System.out.println("What would you like to name your character?");
        command = in.next();
        command = command.toLowerCase();
        this.player = new Player(command);
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
        processChoice(command);
    }
}



