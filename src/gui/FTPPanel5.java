package gui;

import controller.TabAdapter;

import javax.swing.*;
import java.awt.*;

public class FTPPanel5 extends JPanel {
    private JTextArea domainFTP;
    public FTPPanel5() {
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        setLayout(layout);
        add(new JLabel("Domain FTP"));
        domainFTP = new JTextArea(1,29);
        domainFTP.addKeyListener(new TabAdapter());
        domainFTP.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        domainFTP.getAccessibleContext().setAccessibleDescription("Доменн FTP сервера");
        add(domainFTP);
    }

    public JTextArea getDomainFTP() {
        return domainFTP;
    }
}
