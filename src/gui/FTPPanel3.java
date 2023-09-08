package gui;

import controller.TabAdapter;

import javax.swing.*;
import java.awt.*;

public class FTPPanel3 extends JPanel {
    private JTextArea loginFtp;
    public FTPPanel3(){
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        setLayout(layout);
        add(new JLabel("Login FTP"));
        loginFtp = new JTextArea(1,30);
        loginFtp.addKeyListener(new TabAdapter());
        loginFtp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(loginFtp);

    }

    public JTextArea getLoginFtp() {
        return loginFtp;
    }

}
