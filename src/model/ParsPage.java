package model;

import controller.Center;
import controller.ContVkPanel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class ParsPage {
    private String linkUrl;
    private String ruName;
    private String ruPreiev;
    private String ruContentText;
    private String enNameToPath;
    private String enNameToFile;
    private String overText;
    private String litlePreviev;
    private ContVkPanel vkPanel;
    private ArrayList<String> urlImage = new ArrayList<>();

    public ParsPage(ContVkPanel vkPanel) {
        linkUrl =urlClubCorr(vkPanel.getVkUrl().toString());
        this.vkPanel = vkPanel;
        parseOverText();
        generateEnNameToPath();
        generatePreiev();
        generateLitlePreiev();
        //ruContentText = overText; ? удалить не используеться
        //enNameToFile = enNameToPath + ".txt"; тоже пока не используеться
        parsingUrlImage();
        setInformPanel(overText.length(),urlImage.size());
        Center.addPp(this);
    }

    public ArrayList<String> getUrlImage() {
        return urlImage;
    }

    public String getEnNameToPath() {
        return enNameToPath;
    }
    public ContVkPanel getVkPanel() {
        return vkPanel;
    }

    private void  parseOverText(){
        Document document = null;
        try {
            document = Jsoup.connect(linkUrl).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Elements bodyElement = document.select("div.wall_post_text");
        overText = bodyElement.text();
    }
    private void generatePreiev(){
        if(overText!=null) {
            String preName = overText.split("\\.")[0];
            if (preName.length() < 155) {
                ruPreiev = preName + "...";
            } else {
                StringBuilder sb = new StringBuilder(preName.substring(0, 155));
                sb.append("...");
                ruPreiev = sb.toString();
            }
            }else {
                System.out.println("overText is null");
            }
        }
    private void generateEnNameToPath (){
        String [] mass = overText.split(" ");
        StringBuilder sb = new StringBuilder();
        DateFormat dateFormat = new SimpleDateFormat("dMMyyyy");
        String date = dateFormat.format(Calendar.getInstance().getTime());
        if (mass.length>=1){
            for(int i = 0; i < 1; i++){
                sb.append(translator(mass[i]));
            }
            enNameToPath = sb.toString().trim()+date+"-"+new Random().nextInt(10);
        }else {
            System.out.println("overText is null");
        }
    }
    private void generateLitlePreiev(){
        if(overText!=null){
        String preName = overText.split("\\.")[0];
        if (preName.length() < 55) {
            ruPreiev = preName + "...";
        } else {
            StringBuilder sb = new StringBuilder(preName.substring(0, 55));
            sb.append("...");
            litlePreviev = sb.toString();
        }
    }else

    {
        System.out.println("overText is null");
    }
    }
    public static String translator(String st){
        st = st.toLowerCase();
        char [] charMass = st.toCharArray();
        for(int i = 0; i < charMass.length; i++){
            switch (charMass[i]) {
                case 'а' -> charMass[i] = 'a';
                case 'б' -> charMass[i] = 'b';
                case 'в' -> charMass[i] = 'v';
                case 'г' -> charMass[i] = 'g';
                case 'д' -> charMass[i] = 'd';
                case 'е', 'э' -> charMass[i] = 'e';
                case 'ё', 'о' -> charMass[i] = 'o';
                case 'ж' -> charMass[i] = 'z';
                case 'з' -> charMass[i] = 'z';
                case 'и', 'ы' -> charMass[i] = 'i';
                case 'й' -> charMass[i] = 'i';
                case 'к' -> charMass[i] = 'k';
                case 'л' -> charMass[i] = 'l';
                case 'м' -> charMass[i] = 'm';
                case 'н' -> charMass[i] = 'n';
                case 'п' -> charMass[i] = 'p';
                case 'р' -> charMass[i] = 'r';
                case 'с' -> charMass[i] = 'c';
                case 'т' -> charMass[i] = 't';
                case 'у' -> charMass[i] = 'y';
                case 'ф' -> charMass[i] = 'f';
                case 'х' -> charMass[i] = 'h';
                case 'ц', 'ч' -> charMass[i] = 'c';
                case 'ш', 'щ' -> charMass[i] = 's';
                case 'ъ', 'ь' -> charMass[i] = '_';
                case 'ю' -> charMass[i] = 'u';
                case 'я' -> charMass[i] = 'y';
                case '#', ' ', '!', '%', '.', ',' -> charMass[i] = '1';
            }
        }
        return String.valueOf(charMass);
    }
    private void parsingUrlImage(){
        Document document = null;
        try {
            document = Jsoup.connect(linkUrl).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Elements title = document.select("img.MediaGrid__imageElement");
        if(!title.isEmpty()) {
            for (Element e : title) {
                String urlParse = e.toString();
                urlParse = urlParse.split("src=\"")[1];
                urlParse = urlParse.split("\"")[0];
                urlParse = coorectUrl(urlParse);
                urlImage.add(urlParse);
            }
        }else {
            title = document.select("img.MediaGrid__imageOld");
            for (Element e : title) {
                String urlParse = e.toString();
                urlParse = urlParse.split("src=\"")[1];
                urlParse = urlParse.split("\"")[0];
                urlParse = coorectUrl(urlParse);
                urlImage.add(urlParse);
            }
        }
    }
    private String coorectUrl (String url){
        return url.replaceAll("amp;","");
    }
    private void addPath(){

    }

    private String urlClubCorr(String s){
        if(s.contains("club")) {
            String[] parts = s.split("/club\\d+\\?w=");
            String result = "https://vk.com/" + parts[1];
            if(result.contains("all")){
                result = result.replace("%2Fall","");
            }
            return result;
        }
        return s;
    }

    public String getOverText() {
        return overText;
    }
    private void setInformPanel(int count, int img){
        vkPanel.getInformPanel().changeImgCount(img);
        vkPanel.getInformPanel().changeStrokeCount(count);
    }
}

