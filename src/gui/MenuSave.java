package gui;

import javax.swing.*;
import java.util.Properties;

public class MenuSave extends JMenuItem {
    public static Properties saveProps;
    public MenuSave() {
        super("Сохранить");
        saveProps = new Properties();
        setActionCommand("Save");
    }
}
