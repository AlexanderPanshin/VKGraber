package model;

import controller.Center;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

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
            System.out.println("Downloading File From: " + website);

            URL urll = new URL(website);
            InputStream inputStream = urll.openStream();
            OutputStream outputStream = new FileOutputStream(fileName);
            byte[] buffer = new byte[2048];

            int length = 0;
            System.out.println("Запись  " + fileName);
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            inputStream.close();
            outputStream.close();

        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    public void cutImage(){
        try {
            if(!pp.getUrlImage().isEmpty()) {
                BufferedImage image = ImageIO.read(pp.getVkPanel().getImgPath());
                int x = image.getWidth() / 2 - 100;
                int y = image.getHeight() / 2 - 100;
                if (image.getHeight() > 400) {
                    System.out.println("Start big cuter");
                    image = image.getSubimage(x, y, 300, 300);
                    ImageIO.write(image, "JPG", new File(pp.getVkPanel().getImgPath().toString().replace("img", "cuter")));
                } else {
                    System.out.println("Start small cuter");
                    image = image.getSubimage(x, y, 200, 200);
                    ImageIO.write(image, "JPG", new File(pp.getVkPanel().getImgPath().toString().replace("img", "cuter")));
                }
            }else System.out.println("Нет фотокарточек кутер не нужен");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void recText(File f){
        try(FileWriter writer = new FileWriter(f, false))
        {
            writer.write(Center.getPp().getOverText());
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
