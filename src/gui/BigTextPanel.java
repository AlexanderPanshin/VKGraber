package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BigTextPanel extends JPanel {
    public BigTextPanel() {
        setBorder(new TitledBorder(new LineBorder(Color.BLACK),"Text Options"));
        setLayout(new GridLayout(2,1));
        add(new TextPanel1());
        add(new TextPanel2());
    }
}
