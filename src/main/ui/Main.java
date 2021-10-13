package ui;

import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Game();
        boolean alive = true;
        int position = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("What would you like to name your character?");


        GAME:
        while (alive) {
            String input = in.nextLine();
            Player player = new Player(input);
            System.out.println(player.getName() + " is a cautious person but they need to get to Oregon City \n"
                    + " for their inheritance of 10,000 dollars. Instead of taking the long copyrighted trail \n"
                    + "littered with dysentery," + player.getName() + " decides to take the mystical, \n"
                    + "treacherous trail with an ironic name, the Boregon Trail.");
            System.out.println("What would weapon would you like? \n"
                    + "you have " + player.getWallet() + " dollars in your wallet");
            KentuckyRifle kentuckyRifle = new KentuckyRifle();
            Knife knife = new Knife();
            Sword sword = new Sword();
            System.out.println("\t A " + kentuckyRifle.getName() + " costing " + kentuckyRifle.getCost() + " dollars.");
            System.out.println("\t" + knife.getName() + " costing " + knife.getCost() + " dollars.");
            System.out.println("\t" + sword.getName() + " costing " + sword.getCost() + " dollars.");
            position = 1;
            while (position == 1) {
                if (input.equals(kentuckyRifle.getName())) {
                    player.addItem(kentuckyRifle);
                    player.spendMoney(kentuckyRifle.getCost());
                    System.out.println("\t You have" + player.getWallet() + " dollars in your wallet remaining");
                    continue GAME;
                } else if (input.equals(knife.getName())) {
                    player.addItem(knife);
                    player.spendMoney(knife.getCost());
                    System.out.println("\t You have" + player.getWallet() + " dollars in your wallet remaining");
                    continue GAME;
                } else if (input.equals(sword.getName())) {
                    player.addItem(sword);
                    player.spendMoney(sword.getCost());
                    System.out.println("\t You have " + player.getWallet() + " dollars in your wallet remaining");
                    continue GAME;
                } else {
                    System.out.println("You have inputted an invalid command, please try again");
                }
            }

        }
    }
}
