package gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Objects;

public class VKPanel1 extends JPanel {
    private JTextArea vkUrlTextArea;
    public VKPanel1() {
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.LEFT);
        setLayout(layout);
        add(new JLabel("VK URL     "));
        vkUrlTextArea = new JTextArea(1,30);
        vkUrlTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(vkUrlTextArea);
    }
    public String getVkUrlPath() {
        return vkUrlTextArea.getText();
    }

    public JTextArea getVkUrlTextArea() {
        return vkUrlTextArea;
    }
    public boolean isEmpathy(){
        if(vkUrlTextArea==null){
            return true;
        }
        if (Objects.equals(vkUrlTextArea.getText(), "")) return true;
        else return false;
    }
}
