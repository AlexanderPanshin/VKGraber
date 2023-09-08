package gui;

import controller.BrovsDirectory;

import javax.swing.*;
import java.io.File;
import java.nio.file.Path;

public class MenuLoad extends JMenuItem {
    public MenuLoad() {
        super("Загрузить");
        isLoad();
        setActionCommand("Load");
    }
    public void isLoad(){
        Thread isLoadThread = new Thread(() -> {
            while (true) {
                File file = new File(new File("").getAbsolutePath() + File.separator + "temp" + File.separator + "save.ph");
                if (file.exists()) {
                    super.setEnabled(true);
                } else {
                    super.setEnabled(false);
                }
            }
        });
        isLoadThread.setDaemon(true);
        isLoadThread.start();

    }
}
