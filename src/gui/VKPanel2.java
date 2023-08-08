package gui;

import controller.BrovsImgListiner;

import javax.swing.*;
import java.awt.*;
import java.io.File;


public class VKPanel2 extends JPanel {
    JTextArea pathImgArea;
    public VKPanel2() {
        FlowLayout layout = new FlowLayout();
        //layout.setHgap(30);
        BrovsImgListiner brovsImgListiner = new BrovsImgListiner(this);
        layout.setAlignment(FlowLayout.LEFT);
        setLayout(layout);
        add(new JLabel("PATH IMG"));
        pathImgArea = new JTextArea(1,30);
        pathImgArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(pathImgArea);
        JButton browsePathButton = new JButton("Browse");
        browsePathButton.addActionListener(brovsImgListiner);
        add(browsePathButton);
    }
    public File getPuth(){
       return new File(pathImgArea.getText());
    }
}
