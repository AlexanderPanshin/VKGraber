package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class BigVkPanel extends JPanel {
    private VKPanel1 vk1;
    private VKPanel2 vk2;
    private VKPanel3 vk3;
    private VKPanel4 vk4;
    public BigVkPanel(BasePanel bp) {
        setLayout(new GridLayout(4,1));
        setBorder(new TitledBorder(new LineBorder(Color.BLACK),"VKOptions"));
        vk1 = new VKPanel1();
        vk2 = new VKPanel2();
        vk3 = new VKPanel3();
        vk4 = new VKPanel4(bp);
        add(vk1);
        add(vk2);
        add(vk3);
        add(vk4);
    }

    public VKPanel1 getVk1() {
        return vk1;
    }

    public VKPanel2 getVk2() {
        return vk2;
    }

    public VKPanel3 getVk3() {
        return vk3;
    }

    public VKPanel4 getVk4() {
        return vk4;
    }
}
