package controller;

import gui.BasePanel;
import gui.BigFtpPanel;
import model.FTPConnect;
import model.FileManager;
import model.ParsPage;

public class Center {
    private static  ContVkPanel vkPanel;
    private static FileManager fm;
    private static ParsPage pp;
    private static BasePanel bp;
    private static BigFtpPanel bfp;
    private static FTPConnect ftpConnect;

    public static void addContVk(ContVkPanel v){
        vkPanel = v;
    }
    public static void addFM (FileManager fileManager){
        fm = fileManager;
    }
    public static void addPp (ParsPage parsPage){
        pp = parsPage;
    }
    public static void addBasePanel(BasePanel basePanel){
        bp = basePanel;
    }
    public static void addBftp(BigFtpPanel bigFtpPanel){
        bfp = bigFtpPanel;
    }
    public static void addFtpConn(FTPConnect connect){
        ftpConnect = connect;
    }

    public static FTPConnect getFtpConnect() {
        return ftpConnect;
    }

    public static BigFtpPanel getBfp() {
        return bfp;
    }

    public static BasePanel getBP(){
        return bp;
    }
    public static ParsPage getPp(){
        return pp;
    }

}
