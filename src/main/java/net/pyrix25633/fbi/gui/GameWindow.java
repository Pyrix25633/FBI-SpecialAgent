package net.pyrix25633.fbi.gui;

import net.pyrix25633.fbi.client.GameClient;
import net.pyrix25633.fbi.component.GUIComponent;
import net.pyrix25633.fbi.util.HitBox;

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
        this.setTitle("FBI: Special Agent " + GameClient.version);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(576, 324));

        panel = new GamePanel(helper);
        this.add(panel);

        this.setVisible(true);
        panel.requestFocus();
    }

    public HitBox.Integer getDimension() {
        return new HitBox.Integer(panel.getWidth(), panel.getHeight());
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