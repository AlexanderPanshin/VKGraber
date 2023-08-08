package gui;

import javax.swing.*;
import java.awt.*;

public class FTPPanel2 extends JPanel {
    public FTPPanel2() {
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        setLayout(layout);
        add(new JLabel("PATH FTP"));
        JTextArea pathImgArea = new JTextArea(1,30);
        pathImgArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(pathImgArea);

    }
}
