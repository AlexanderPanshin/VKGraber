package gui;

import controller.ButtonListiner;
import controller.Center;
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
        JMenuBar headMenu = new JMenuBar();
        headMenu.add(createFileMenu());
        setJMenuBar(headMenu);
        Center.addBasePanel(this);
    }
    private JMenu createFileMenu()
    {
        JMenu prorites = new JMenu("Настройки");
        prorites.setMnemonic(KeyEvent.VK_ALT);/
        JMenuItem save = new MenuSave();
        JMenuItem load = new MenuLoad();
        JMenuItem joomlaV4 = new JMenuItem("JoomlaV4");
        save.addActionListener(new ButtonListiner());
        load.addActionListener(new ButtonListiner());
        prorites.add(save);
        prorites.add(load);
        prorites.addSeparator();
        prorites.add(joomlaV4);

        /*open.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println ("ActionListener.actionPerformed : open");
            }
        });*/
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
