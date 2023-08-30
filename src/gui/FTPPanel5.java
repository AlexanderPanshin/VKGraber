package gui;

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
        domainFTP.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(domainFTP);
    }

    public JTextArea getDomainFTP() {
        return domainFTP;
    }
}
