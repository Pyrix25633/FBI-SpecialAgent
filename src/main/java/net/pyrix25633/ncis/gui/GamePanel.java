package net.pyrix25633.ncis.gui;

import net.pyrix25633.ncis.Main;
import net.pyrix25633.ncis.client.KeyboardListener;
import net.pyrix25633.ncis.component.Component;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        super();
        addKeyListener(new KeyboardListener());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Component c : Main.gameServer.getWorld()) {
            c.paintComponent(g);
        }
    }
}