package controller;

import gui.BasePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;


public class BrovsImgListiner implements ActionListener {
    private JPanel bp;
    private static boolean count = true;
    private static JFileChooser fileChooser;

    public BrovsImgListiner(JPanel bp) {
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
                int result = fileChooser.showOpenDialog(bp);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    // Обработка выбранного файла
                }
            }
        });
        fileChooserThread.start();
    }
}
