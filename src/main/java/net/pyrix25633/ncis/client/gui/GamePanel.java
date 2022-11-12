package net.pyrix25633.ncis.client.gui;

import net.pyrix25633.ncis.Main;
import net.pyrix25633.ncis.component.Component;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GamePanel() {
        super();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Component c : Main.gameServer.getWorld()) {
            c.paintComponent(g);
        }
    }
}