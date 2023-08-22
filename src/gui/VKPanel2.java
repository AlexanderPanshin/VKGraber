package gui;

import controller.BrovsDirectory;
import controller.BrovsDirectoryListiner;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Objects;


public class VKPanel2 extends JPanel implements BrovsDirectory {
    JTextArea pathImgArea;
    public VKPanel2() {
        FlowLayout layout = new FlowLayout();
        //layout.setHgap(30);
        BrovsDirectoryListiner brovsDirectoryListiner = new BrovsDirectoryListiner(this);
        layout.setAlignment(FlowLayout.LEFT);
        setLayout(layout);
        add(new JLabel("PATH IMG"));
        pathImgArea = new JTextArea(1,30);
        pathImgArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(pathImgArea);
        JButton browsePathButton = new JButton("Browse");
        browsePathButton.addActionListener(brovsDirectoryListiner);
        add(browsePathButton);
    }
    public File getPuth(){
       return new File(pathImgArea.getText());
    }
    @Override
    public void setPathDirectory(String text) {
        pathImgArea.setText(text);
    }
    public boolean isEmpathy(){
        if(pathImgArea==null){
            return true;
        }
        if (Objects.equals(pathImgArea.getText(), "")) return true;
        else return false;
    }
}
