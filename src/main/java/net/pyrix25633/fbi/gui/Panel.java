package net.pyrix25633.fbi.gui;

import net.pyrix25633.fbi.Main;
import net.pyrix25633.fbi.client.KeyboardListener;
import net.pyrix25633.fbi.component.IdentifiableComponent;
import net.pyrix25633.fbi.component.IdentifiableGUIComponent;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Panel extends JPanel {
    private final GUIHelper helper;
    private final HashMap<UUID, IdentifiableGUIComponent> components;

    /**
     * Constructor
     * @param helper The <code>GUIHelper</code>
     */
    public Panel(GUIHelper helper) {
        super();
        this.helper = helper;
        components = new HashMap<>();
        addKeyListener(new KeyboardListener());
    }

    /**
     * Method to add a <code>IdentifiableGUIComponent</code> to the <code>Panel</code>
     * @param component The <code>IdentifiableGUIComponent</code>
     */
    public void add(IdentifiableGUIComponent component) {
        components.put(component.getUUID(), component);
    }

    /**
     * Method to get a component with a certain <code>UUID</code>
     * @param uuid The <code>UUID</code>
     * @return The <code>IdentifiableGUIComponent</code> with that <code>UUID</code>,
     * null if it doesn't exist
     */
    public IdentifiableGUIComponent get(UUID uuid) {
        return components.get(uuid);
    }

    /**
     * Method to remove an <code>IdentifiableGUIComponent</code>
     * @param uuid The <code>UUID</code> of the <code>IdentifiableGUIComponent</code> to remove
     */
    public void remove(UUID uuid) {
        IdentifiableGUIComponent component = get(uuid);
        if(component != null)
            components.remove(component.getUUID());
    }

    /**
     * Method to empty the <code>Panel</code>
     */
    public void empty() {
        components.clear();
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
     * Method called to paint the <code>Panel</code>
     * @param g The <code>Graphics</code>
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Map.Entry<UUID, IdentifiableComponent> c : Main.server.getWorld()) {
            c.getValue().paintComponent(g, helper);
        }

        for(Map.Entry<UUID, IdentifiableGUIComponent> c : components.entrySet()) {
            c.getValue().paintComponent(g, helper);
        }
    }
}