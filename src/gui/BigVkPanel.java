package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BigVkPanel extends JPanel {
    public BigVkPanel() {
        setLayout(new GridLayout(4,1));
        setBorder(new TitledBorder(new LineBorder(Color.BLACK),"VKOptions"));
        add(new VKPanel1());
        add(new VKPanel2());
        add(new VKPanel3());
        add(new VKPanel4());
    }
}
