package gui;

import javax.swing.*;
import java.awt.*;

public class FTPPanel1 extends JPanel {
private ButtonGroup group;
private JRadioButton on;
private JRadioButton off;

    public FTPPanel1() {
        group = new ButtonGroup();
        setLayout(new FlowLayout(FlowLayout.LEFT));
        on = new JRadioButton("On",false);
        off = new JRadioButton("Off",true);
        group.add(on);
        group.add(off);
        add(new JLabel("FTP"));
        add(on);
        add(off);
    }

    public ButtonGroup getGroup() {
        return group;
    }

    public JRadioButton getOn() {
        return on;
    }

    public JRadioButton getOff() {
        return off;
    }
}
