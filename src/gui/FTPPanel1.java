package gui;

import javax.swing.*;
import java.awt.*;

public class FTPPanel1 extends JPanel {


    public FTPPanel1() {
        ButtonGroup group = new ButtonGroup();
        setLayout(new FlowLayout(FlowLayout.LEFT));
        JRadioButton on = new JRadioButton("On",false);
        JRadioButton off = new JRadioButton("Off",true);
        group.add(on);
        group.add(off);
        add(new JLabel("FTP"));
        add(on);
        add(off);
    }
}
