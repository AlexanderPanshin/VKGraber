package controller;

import gui.VKPanel2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class BrovsDirectoryListiner implements ActionListener {
    private JPanel bp;
    private static boolean count = true;
    private static JFileChooser fileChooser;

    public BrovsDirectoryListiner(JPanel bp) {
        this.bp=bp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* Вся эта херня с низу написанна для того
        * что в некоторых версиях Джавы и железа
        * Чойсер открываеться 30 лет. И когда пользователь
        * 100 раз нажмет на кнопку что бы не открылось 100 чойсеров */
        Thread fileChooserThread = new Thread(() -> {
            if (fileChooser == null&&count) {
                count=false;
                fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showOpenDialog(bp);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    BrovsDirectory vk2 = (BrovsDirectory) bp;
                    vk2.setPathDirectory(selectedFile.getAbsolutePath());
                    fileChooser = null;
                    count = true;
                }
                if (result == JFileChooser.CANCEL_OPTION){
                    fileChooser = null;
                    count = true;
                }
            }//Надо подумать что делать с потоком Exception while removing reference.
        });
        fileChooserThread.start();
    }
}
