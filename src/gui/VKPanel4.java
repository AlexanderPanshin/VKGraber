package gui;

import controller.ButtonListiner;
import controller.ContVkPanel;

import javax.swing.*;

public class VKPanel4 extends JPanel {
    JLabel label;
    JButton buttonGrabb;
    public VKPanel4(BasePanel bp) {
        buttonGrabb = new JButton("Grabbing");
        buttonGrabb.setActionCommand("Grabber");
        buttonGrabb.addActionListener(new ButtonListiner());
        add(buttonGrabb);
        label = new JLabel("Заполните формы выше");
        label.getAccessibleContext().setAccessibleDescription("Заполните формы выше для активации кнопки Grabbing");
        label.setFocusable(true);
        add(label);
        Thread formsThread = new Thread(() -> {
            while(true){
                if(!bp.getBigVkPanel().getVk1().isEmpathy() & !bp.getBigVkPanel().getVk2().isEmpathy()
                        & !bp.getBigVkPanel().getVk3().isEmpathy()){
                    buttonGrabb.setEnabled(true);
                    label.setText("Все заполнено");
                }else {
                    label.setText("Заполните формы выше");
                    buttonGrabb.setEnabled(false);
                }
            }
        });
        formsThread.setDaemon(true);
        formsThread.start();
    }
    public void setLabelVk4(String text){
        label.setText(text);
    }

    public JButton getButtonGrabb() {
        return buttonGrabb;
    }
}
