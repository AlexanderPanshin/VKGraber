package gui;

import controller.BrovsDirectory;
import controller.BrovsDirectoryListiner;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Objects;

public class VKPanel3 extends JPanel implements BrovsDirectory {
    JTextArea pathTxtArea;
    public VKPanel3() {
        FlowLayout layout = new FlowLayout();
        BrovsDirectoryListiner txtListiner = new BrovsDirectoryListiner(this);
        layout.setAlignment(FlowLayout.LEFT);
        setLayout(layout);
        add(new JLabel("PATH TXT"));
        pathTxtArea = new JTextArea(1,30);
        pathTxtArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(pathTxtArea);
        JButton browsePathButton = new JButton("Browse");
        browsePathButton.addActionListener(txtListiner);
        add(browsePathButton);
    }
    public File getPathTxt(){
        return new File(pathTxtArea.getText());
    }

    @Override
    public void setPathDirectory(String text) {
        pathTxtArea.setText(text);
    }
    public boolean isEmpathy(){
        if(pathTxtArea==null){
            return true;
        }
        if (Objects.equals(pathTxtArea.getText(), "")) return true;
        else return false;
    }
}
