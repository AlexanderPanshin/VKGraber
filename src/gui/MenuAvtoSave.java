package gui;

import model.RecPramAvtoSave;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MenuAvtoSave extends JCheckBoxMenuItem {
    public MenuAvtoSave() {
        super("Авто сохранение");
        super.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(!MenuAvtoSave.super.getState()){
                    RecPramAvtoSave.clearProp();
                }
            }
        });
    }
    public MenuAvtoSave getMenuAvtoSave(){
        return this;
    }
}
