package net.pyrix25633.fbi.gui;

import net.pyrix25633.fbi.Main;
import net.pyrix25633.fbi.client.KeyboardListener;
import net.pyrix25633.fbi.component.Component;
import net.pyrix25633.fbi.component.GUIComponent;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GamePanel extends JPanel {
    private final GUIHelper helper;
    private final HashMap<UUID, GUIComponent> components;

    /**
     * Constructor
     * @param helper The <code>GUIHelper</code>
     */
    public GamePanel(GUIHelper helper) {
        super();
        this.helper = helper;
        components = new HashMap<>();
        addKeyListener(new KeyboardListener());
    }

    /**
     * Method to add a <code>GUIComponent</code> to the <code>GamePanel</code>
     * @param component The <code>GUIComponent</code>
     */
    public void add(GUIComponent component) {
        components.put(component.getUUID(), component);
    }

    /**
     * Method to generate an <code>UUID</code>
     * @return An <code>UUID</code>
     */
    public UUID generateUUID() {
        UUID uuid;
        do {
            uuid = UUID.randomUUID();
        } while(components.get(uuid) != null);
        return uuid;
    }

    /**
     * Method called to paint the <code>GamePanel</code>
     * @param g The <code>Graphics</code>
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Map.Entry<UUID, Component> c : Main.gameServer.getWorld()) {
            c.getValue().paintComponent(g, helper);
        }

        for(Map.Entry<UUID, GUIComponent> c : components.entrySet()) {
            c.getValue().paintComponent(g, helper);
        }
    }
}