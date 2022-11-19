package net.pyrix25633.ncis.gui;

import net.pyrix25633.ncis.client.GameClient;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private final GamePanel panel;

    /**
     * Constructor
     * @param helper The <code>GUIHelper</code>
     */
    public GameWindow(GUIHelper helper) {
        super();
        this.setSize(600, 400);
        this.setTitle("Naval Criminal Investigative Service: The Game " + GameClient.version);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(576, 324));

        panel = new GamePanel(helper);
        this.add(panel);

        this.setVisible(true);
        panel.requestFocus();
    }
}