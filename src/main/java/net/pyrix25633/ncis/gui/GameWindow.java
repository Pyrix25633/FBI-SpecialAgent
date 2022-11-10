package net.pyrix25633.ncis.gui;

import net.pyrix25633.ncis.Game;

import javax.swing.*;

public class GameWindow extends JFrame {
    private final GamePanel panel;

    /**
     * Constructor
     */
    public GameWindow() {
        super();
        this.setSize(600, 400);
        this.setTitle("Naval Criminal Investigative Service: The Game " + Game.version);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel = new GamePanel();
        this.add(panel);

        this.setVisible(true);
    }
}