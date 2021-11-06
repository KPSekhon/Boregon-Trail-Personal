package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputHandler implements ActionListener {

    String name;
    UI ui;

    public InputHandler(UI ui) {
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.name = ui.nameInput.getText();
    }

    public String getName() {
        return this.name;
    }
}
