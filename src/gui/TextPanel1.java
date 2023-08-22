package gui;

import javax.swing.*;
import java.awt.*;

public class TextPanel1 extends JPanel {
    JTextArea textInput;
    public TextPanel1() {
        setLayout(new GridLayout(1,1));
        textInput = new JTextArea();
        textInput.setBorder(BorderFactory.createTitledBorder("Text editor"));
        textInput.setLineWrap(true);
        textInput.setWrapStyleWord(true);
        ScrollPane sp = new ScrollPane();
        sp.add(textInput);
        add(sp);
    }

    public JTextArea getTextInput() {
        return textInput;
    }
}
