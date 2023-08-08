package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BigFtpPanel extends JPanel {
    public BigFtpPanel() {
        TitledBorder titleBorder = new TitledBorder(new LineBorder(Color.BLACK),"FTP Options");//BorderFactory.createTitledBorder("FTP Options");
        setBorder(titleBorder);
        setLayout(new GridLayout(6,1));
        add(new FTPPanel1());
        add(new FTPPanel2());
        add(new FTPPanel3());
        add(new FTPPanel4());
        add(new FTPPanel5());
        add(new FTPPanel6());
    }
}
