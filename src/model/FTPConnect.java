package model;
import controller.Center;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class FTPConnect {
    private static boolean isFTPon = false;
    private String FTPPath;
    private String loginFtp;
    private char [] passwordFtp;
    private String domenFtp;
    private static boolean isFTPConn = false;

    public FTPConnect(String FTPPath, String loginFtp, char [] passwordFtp, String domenFtp) {
        this.FTPPath = FTPPath;
        this.loginFtp = loginFtp;
        this.passwordFtp = passwordFtp;
        this.domenFtp = domenFtp;
        isFTPon = false;
        isFTPConn = false;
    }

    public static boolean isFTPon() {
        return isFTPon;
    }
    public String isConnect(){
        FTPClient client = new FTPClient();
        try {
            client.connect(domenFtp);
        } catch (IOException e) {
            return "Ошибка домена";
        }
        boolean conn = false;
        try {
            conn = client.login(loginFtp, new String(passwordFtp));
        } catch (IOException e) {
            return "Ошибка соединения";
        }
        if(conn){
            isFTPon = true;
            isFTPConn = true;
            Center.getBP().getBigTextPanel().getButtonTextPanel().getButton().setEnabled(true);
            return "Соединение установленно !";

        }else {
            return "Соединение не установленно !";
        }

    }

    public static boolean isFTPConn() {
        return isFTPConn;
    }

    public static void setIsFTPon(boolean isFTPon) {
        FTPConnect.isFTPon = isFTPon;
    }

    public void setFTPon(boolean FTPon) {
        isFTPon = FTPon;
    }
    public void ftpConn(File filePath) throws IOException {
        FTPClient fClient = new FTPClient();
        FileInputStream fInput = new FileInputStream(filePath);
        String fs;
        fClient.connect(domenFtp);
        fClient.enterLocalPassiveMode();
        fClient.login(loginFtp, new String(passwordFtp));
        if(filePath.toString().contains(".txt")) {
            if (Center.getBP().getBigTextPanel().getButtonTextPanel().isCreatDir()) {
                fs = FTPPath + Center.getPp().getEnNameToPath() + "/" + Center.getPp().getEnNameToPath() + ".txt";
                fClient.makeDirectory(FTPPath + Center.getPp().getEnNameToPath());
            } else {
                fs = FTPPath + Center.getPp().getEnNameToPath() + ".txt";
            }
        }else {
            String [] mass = filePath.toString().split("\\\\");
            if (Center.getBP().getBigTextPanel().getButtonTextPanel().isCreatDir()) {
                fs = FTPPath + Center.getPp().getEnNameToPath() + "/" + mass[mass.length - 1];
                fClient.makeDirectory(FTPPath + Center.getPp().getEnNameToPath());
            } else {
                fs = FTPPath +  mass[mass.length - 1];
            }
        }
        try {

            fClient.storeFile(fs,fInput);
            fClient.logout();
            fClient.disconnect();
        } catch (IOException ex) {
            System.err.println("Error ==== "+ ex);
        }
    }
}
