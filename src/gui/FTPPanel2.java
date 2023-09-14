package gui;

import controller.TabAdapter;

import javax.swing.*;
import java.awt.*;

public class FTPPanel2 extends JPanel {
    private JTextArea pathFtp;
    public FTPPanel2() {
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        setLayout(layout);
        add(new JLabel("PATH FTP"));
        pathFtp = new JTextArea(1,30);
        pathFtp.addKeyListener(new TabAdapter());
        pathFtp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pathFtp.getAccessibleContext().setAccessibleDescription("Путь на FTP сервере");
        add(pathFtp);

    }

    public JTextArea getPathFtp() {
        return pathFtp;
    }
}
