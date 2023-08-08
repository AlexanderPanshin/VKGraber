package gui;

import javax.swing.*;
import java.awt.*;

public class FTPPanel4 extends JPanel {
    public FTPPanel4() {
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        setLayout(layout);
        add(new JLabel("Password FTP  "));
        JPasswordField pass = new JPasswordField(27);
        pass.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(pass);
    }
}
