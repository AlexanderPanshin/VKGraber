package gui;

import javax.swing.*;
import java.awt.*;

public class TextPanel1 extends JPanel {
    JTextArea textInput;
    public TextPanel1() {
        //JScrollPane scrollPane = new JScrollPane();
        //scrollPane.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        setLayout(new GridLayout(1,1));
        textInput = new JTextArea();
        //textInput.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        //scrollPane.add(textInput);
        textInput.setBorder(BorderFactory.createTitledBorder("Text editor"));
        add(textInput);
    }
}
