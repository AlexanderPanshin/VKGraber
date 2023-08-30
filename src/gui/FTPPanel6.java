package gui;

import controller.ButtonListiner;

import javax.swing.*;

public class FTPPanel6 extends JPanel {
    private JButton save;
    private JLabel connectStatus;
    public FTPPanel6() {
        save = new JButton("SAVE");
        save.setActionCommand("FTP");
        save.addActionListener(new ButtonListiner());
        connectStatus = new JLabel("Соединение не установлено");
        add(save);
        add(connectStatus);
    }

    public JButton getSave() {
        return save;
    }

    public JLabel getConnectStatus() {
        return connectStatus;
    }
}
