package controller;

import gui.BasePanel;
import gui.MenuSave;
import model.FTPConnect;
import model.FileManager;
import model.ParsPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

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
            if(Center.getPp()!=null){
            FileManager fm = new FileManager(Center.getPp());
            fm.crateDirectory();}
        } else if (Objects.equals(e.getActionCommand(), "FTP")) {
            Center.addFtpConn(new FTPConnect(Center.getBfp().getFtpPanel2().getPathFtp().getText(), Center.getBfp().getFtpPanel3().getLoginFtp().getText(),
                    Center.getBfp().getFtpPanel4().getPass().getPassword(), Center.getBfp().getFtpPanel5().getDomainFTP().getText()));
            Center.getBfp().getFtpPanel6().getConnectStatus().setText(Center.getFtpConnect().isConnect());
        }else if (Objects.equals(e.getActionCommand(), "Save")) {
            MenuSave.saveProps.setProperty("VK_URL",Center.getBP().getBigVkPanel().getVk1().getVkUrlPath());
            MenuSave.saveProps.setProperty("VK_Path_img",Center.getBP().getBigVkPanel().getVk2().getPuth().getPath());
            MenuSave.saveProps.setProperty("VK_Path_txt",Center.getBP().getBigVkPanel().getVk3().getPathTxt().getPath());
            MenuSave.saveProps.setProperty("FTP_On_Of", String.valueOf(Center.getBP().getBigFtpPanel().getFtpPanel1().getOn().isSelected()));
            if (Center.getBP().getBigFtpPanel().getFtpPanel1().getOn().isSelected()) {
                MenuSave.saveProps.setProperty("Path_Ftp", Center.getBP().getBigFtpPanel().getFtpPanel2().getPathFtp().getText());
                MenuSave.saveProps.setProperty("Login_Ftp", Center.getBP().getBigFtpPanel().getFtpPanel3().getLoginFtp().getText());
                MenuSave.saveProps.setProperty("Password_Ftp", new String(Center.getBP().getBigFtpPanel().getFtpPanel4().getPass().getPassword()));
                MenuSave.saveProps.setProperty("Domain_Ftp", Center.getBP().getBigFtpPanel().getFtpPanel5().getDomainFTP().getText());
            }
                File pathSave = new File(new File("").getAbsolutePath() + File.separator + "temp");
            File fileSave = new File(new File("").getAbsolutePath() + File.separator + "temp" + File.separator + "save.ph");
            pathSave.mkdir();
            try {
                fileSave.createNewFile();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            try {
                MenuSave.saveProps.store(new FileWriter(fileSave), "store to properties file");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }        else if (Objects.equals(e.getActionCommand(), "Load")) {
            FileInputStream fis;
            Properties property = new Properties();

            try {
                fis = new FileInputStream(new File("").getAbsolutePath() + File.separator + "temp" + File.separator + "save.ph");
                property.load(fis);

                Center.getBP().getBigVkPanel().getVk1().getVkUrlTextArea().setText(property.getProperty("VK_URL"));
                Center.getBP().getBigVkPanel().getVk2().setPathDirectory(property.getProperty("VK_Path_img"));
                Center.getBP().getBigVkPanel().getVk3().setPathDirectory(property.getProperty("VK_Path_txt"));
                if(property.getProperty("FTP_On_Of").equals("true")){
                    Center.getBP().getBigFtpPanel().getFtpPanel1().getOn().setSelected(true);
                    Center.getBP().getBigFtpPanel().getFtpPanel2().getPathFtp().setText(property.getProperty("Path_Ftp"));
                    Center.getBP().getBigFtpPanel().getFtpPanel3().getLoginFtp().setText(property.getProperty("Login_Ftp"));
                    Center.getBP().getBigFtpPanel().getFtpPanel4().getPass().setText(property.getProperty("Password_Ftp"));
                    Center.getBP().getBigFtpPanel().getFtpPanel5().getDomainFTP().setText(property.getProperty("Domain_Ftp"));
                }

            } catch (IOException exception) {
                System.err.println("ОШИБКА: Файл свойств отсуствует!");
            }
        }

    }
}
