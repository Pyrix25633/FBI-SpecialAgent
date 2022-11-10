package net.pyrix25633.ncis.gui;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        super();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawRect(100, 100, 200, 200);
    }
}