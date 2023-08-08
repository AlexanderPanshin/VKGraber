package gui;

import javax.swing.*;
import java.awt.*;

public class BasePanel extends JFrame {
    public BasePanel() {
        super("VKGraber");
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        add(new BigVkPanel());
        add(new BigFtpPanel());
        add(new BigTextPanel());
    }
}
