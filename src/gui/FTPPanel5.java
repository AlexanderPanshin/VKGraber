package gui;

import javax.swing.*;
import java.awt.*;

public class FTPPanel5 extends JPanel {
    public FTPPanel5() {
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        setLayout(layout);
        add(new JLabel("Domain FTP"));
        JTextArea pathImgArea = new JTextArea(1,29);
        pathImgArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(pathImgArea);
    }
}
