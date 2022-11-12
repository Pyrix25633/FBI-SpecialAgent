package net.pyrix25633.ncis.client.gui;

import net.pyrix25633.ncis.client.GameClient;

import javax.swing.*;

public class GameWindow extends JFrame {
    private final GamePanel panel;

    /**
     * Constructor
     */
    public GameWindow() {
        super();
        this.setSize(600, 400);
        this.setTitle("Naval Criminal Investigative Service: The Game " + GameClient.version);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new GamePanel();
        this.add(panel);

        this.setVisible(true);
    }
}