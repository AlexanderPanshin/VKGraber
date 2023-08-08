package gui;

import javax.swing.*;
import java.awt.*;

public class FTPPanel3 extends JPanel {
    public FTPPanel3(){
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        setLayout(layout);
        add(new JLabel("Login FTP"));
        JTextArea pathImgArea = new JTextArea(1,30);
        pathImgArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(pathImgArea);

    }
}
