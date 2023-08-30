package controller;

import gui.BasePanel;
import model.FTPConnect;
import model.FileManager;
import model.ParsPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ButtonListiner implements ActionListener {

    public ButtonListiner() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BasePanel bp = Center.getBP();
        if(Objects.equals(e.getActionCommand(), "Grabber")){
            bp.getBigVkPanel().getVk4().getButtonGrabb().setText("Grabbing ...");
            if(!bp.getBigVkPanel().getVk1().isEmpathy() & !bp.getBigVkPanel().getVk2().isEmpathy()
                    & !bp.getBigVkPanel().getVk3().isEmpathy()){
                ContVkPanel contVkPanel = new ContVkPanel(bp.getBigVkPanel().getVk1(),bp.getBigVkPanel().getVk2(),bp.getBigVkPanel().getVk3(),bp.getBigTextPanel().getButtonTextPanel());
                ParsPage pp = new ParsPage(contVkPanel);
                Center.addContVk(contVkPanel);
                bp.getBigTextPanel().getTextPanel1().getTextInput().setText(pp.getOverText());
                bp.getBigVkPanel().getVk4().getButtonGrabb().setText("OK");
            }
        } else if (Objects.equals(e.getActionCommand(), "SaveText")) {
            FileManager fm = new FileManager(Center.getPp());
            fm.crateDirectory();
        } else if (Objects.equals(e.getActionCommand(), "FTP")) {
            Center.addFtpConn(new FTPConnect(Center.getBfp().getFtpPanel2().getPathFtp().getText(), Center.getBfp().getFtpPanel3().getLoginFtp().getText(),
                    Center.getBfp().getFtpPanel4().getPass().getPassword(), Center.getBfp().getFtpPanel5().getDomainFTP().getText()));
            Center.getBfp().getFtpPanel6().getConnectStatus().setText(Center.getFtpConnect().isConnect());
        }

    }
}
