package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BigTextPanel extends JPanel {
    private TextPanel1 textPanel1;
    private TextPanel2 textPanel2;
    public BigTextPanel() {
        setBorder(new TitledBorder(new LineBorder(Color.BLACK),"Text Options"));
        setLayout(new GridLayout(2,1));
        textPanel1 = new TextPanel1();
        textPanel2 = new TextPanel2();
        add(textPanel1);
        add(textPanel2);
    }

    public TextPanel1 getTextPanel1() {
        return textPanel1;
    }

    public TextPanel2 getButtonTextPanel() {
        return textPanel2;
    }
}
