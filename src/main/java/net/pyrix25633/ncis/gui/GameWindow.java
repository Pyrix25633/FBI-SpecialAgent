package net.pyrix25633.ncis.gui;

import javax.swing.*;

public class GameWindow {
    private final JFrame frame;
    private final GamePanel panel;

    /**
     * Constructor
     * @param version The game version, String
     */
    public GameWindow(String version) {
        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setTitle("Naval Criminal Investigative Service: The Game " + version);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new GamePanel();
        frame.add(panel);

        frame.setVisible(true);
    }
}