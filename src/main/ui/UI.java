package ui;

import model.Player;

import javax.swing.*;
import java.awt.*;

public class UI {


    JFrame window;
    JPanel titleNamePanel;
    JPanel startButtonPanel;
    JLabel titleNameLabel;
    JPanel mainTextPanel;
    JPanel choiceButtonPanel;
    JPanel playerPanel;
    JPanel inputPanel;
    JPanel namePanel;
    JPanel inventoryPanel;
    JLabel inputLabel;
    JLabel hpLabel;
    JLabel hpNumberLabel;
    JLabel weaponLabel;
    JLabel weaponNameLabel;
    JButton startButton;
    JButton option1;
    JButton option2;
    JButton option3;
    JButton option4;
    JButton enterButton;
    JButton inventoryButton;
    JButton itemButton1;
    JButton itemButton2;
    JButton itemButton3;
    JButton itemButton4;
    JButton itemButton5;
    JTextArea mainTextArea;
    JTextField nameInput;
    String inventoryStatus;
    Player player;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 40);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 20);

    public void setPlayer(Player player) {
        this.player = player;
    }



    InventoryHandler inventoryHandler = new InventoryHandler(this);

    public void createVisualUI(ChoiceHandler c) {
        //WINDOW
        setWindowInitial();


        // TITLE SCREEN
        setTitleScreen();
        setStartButton(c);

        window.add(titleNamePanel);
        window.add(startButtonPanel);

        // GAME SCREEN
        setMainTextPanel();
        window.add(mainTextPanel);
        setMainTextArea();
        setChoiceButtonPanel();
        setChoiceButtonPanel();
        window.add(choiceButtonPanel);

        setOption1(c);
        setOption2(c);
        setOption3(c);
        setOption4(c);
        setInventory(inventoryHandler);
        setPlayerPanel();
        setHpLabel();
        setHpNumberLabel();
        setWeaponLabel();
        setWeaponNameLabel();
        setInputScreen(c);

        window.setVisible(true);
    }

    public void setInputScreen(ChoiceHandler c) {
        inputPanel = new JPanel();
        inputPanel.setBounds(15, 250, 500, 100);
        inputPanel.setBackground(Color.black);
        inputLabel = new JLabel("Please enter your name:");
        inputLabel.setForeground(Color.white);
        inputLabel.setFont(normalFont);
        inputPanel.add(inputLabel);
        window.add(inputPanel);

        namePanel = new JPanel();
        namePanel.setBounds(150, 450, 500, 50);
        namePanel.setBackground(Color.black);
        namePanel.setLayout(new GridLayout(1, 2));

        nameInput = new JTextField();
        namePanel.add(nameInput);

        enterButton = new JButton("ENTER");
        enterButton.setForeground(Color.black);
        enterButton.addActionListener(c);
        enterButton.setActionCommand("enter");
        enterButton.setFocusPainted(false);
        namePanel.add(enterButton);

        window.add(namePanel);

    }


    public void setChoiceButtonPanel() {
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 380, 300, 175);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(5, 1));
    }

    public void setMainTextPanel() {
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
    }

    public void setMainTextArea() {
        mainTextArea = new JTextArea("This is the main text area");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);
    }

    public void setStartButton(ChoiceHandler c) {
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(c);
        startButton.setActionCommand("start");
        startButtonPanel.add(startButton);
    }

    public void setWindowInitial() {
        //WINDOW
        window = new JFrame();
        window.setSize(900, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
    }

    public void setTitleScreen() {
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 300);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("BOREGON TRAIL");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
    }

    public void setOption1(ChoiceHandler c) {
        option1 = new JButton("option1");
        option1.setBackground(Color.black);
        option1.setForeground(Color.white);
        option1.setFont(normalFont);
        option1.setFocusPainted(false);
        option1.addActionListener(c);
        option1.setActionCommand("choice1");
        choiceButtonPanel.add(option1);
    }

    public void setOption2(ChoiceHandler c) {
        option2 = new JButton("option2");
        option2.setBackground(Color.black);
        option2.setForeground(Color.white);
        option2.setFont(normalFont);
        option2.setFocusPainted(false);
        option2.addActionListener(c);
        option2.setActionCommand("choice2");
        choiceButtonPanel.add(option2);
    }

    public void setOption3(ChoiceHandler c) {
        option3 = new JButton("option3");
        option3.setBackground(Color.black);
        option3.setForeground(Color.white);
        option3.setFont(normalFont);
        option3.setFocusPainted(false);
        option3.addActionListener(c);
        option3.setActionCommand("choice3");
        choiceButtonPanel.add(option3);
    }

    public void setOption4(ChoiceHandler c) {
        option4 = new JButton("option4");
        option4.setBackground(Color.black);
        option4.setForeground(Color.white);
        option4.setFont(normalFont);
        option4.setFocusPainted(false);
        option4.addActionListener(c);
        option4.setActionCommand("choice4");
        choiceButtonPanel.add(option4);
    }

    public void setInventory(InventoryHandler inventoryHandler) {
        inventoryButton = new JButton("Inventory");
        inventoryButton.setBackground(Color.black);
        inventoryButton.setForeground(Color.white);
        inventoryButton.setFont(normalFont);
        inventoryButton.setFocusPainted(false);
        inventoryButton.addActionListener(inventoryHandler);
        inventoryButton.setActionCommand("inventoryButton");
        choiceButtonPanel.add(inventoryButton);

        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(550, 350, 200, 200);
        inventoryPanel.setBackground(Color.black);
        inventoryPanel.setLayout(new GridLayout(5, 1));
        window.add(inventoryPanel);

        itemButton1 = new JButton();
        itemButton1.setBackground(Color.black);
        itemButton1.setForeground(Color.white);
        itemButton1.setFont(normalFont);
        itemButton1.setFocusPainted(false);
        itemButton1.addActionListener(inventoryHandler);
        itemButton1.setActionCommand("item1");
        inventoryPanel.add(itemButton1);

        itemButton2 = new JButton();
        itemButton2.setBackground(Color.black);
        itemButton2.setForeground(Color.white);
        itemButton2.setFont(normalFont);
        itemButton2.setFocusPainted(false);
        itemButton2.addActionListener(inventoryHandler);
        itemButton2.setActionCommand("item2");
        inventoryPanel.add(itemButton2);

        itemButton3 = new JButton();
        itemButton3.setBackground(Color.black);
        itemButton3.setForeground(Color.white);
        itemButton3.setFont(normalFont);
        itemButton3.setFocusPainted(false);
        itemButton3.addActionListener(inventoryHandler);
        itemButton3.setActionCommand("item3");
        inventoryPanel.add(itemButton3);

        itemButton4 = new JButton();
        itemButton4.setBackground(Color.black);
        itemButton4.setForeground(Color.white);
        itemButton4.setFont(normalFont);
        itemButton4.setFocusPainted(false);
        itemButton4.addActionListener(inventoryHandler);
        itemButton4.setActionCommand("item4");
        inventoryPanel.add(itemButton4);

        itemButton5 = new JButton();
        itemButton5.setBackground(Color.black);
        itemButton5.setForeground(Color.white);
        itemButton5.setFont(normalFont);
        itemButton5.setFocusPainted(false);
        itemButton5.addActionListener(inventoryHandler);
        itemButton5.setActionCommand("item5");
        inventoryPanel.add(itemButton5);

        inventoryPanel.setVisible(false);
    }

    public void setPlayerPanel() {
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 690, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        window.add(playerPanel);
    }

    public void setHpLabel() {
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
    }

    public void setHpNumberLabel() {
        hpNumberLabel = new JLabel();
        hpNumberLabel.setFont(normalFont);
        hpNumberLabel.setForeground(Color.white);
        playerPanel.add(hpNumberLabel);
    }

    public void setWeaponLabel() {
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);
    }

    public void setWeaponNameLabel() {
        weaponNameLabel = new JLabel();
        weaponNameLabel.setFont(normalFont);
        weaponNameLabel.setForeground(Color.white);
        playerPanel.add(weaponNameLabel);
    }
}
