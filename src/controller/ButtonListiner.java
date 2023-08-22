package controller;

import gui.BasePanel;
import model.FileManager;
import model.ParsPage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListiner implements ActionListener {

    public ButtonListiner() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BasePanel bp = Center.getBP();
        if(e.getActionCommand()=="Grabber"){
            bp.getBigVkPanel().getVk4().getButtonGrabb().setText("Grabbing ...");
            if(!bp.getBigVkPanel().getVk1().isEmpathy() & !bp.getBigVkPanel().getVk2().isEmpathy()
                    & !bp.getBigVkPanel().getVk3().isEmpathy()){
                ContVkPanel contVkPanel = new ContVkPanel(bp.getBigVkPanel().getVk1(),bp.getBigVkPanel().getVk2(),bp.getBigVkPanel().getVk3(),bp.getBigTextPanel().getButtonTextPanel());
                ParsPage pp = new ParsPage(contVkPanel);
                Center.addContVk(contVkPanel);
                bp.getBigTextPanel().getTextPanel1().getTextInput().setText(pp.getOverText());
                bp.getBigVkPanel().getVk4().getButtonGrabb().setText("OK");
            }
        } else if (e.getActionCommand()== "SaveText") {
            FileManager fm = new FileManager(Center.getPp());
            fm.crateDirectory();
        }

    }
}
