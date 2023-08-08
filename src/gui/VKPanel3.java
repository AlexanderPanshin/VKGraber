package gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class VKPanel3 extends JPanel {
    JTextArea pathTxtArea;
    public VKPanel3() {
        FlowLayout layout = new FlowLayout();
        //layout.setHgap(30);
        layout.setAlignment(FlowLayout.LEFT);
        setLayout(layout);
        add(new JLabel("PATH TXT"));
        pathTxtArea = new JTextArea(1,30);
        pathTxtArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(pathTxtArea);
        JButton browsePathButton = new JButton("Browse");
        add(browsePathButton);
    }
    public File getPathTxt(){
        return new File(pathTxtArea.getText());
    }
}
