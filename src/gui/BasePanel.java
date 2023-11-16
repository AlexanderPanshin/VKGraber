package gui;

import controller.ButtonListiner;
import controller.Center;
import controller.CloseOpenListiner;
import controller.ContVkPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class BasePanel extends JFrame {
    private BigVkPanel bigVkPanel;
    private BigFtpPanel bigFtpPanel;
    private BigTextPanel bigTextPanel;
    public BasePanel() {
        super("VKGraber");
        setExtendedState(Frame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        bigVkPanel = new BigVkPanel(this);
        bigFtpPanel = new BigFtpPanel();
        bigTextPanel = new BigTextPanel();
        add(bigVkPanel);
        add(bigFtpPanel);
        add(bigTextPanel);
        Center.addBigTextPanel(bigTextPanel);
        JMenuBar headMenu = new JMenuBar();
        headMenu.add(createFileMenu());
        setJMenuBar(headMenu);
        Center.addBasePanel(this);
        addWindowListener(new CloseOpenListiner());
    }
    private JMenu createFileMenu()
    {
        JMenu prorites = new JMenu("Настройки");
        prorites.setMnemonic(KeyEvent.VK_ALT);
        JMenuItem save = new MenuSave();
        JMenuItem load = new MenuLoad();
        JMenuItem joomlaV4 = new JMenuItem("JoomlaV4");
        JMenuItem autoSave = new MenuAvtoSave();
        Center.addMenuAvtoSave((MenuAvtoSave) autoSave);
        save.addActionListener(new ButtonListiner());
        load.addActionListener(new ButtonListiner());
        prorites.add(save);
        prorites.add(load);
        prorites.addSeparator();
        prorites.add(joomlaV4);
        prorites.addSeparator();
        prorites.add(autoSave);
        return prorites;
    }

    public BigVkPanel getBigVkPanel() {
        return bigVkPanel;
    }

    public BigFtpPanel getBigFtpPanel() {
        return bigFtpPanel;
    }

    public BigTextPanel getBigTextPanel() {
        return bigTextPanel;
    }
}
