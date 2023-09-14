package gui;

import controller.ButtonListiner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TextPanel2 extends JPanel {
    JButton button;
    JPanel inform = new JPanel();
    JLabel imgCount;
    JCheckBox creatDir;

    boolean isCreatDir = false;
    JLabel strokCount;
    public TextPanel2() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        button = new JButton("SAVE");
        button.setActionCommand("SaveText");
        button.addActionListener(new ButtonListiner());
        //button.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(button);
        buttonPanel.add(Box.createHorizontalGlue());

        add(buttonPanel);
        imgCount = new JLabel("Колличество картинок - : нет");
        strokCount = new JLabel("Колличество строк - : нет");
        imgCount.setFocusable(true);
        strokCount.setFocusable(true);
        inform.add(imgCount);
        inform.add(strokCount);
        creatDir = new JCheckBox("Создать директорию в папке ");
        creatDir.addItemListener(new ItemListener(){

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == 1 ){
                    isCreatDir = true;
                }else {
                    isCreatDir = false;
                }
            }
        });

        JPanel chckPanel = new JPanel();
        chckPanel.setLayout(new BoxLayout(chckPanel, BoxLayout.LINE_AXIS));
        chckPanel.add(Box.createHorizontalGlue());
        chckPanel.add(creatDir);
        chckPanel.add(Box.createHorizontalGlue());

        add(inform);
        add(chckPanel);
    }
    public void changeImgCount(int i){
        imgCount.setText("Колличество картинок - : " + i);
    }
    public void changeStrokeCount(int i){
        strokCount.setText("Колличество строк - : " + i);
    }

    public boolean isCreatDir() {
        return isCreatDir;
    }

    public JButton getButton() {
        return button;
    }
}
