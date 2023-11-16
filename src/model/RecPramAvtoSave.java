package model;

import controller.Center;

import javax.swing.plaf.synth.ColorType;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RecPramAvtoSave {
    public RecPramAvtoSave() {
        prop = new HashMap<>();
    }

    private static HashMap<Props, String> prop;
public void addProperty(Props proper, String data){
 prop.put(proper,data);
}
    public static void saveProp() {
        StringBuffer bf = new StringBuffer();
        File father = new File(new File(RecPramAvtoSave.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent());
        File jarDir =  new File(father + File.separator +"prop");
        if(!jarDir.exists()) {
            try {
                jarDir.createNewFile();
            } catch (IOException e) {
                File tempJarDir = new File(System.getProperty("user.home") + File.separator + ".VKGraber");
                tempJarDir.mkdirs();
                jarDir = new File(System.getProperty("user.home") + File.separator + ".VKGraber" + File.separator + "prop");
                if (!jarDir.exists()) {
                    try {
                        jarDir.createNewFile();
                    } catch (IOException ex) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
        for (Map.Entry<Props,String> entry: prop.entrySet()){
            bf.append(entry.getKey().getTitle()).append(":").append(entry.getValue());
            bf.append(System.lineSeparator());
        }

        try (PrintWriter out = new PrintWriter(new FileWriter(jarDir, StandardCharsets.UTF_8,false))) {
            out.print(bf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void createProperty(){
    if(Center.getMenuAvtosave().getState()) {
        prop.put(Props.IS_AVTO_SAVE, "true");
        prop.put(Props.VK_URL,Center.getBP().getBigVkPanel().getVk1().getVkUrlPath());
        prop.put(Props.PATH_IMG,Center.getBP().getBigVkPanel().getVk2().getPuth().getPath());
        prop.put(Props.PATH_TXT,Center.getBP().getBigVkPanel().getVk3().getPathTxt().getPath());
        prop.put(Props.IS_FTP_ON, String.valueOf(Center.getBP().getBigFtpPanel().getFtpPanel1().getOn().isSelected()));
        if(Center.getBP().getBigFtpPanel().getFtpPanel1().getOn().isSelected()){
            prop.put(Props.PATH_FTP,Center.getBP().getBigFtpPanel().getFtpPanel2().getPathFtp().getText());
            prop.put(Props.LOGIN_FTP, Center.getBP().getBigFtpPanel().getFtpPanel3().getLoginFtp().getText());
            prop.put(Props.PASSWORD_FTP, String.valueOf(Center.getBP().getBigFtpPanel().getFtpPanel4().getPass().getPassword()));
            prop.put(Props.DOMAIN_FTP, Center.getBP().getBigFtpPanel().getFtpPanel5().getDomainFTP().getText());
        }
        prop.put(Props.TEXT_EDITOR,Center.getBP().getBigTextPanel().getTextPanel1().getTextInput().getText());
        prop.put(Props.IS_CREATED_FOLDER, String.valueOf(Center.getBP().getBigTextPanel().getButtonTextPanel().isCreatDir()));
    }
    }
    public static void readProperty(){
        File father = new File(new File(RecPramAvtoSave.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent());
        File jarDir =  new File(father + File.separator +"prop");
        if(jarDir.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(jarDir));
                String line = reader.readLine();
                while (line != null) {
                    loadPropToFrame(line);
                    line = reader.readLine();

                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static void loadPropToFrame(String line){
        String[] tempMass = new String[2];
        String [] temp = line.split(":",2);
        for (int i = 0; i < temp.length; i++){
            tempMass[i] = temp[i];
        }
            if (tempMass[0].equals(Props.VK_URL.getTitle())) {
                Center.getBP().getBigVkPanel().getVk1().getVkUrlTextArea().setText(tempMass[1] == null ? "" : tempMass [1]);
            } else if (tempMass[0].equals(Props.PATH_IMG.getTitle())) {
                Center.getBP().getBigVkPanel().getVk2().setPathDirectory(tempMass[1] == null ? "" : tempMass [1]);
            } else if (tempMass[0].equals(Props.PATH_TXT.getTitle())) {
                Center.getBP().getBigVkPanel().getVk3().setPathDirectory(tempMass[1] == null ? "" : tempMass [1]);
            } else if (tempMass[0].equals(Props.IS_FTP_ON.getTitle())) {
                if (tempMass[1].equals("true")) {
                    Center.getBP().getBigFtpPanel().getFtpPanel1().getOn().setSelected(true);
                } else {
                    Center.getBP().getBigFtpPanel().getFtpPanel1().getOff().setSelected(true);
                }
            } else if (tempMass[0].equals(Props.PATH_FTP.getTitle())) {
                Center.getBP().getBigFtpPanel().getFtpPanel2().getPathFtp().setText(tempMass[1] == null ? "" : tempMass [1]);
            } else if (tempMass[0].equals(Props.LOGIN_FTP.getTitle())) {
                Center.getBP().getBigFtpPanel().getFtpPanel3().getLoginFtp().setText(tempMass[1] == null ? "" : tempMass [1]);
            } else if (tempMass[0].equals(Props.PASSWORD_FTP.getTitle())) {
                Center.getBP().getBigFtpPanel().getFtpPanel4().getPass().setText(tempMass[1] == null ? "" : tempMass [1]);
            } else if (tempMass[0].equals(Props.DOMAIN_FTP.getTitle())) {
                Center.getBP().getBigFtpPanel().getFtpPanel5().getDomainFTP().setText(tempMass[1] == null ? "" : tempMass [1]);
            } else if (tempMass[0].equals(Props.TEXT_EDITOR.getTitle())) {
                Center.getBP().getBigTextPanel().getTextPanel1().getTextInput().setText(tempMass[1] == null ? "" : tempMass [1]);
            } else if (tempMass[0].equals(Props.IS_CREATED_FOLDER.getTitle())) {
                if (tempMass[1].equals("true")) {
                    Center.getBP().getBigTextPanel().getButtonTextPanel().getCreatDir().setSelected(true);
                } else {
                    Center.getBP().getBigTextPanel().getButtonTextPanel().getCreatDir().setSelected(false);
                }
            }else  if(tempMass[0].equals(Props.IS_AVTO_SAVE.getTitle())){
                if (tempMass[1].equals("true")) {
                    Center.getMenuAvtosave().setSelected(true);
                } else {
                    Center.getMenuAvtosave().setSelected(false);
                }
            }
    }
    public static void clearProp(){
        File father = new File(new File(RecPramAvtoSave.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent());
        File jarDir =  new File(father + File.separator +"prop");
        if(!jarDir.exists()) {
            try {
                jarDir.createNewFile();
            } catch (IOException e) {
                File tempJarDir = new File(System.getProperty("user.home") + File.separator + ".VKGraber");
                tempJarDir.mkdirs();
                jarDir = new File(System.getProperty("user.home") + File.separator + ".VKGraber" + File.separator + "prop");
                if (!jarDir.exists()) {
                    try {
                        jarDir.createNewFile();
                    } catch (IOException ex) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
        try (PrintWriter out = new PrintWriter(new FileWriter(jarDir, StandardCharsets.UTF_8,false))) {
            out.print("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
