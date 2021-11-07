package ui;

import model.Player;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.net.URL;

// This UI Class is heavily (extremely heavily) dependent on the linked playlist
// https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
// The playlist was used to learn how Java Swing works and how to implement
// functionality

// This class creates and implements the Visual UI of the game

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
    JPanel persistencePanel;
    JLabel inputLabel;
    JLabel hpLabel;
    JLabel hpNumberLabel;
    JLabel weaponLabel;
    JLabel weaponNameLabel;
    JButton startButton;
    JButton restartButton;
    JButton option1;
    JButton option2;
    JButton option3;
    JButton option4;
    JButton enterButton;
    JButton inventoryButton;
    JButton saveButton;
    JButton loadButton;
    JButton itemButton1;
    JButton itemButton2;
    JButton itemButton3;
    JButton itemButton4;
    JButton itemButton5;
    JTextArea mainTextArea;
    JTextField nameInput;
    String inventoryStatus;
    JProgressBar progressBar;
    Player player;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 40);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 20);
    private JLabel label;
    private JProgressBar bar;
    private JFrame frame;
    private Border border;
    private ImageIcon icon;

    //MODIFIES: this, game1
    // EFFECTS: sets up player for the game
    public void setPlayer(Player player) {
        this.player = player;
    }

    //EFFECTS: creates basic UI
    public UI() {
    }

    //MODIFIES: this
    //EFFECTS: creates loading screen, then switches to main game when bar is filled
    public void loader() {
        splash();
        if (getBarTimer() == 100) {
            frame.setVisible(false);
        }
    }


    // MODIFIES: this
    // EFFECTS: sets up inventory Handler
    InventoryHandler inventoryHandler = new InventoryHandler(this);

    // MODIFIES: this
    // EFFECTS: sets up Visual UI
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist was used extensively to determine how to implement the code
    public void createVisualUI(ChoiceHandler c) {
        loader();
        //WINDOW
        setWindowInitial();


        // TITLE SCREEN
        setTitleScreen();
        setStartButton(c);


        // GAME SCREEN
        setMainTextPanel();
        window.add(mainTextPanel);
        setMainTextArea();
        setChoiceButtonPanel();
        setChoiceButtonPanel();

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
        setPersistencePanel(c);
        setupProgressBar();

        window.setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: sets up player panel
    public void setupProgressBar() {
        progressBar = new JProgressBar();
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setVisible(false);
        playerPanel.add(progressBar);
    }

    // MODIFIES: this
    // EFFECTS: sets up the name Input Screen
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


    //MODIFIES: this
    //EFFECTS: sets up choice button panel
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in determining how to use JSwing functionality
    public void setChoiceButtonPanel() {
        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 380, 300, 175);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(5, 1));
        window.add(choiceButtonPanel);
    }

    //MODIFIES: this
    //EFFECTS: sets up main text panel
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in determining how to use JSwing functionality
    public void setMainTextPanel() {
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
    }

    //MODIFIES: this
    //EFFECTS: sets up Persistence Panel
    public void setPersistencePanel(ChoiceHandler c) {
        persistencePanel = new JPanel();
        persistencePanel.setBounds(50, 380, 180, 100);
        persistencePanel.setBackground(Color.black);
        persistencePanel.setLayout(new GridLayout(3, 1));
        window.add(persistencePanel);
        setupLoadAndSave(c);
        setupRestartButton(c);
    }

    //MODIFIES: this
    //EFFECTS: sets up save and load buttons
    public void setupLoadAndSave(ChoiceHandler c) {
        saveButton = new JButton("SAVE");
        saveButton.setBackground(Color.black);
        saveButton.setForeground(Color.white);
        saveButton.setFont(normalFont);
        saveButton.setFocusPainted(false);
        saveButton.addActionListener(c);
        saveButton.setActionCommand("save");
        persistencePanel.add(saveButton);

        loadButton = new JButton("LOAD");
        loadButton.setBackground(Color.black);
        loadButton.setForeground(Color.white);
        loadButton.setFont(normalFont);
        loadButton.setFocusPainted(false);
        loadButton.addActionListener(c);
        loadButton.setActionCommand("load");
        persistencePanel.add(loadButton);
    }

    //MODIFIES: this
    //EFFECTS: setups Restart Button
    public void setupRestartButton(ChoiceHandler c) {
        restartButton = new JButton("NEW GAME");
        restartButton.setBackground(Color.black);
        restartButton.setForeground(Color.white);
        restartButton.setFont(normalFont);
        restartButton.setFocusPainted(false);
        restartButton.addActionListener(c);
        restartButton.setActionCommand("restart");
        persistencePanel.add(restartButton);
        restartButton.setVisible(false);
    }

    //MODIFIES: this
    //EFFECTS: sets up main text area
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in determining how to use JSwing functionality
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

    //MODIFIES: this
    //EFFECTS: sets up start button
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in determining how to use JSwing functionality
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
        window.add(titleNamePanel);
        window.add(startButtonPanel);
    }

    //MODIFIES: this
    //EFFECTS: sets up window
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in determining how to use JSwing functionality
    public void setWindowInitial() {
        window = new JFrame();
        window.setSize(900, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
    }

    //MODIFIES: this
    //EFFECTS: sets up title screen
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in determining how to use JSwing functionality
    public void setTitleScreen() {
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 300);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("BOREGON TRAIL");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
    }

    //MODIFIES: this
    //EFFECTS: sets up first choice
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in determining how to use JSwing functionality
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

    //MODIFIES: this
    //EFFECTS: sets up second choice
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in determining how to use JSwing functionality
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

    //MODIFIES: this
    //EFFECTS: sets up third choice
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in determining how to use JSwing functionality
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

    //MODIFIES: this
    //EFFECTS: sets up fourth choice
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in determining how to use JSwing functionality
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

    //MODIFIES: this
    //EFFECTS: sets up inventory button
    // Source: https://www.youtube.com/watch?v=vW2EV9En6vA&ab_channel=RyiSnow
    public void setInventoryButton(InventoryHandler inventoryHandler) {
        inventoryButton = new JButton("Inventory");
        inventoryButton.setBackground(Color.black);
        inventoryButton.setForeground(Color.white);
        inventoryButton.setFont(normalFont);
        inventoryButton.setFocusPainted(false);
        inventoryButton.addActionListener(inventoryHandler);
        inventoryButton.setActionCommand("inventoryButton");
        choiceButtonPanel.add(inventoryButton);
    }

    //MODIFIES: this
    //EFFECTS: sets up inventory panel
    // Source: https://www.youtube.com/watch?v=vW2EV9En6vA&ab_channel=RyiSnow
    public void setInventoryPanel() {
        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(550, 350, 200, 200);
        inventoryPanel.setBackground(Color.black);
        inventoryPanel.setLayout(new GridLayout(5, 1));
    }

    //MODIFIES: this
    //EFFECTS: sets up inventory item button 1
    // Source: https://www.youtube.com/watch?v=vW2EV9En6vA&ab_channel=RyiSnow
    public void setItemButton1(InventoryHandler inventoryHandler) {
        itemButton1 = new JButton();
        itemButton1.setBackground(Color.black);
        itemButton1.setForeground(Color.white);
        itemButton1.setFont(normalFont);
        itemButton1.setFocusPainted(false);
        itemButton1.addActionListener(inventoryHandler);
        itemButton1.setActionCommand("item1");
        inventoryPanel.add(itemButton1);
    }

    //MODIFIES: this
    //EFFECTS: sets up inventory item button 2
    // Source: https://www.youtube.com/watch?v=vW2EV9En6vA&ab_channel=RyiSnow
    public void setItemButton2(InventoryHandler inventoryHandler) {
        itemButton2 = new JButton();
        itemButton2.setBackground(Color.black);
        itemButton2.setForeground(Color.white);
        itemButton2.setFont(normalFont);
        itemButton2.setFocusPainted(false);
        itemButton2.addActionListener(inventoryHandler);
        itemButton2.setActionCommand("item2");
        inventoryPanel.add(itemButton2);
    }

    //MODIFIES: this
    //EFFECTS: sets up inventory item button 3
    // Source: https://www.youtube.com/watch?v=vW2EV9En6vA&ab_channel=RyiSnow
    public void setItemButton3(InventoryHandler inventoryHandler) {
        itemButton3 = new JButton();
        itemButton3.setBackground(Color.black);
        itemButton3.setForeground(Color.white);
        itemButton3.setFont(normalFont);
        itemButton3.setFocusPainted(false);
        itemButton3.addActionListener(inventoryHandler);
        itemButton3.setActionCommand("item3");
        inventoryPanel.add(itemButton3);
    }

    //MODIFIES: this
    //EFFECTS: sets up inventory item button 4
    // Source: https://www.youtube.com/watch?v=vW2EV9En6vA&ab_channel=RyiSnow
    public void setItemButton4(InventoryHandler inventoryHandler) {
        itemButton4 = new JButton();
        itemButton4.setBackground(Color.black);
        itemButton4.setForeground(Color.white);
        itemButton4.setFont(normalFont);
        itemButton4.setFocusPainted(false);
        itemButton4.addActionListener(inventoryHandler);
        itemButton4.setActionCommand("item4");
        inventoryPanel.add(itemButton4);
    }

    //MODIFIES: this
    //EFFECTS: sets up inventory item button 5
    // Source: https://www.youtube.com/watch?v=vW2EV9En6vA&ab_channel=RyiSnow
    public void setItemButton5(InventoryHandler inventoryHandler) {
        itemButton5 = new JButton();
        itemButton5.setBackground(Color.black);
        itemButton5.setForeground(Color.white);
        itemButton5.setFont(normalFont);
        itemButton5.setFocusPainted(false);
        itemButton5.addActionListener(inventoryHandler);
        itemButton5.setActionCommand("item5");
        inventoryPanel.add(itemButton5);
    }

    //MODIFIES: this
    //EFFECTS: sets up player inventory
    // Source: https://www.youtube.com/watch?v=vW2EV9En6vA&ab_channel=RyiSnow
    public void setInventory(InventoryHandler inventoryHandler) {
        setInventoryButton(inventoryHandler);

        setInventoryPanel();
        window.add(inventoryPanel);

        setItemButton1(inventoryHandler);
        setItemButton2(inventoryHandler);
        setItemButton3(inventoryHandler);
        setItemButton4(inventoryHandler);
        setItemButton5(inventoryHandler);
        inventoryPanel.setVisible(false);
    }

    //MODIFIES: this
    //EFFECTS: sets up player panel
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in determining how to use JSwing functionality
    public void setPlayerPanel() {
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 690, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 5));
        window.add(playerPanel);
    }

    //MODIFIES: this
    //EFFECTS: sets up Hp Label
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in determining how to use JSwing functionality
    public void setHpLabel() {
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);
    }

    //MODIFIES: this
    //EFFECTS: sets up Hp display HpNumberLabel
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in determining how to use JSwing functionality
    public void setHpNumberLabel() {
        hpNumberLabel = new JLabel();
        hpNumberLabel.setFont(normalFont);
        hpNumberLabel.setForeground(Color.white);
        playerPanel.add(hpNumberLabel);
    }

    //MODIFIES: this
    //EFFECTS: sets up Hp display WeaponLabel
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in determining how to use JSwing functionality
    public void setWeaponLabel() {
        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(normalFont);
        weaponLabel.setForeground(Color.white);
        playerPanel.add(weaponLabel);
    }

    //MODIFIES: this
    //EFFECTS: sets up weapon display WeaponNameLabel
    // Source: https://www.youtube.com/playlist?list=PL_QPQmz5C6WVrrmQaIwtaH23Bg8MEd9PV
    // This playlist assisted in determining how to use JSwing functionality
    public void setWeaponNameLabel() {
        weaponNameLabel = new JLabel();
        weaponNameLabel.setFont(normalFont);
        weaponNameLabel.setForeground(Color.white);
        playerPanel.add(weaponNameLabel);
    }

    // Sets up splash loading screen
    //MODIFIES: this
    //EFFECTS: instantiates splash intro loading screen method
    //This resource was used to help make this method -
    //https://www.youtube.com/watch?v=Kmgo00avvEw&ab_channel=BroCode
    public void splash() {
        setupLabel();
        setupLoadingProgressBar();

        setupFrame();
        frame.add(label);
        frame.add(bar);

        fill();

    }


    //MODIFIES: this
    // sets up frame for splash screen
    private void setupFrame() {
        this.frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.getContentPane().setBackground(new Color(0xFFFE94));
        //frame.getContentPane().setBackground(new Color(0x000000));
        frame.setLayout(null);
        frame.setVisible(true);
    }

    //MODIFIES: this
    //sets up progress bar for splash screen
    private void setupLoadingProgressBar() {
        this.bar = new JProgressBar();
        bar.setValue(0);
        bar.setBounds(400, 500, 420, 50);
        bar.setStringPainted(true);
    }

    //MODIFIES: this
    //EFFECTS: sets up label to display image, border and text
    //This resource assisted in making this method:
    //https://stackoverflow.com/questions/149153/loading-animated-gif-from-jar-file-into-imageicon
    //https://stackoverflow.com/questions/16134549/how-to-make-a-splash-screen-for-gui
    private void setupLabel() {
        this.border = BorderFactory.createLineBorder(new Color(0xF3867A));
        URL url = this.getClass().getResource("Dancing_Guy.gif");
        this.icon = new ImageIcon(url);
        //this.icon = new ImageIcon("./ui/soick.jpg");
        this.label = new JLabel();
        label.setText("loading, maybe?");
        label.setFont(normalFont);
        label.setIcon(this.icon);
        label.setBorder(this.border);
        label.setBounds(0, 0, 900, 600);
    }

    //MODIFIES: this
    // EFFECTS: fills the progress bar
    //This resource assisted in making this method:
    //https://stackoverflow.com/questions/16134549/how-to-make-a-splash-screen-for-gui
    //https://stackoverflow.com/questions/149153/loading-animated-gif-from-jar-file-into-imageicon
    public void fill() {
        int max = 110;
        for (int i = 0; i < max; i++) {
            bar.setValue(i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        bar.setString("Done!");
    }

    //EFFECTS: returns current value of bar progress value
    public int getBarTimer() {
        return this.bar.getValue();
    }


}
