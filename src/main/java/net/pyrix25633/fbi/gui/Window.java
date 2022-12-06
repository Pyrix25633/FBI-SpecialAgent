package net.pyrix25633.fbi.gui;

import net.pyrix25633.fbi.client.Client;
import net.pyrix25633.fbi.component.GUIComponent;
import net.pyrix25633.fbi.component.IdentifiableGUIComponent;
import net.pyrix25633.fbi.util.HitBox;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

public class Window extends JFrame {
    private final Panel panel;

    /**
     * Constructor
     * @param helper The <code>GUIHelper</code>
     */
    public Window(GUIHelper helper) {
        super();
        this.setSize(600, 400);
        this.setTitle("FBI: Special Agent " + Client.version);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setMinimumSize(new Dimension(576, 324));

        panel = new Panel(helper);
        this.add(panel);

        this.setVisible(true);
        panel.requestFocus();
    }

    /**
     * Method to get the <code>Window</code> dimension
     * @return The <code>HitBox.Integer</code>
     */
    public HitBox.Integer getDimension() {
        return new HitBox.Integer(panel.getWidth(), panel.getHeight());
    }

    /**
     * Method to add a <code>IdentifiableGUIComponent</code> to the <code>Window</code>'s <code>Panel</code>
     * @param component The <code>IdentifiableGUIComponent</code>
     */
    public void add(IdentifiableGUIComponent component) {
        panel.add(component);
    }

    /**
     * Method to get a component with a certain <code>UUID</code>
     * @param uuid The <code>UUID</code>
     * @return The <code>IdentifiableGUIComponent</code> with that <code>UUID</code>,
     * null if it doesn't exist
     */
    public IdentifiableGUIComponent get(UUID uuid) {
        return panel.get(uuid);
    }

    /**
     * Method to remove an <code>IdentifiableGUIComponent</code>
     * @param uuid The <code>UUID</code> of the <code>IdentifiableGUIComponent</code> to remove
     */
    public void remove(UUID uuid) {
        panel.remove(uuid);
    }

    /**
     * Method to empty the <code>Panel</code>
     */
    public void empty() {
        panel.empty();
    }

    /**
     * Method to generate an <code>UUID</code>
     * @return An <code>UUID</code>
     */
    public UUID generateUUID() {
        return panel.generateUUID();
    }
}