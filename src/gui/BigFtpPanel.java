package gui;

import controller.Center;
import controller.FTPButtonGroupThread;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BigFtpPanel extends JPanel {
    private FTPPanel1 ftpPanel1;
    private FTPPanel2 ftpPanel2;
    private FTPPanel3 ftpPanel3;
    private FTPPanel4 ftpPanel4;
    private FTPPanel5 ftpPanel5;
    private FTPPanel6 ftpPanel6;
    public BigFtpPanel() {
        TitledBorder titleBorder = new TitledBorder(new LineBorder(Color.BLACK),"FTP Options");//BorderFactory.createTitledBorder("FTP Options");
        setBorder(titleBorder);
        setLayout(new GridLayout(6,1));
        ftpPanel1 = new FTPPanel1();
        ftpPanel2 = new FTPPanel2();
        ftpPanel3 = new FTPPanel3();
        ftpPanel4 = new FTPPanel4();
        ftpPanel5 = new FTPPanel5();
        ftpPanel6 = new FTPPanel6();
        add(ftpPanel1);
        add(ftpPanel2);
        add(ftpPanel3);
        add(ftpPanel4);
        add(ftpPanel5);
        add(ftpPanel6);
        Center.addBftp(this);
        new FTPButtonGroupThread().startThread();
    }
    public BigFtpPanel getBigFtpPanel(){
        return this;
    }

    public FTPPanel1 getFtpPanel1() {
        return ftpPanel1;
    }

    public FTPPanel2 getFtpPanel2() {
        return ftpPanel2;
    }

    public FTPPanel3 getFtpPanel3() {
        return ftpPanel3;
    }

    public FTPPanel4 getFtpPanel4() {
        return ftpPanel4;
    }

    public FTPPanel5 getFtpPanel5() {
        return ftpPanel5;
    }

    public FTPPanel6 getFtpPanel6() {
        return ftpPanel6;
    }
}
