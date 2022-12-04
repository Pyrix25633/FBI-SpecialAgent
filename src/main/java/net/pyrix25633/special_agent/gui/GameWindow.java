package net.pyrix25633.special_agent.gui;

import net.pyrix25633.special_agent.client.GameClient;
import net.pyrix25633.special_agent.component.GUIComponent;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

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
        //setUndecorated(true);
        this.setVisible(true);
        panel.requestFocus();
    }

    @Override
    public int getWidth() {
        return panel.getWidth();
    }

    @Override
    public int getHeight() {
        return panel.getHeight();
    }

    /**
     * Method to add a <code>GUIComponent</code> to the <code>GameWindow</code>'s <code>GamePanel</code>
     * @param component The <code>GUIComponent</code>
     */
    public void add(GUIComponent component) {
        panel.add(component);
    }

    /**
     * Method to generate an <code>UUID</code>
     * @return An <code>UUID</code>
     */
    public UUID generateUUID() {
        return panel.generateUUID();
    }
}