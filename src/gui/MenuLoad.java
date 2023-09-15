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
                    super.getAccessibleContext().setAccessibleDescription("Загрузить");
                } else {
                    super.setEnabled(false);
                    super.setFocusable(true);
                    super.getAccessibleContext().setAccessibleDescription("Не возмоно загрузить, так как ни чего не сохранено");
                }
            }
        });
        isLoadThread.setDaemon(true);
        isLoadThread.start();

    }
}
