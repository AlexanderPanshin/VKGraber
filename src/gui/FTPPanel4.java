package gui;

import controller.TabAdapter;

import javax.swing.*;
import java.awt.*;

public class FTPPanel4 extends JPanel {
    private JPasswordField pass;
    public FTPPanel4() {
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        setLayout(layout);
        add(new JLabel("Password FTP  "));
        pass = new JPasswordField(27);
        pass.addKeyListener(new TabAdapter());
        pass.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(pass);
    }

    public JPasswordField getPass() {
        return pass;
    }
}
