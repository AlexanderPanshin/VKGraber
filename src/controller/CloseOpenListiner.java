package controller;

import gui.MenuAvtoSave;
import model.RecPramAvtoSave;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CloseOpenListiner implements WindowListener {
    @Override
    public void windowOpened(WindowEvent e) {
        RecPramAvtoSave.readProperty();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if (Center.getMenuAvtosave().getState()) {
            new RecPramAvtoSave();
            RecPramAvtoSave.createProperty();
            RecPramAvtoSave.saveProp();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
