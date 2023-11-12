package model;

import controller.Center;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.Path;

public class FileManager {
    private int conterImg = 0;
    private ParsPage pp;
    private String fileNamePath;
    public FileManager(ParsPage parsPage) {
        pp = parsPage;
    }

    public void crateDirectory(){
        if(Center.getBP().getBigTextPanel().getButtonTextPanel().isCreatDir()) {
            File newDirectory = new File(pp.getVkPanel().getImgPath().getAbsolutePath() + File.separator + pp.getEnNameToPath());
            newDirectory.mkdirs();
            fileNamePath = newDirectory.getAbsolutePath() + File.separator;
        } else {
            fileNamePath = pp.getVkPanel().getImgPath().getAbsolutePath()+File.separator;
        }
        for(String s : pp.getUrlImage()){
            recImage(s);
        }
        if(pp.getUrlImage().isEmpty()){
            recImage("https://mygemorr.ru/noImage200.png");
        }

        recText(new File(fileNamePath+File.separator+pp.getEnNameToPath()+".txt"));

    }
    public void recImage(String url){
        try{
            String fileName = fileNamePath + pp.getEnNameToPath() + "img" + conterImg + ".jpg";
            conterImg++;
            String website;
            if(!url.contains("https")) {
                StringBuilder sb = new StringBuilder(url);
                sb.insert(4, "s");
                website = sb.toString();
            }else website = url;

            URL urll = new URL(website);
            InputStream inputStream = urll.openStream();
            OutputStream outputStream = new FileOutputStream(fileName);
            byte[] buffer = new byte[2048];

            int length = 0;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            inputStream.close();
            outputStream.close();
            if (Center.getFtpConnect() != null && FTPConnect.isFTPon()){
                Center.getFtpConnect().ftpConn(new File(fileName));
            }
            if (conterImg == 1){
                cutImage();
            }

        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    public void cutImage(){
        try {
            if(!pp.getUrlImage().isEmpty()) {
                File file = new File(fileNamePath + pp.getEnNameToPath() + "img" + 0 + ".jpg");
                BufferedImage image = ImageIO.read(file);
                int x = image.getWidth();
                int y = image.getHeight();
                int min = x > y ? y : x;
                image = image.getSubimage(0, 0, min, min);
                ImageIO.write(image, "JPG", new File(fileNamePath + pp.getEnNameToPath() + "img" + "cut" + ".jpg"));

            }else System.out.println("Нет фотокарточек кутер не нужен");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void recText(File f){
        try(FileWriter writer = new FileWriter(f, false))
        {
            writer.write(Center.getPp().getOverText());
            if (Center.getFtpConnect() != null && FTPConnect.isFTPon()){
                String temp;
                if (Center.getBP().getBigTextPanel().getButtonTextPanel().isCreatDir()) {
                    for (int i = 0; i < pp.getUrlImage().size(); i++) {
                        writer.write(System.lineSeparator());
                        temp = Center.getBfp().getFtpPanel5().getDomainFTP().getText() + Center.getBfp().getFtpPanel2().getPathFtp().getText() + Center.getPp().getEnNameToPath() + "/"  + pp.getEnNameToPath() + "img" + i + ".jpg";
                        writer.write(temp);
                    }
                } else {
                    for (int i = 0; i < pp.getUrlImage().size(); i++) {
                        writer.write(System.lineSeparator());
                        temp = Center.getBfp().getFtpPanel5().getDomainFTP().getText() + Center.getBfp().getFtpPanel2().getPathFtp().getText() + Center.getPp().getEnNameToPath() + pp.getEnNameToPath() + "img" + i + ".jpg";
                        writer.write(temp);
                    }
                }
            }else {//если ftp  выключен
                for (String s:Center.getPp().getUrlImage()//перебераем массив урлов
                     ) {
                    writer.write(System.lineSeparator());
                    writer.write("<img src=\""+s+"\" alt=\"альтернативный текст\">");//Дописываем адреса с тегом ИМГ в текстовый файл
                }
            }
            writer.flush();
            writer.close();
            if (Center.getFtpConnect() != null && FTPConnect.isFTPon()){
                Center.getFtpConnect().ftpConn(f);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
