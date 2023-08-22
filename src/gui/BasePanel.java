package gui;

import controller.Center;
import controller.ContVkPanel;

import javax.swing.*;
import java.awt.*;

public class BasePanel extends JFrame {
    private BigVkPanel bigVkPanel;
    private BigFtpPanel bigFtpPanel;
    private BigTextPanel bigTextPanel;
    public BasePanel() {
        super("VKGraber");
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        bigVkPanel = new BigVkPanel(this);
        bigFtpPanel = new BigFtpPanel();
        bigTextPanel = new BigTextPanel();
        add(bigVkPanel);
        add(bigFtpPanel);
        add(bigTextPanel);
        Center.addBasePanel(this);
    }

    public BigVkPanel getBigVkPanel() {
        return bigVkPanel;
    }

    public BigFtpPanel getBigFtpPanel() {
        return bigFtpPanel;
    }

    public BigTextPanel getBigTextPanel() {
        return bigTextPanel;
    }
}
