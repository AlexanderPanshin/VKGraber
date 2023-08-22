package controller;

import gui.TextPanel2;
import gui.VKPanel1;
import gui.VKPanel2;
import gui.VKPanel3;

import java.io.File;

public class ContVkPanel {
    private VKPanel1 vkUrl;
    private VKPanel2 imgPath;
    private VKPanel3 txtPath;
    private TextPanel2 informPanel;
    public static boolean flagReady = false;

    public ContVkPanel(VKPanel1 vkPanel1, VKPanel2 vkPanel2, VKPanel3 vkPanel3,TextPanel2 textPanel2) {
        vkUrl = vkPanel1;
        imgPath = vkPanel2;
        txtPath = vkPanel3;
        informPanel = textPanel2;
    }

    public String getVkUrl(){
        return vkUrl.getVkUrlPath();
    }

    public File getImgPath(){
        return imgPath.getPuth();
    }
    public TextPanel2 getInformPanel(){
        return informPanel;
    }
}
