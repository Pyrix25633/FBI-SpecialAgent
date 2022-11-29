package net.pyrix25633.special_agent.world;

import net.pyrix25633.special_agent.component.Component;

import java.util.*;

public class World implements Iterable<Map.Entry<UUID, Component>> {
    private final HashMap<UUID, Component> world;

    /**
     * Constructor
     */
    public World() {
        world = new HashMap<>();
    }

    /**
     * Method to add a <code>Component</code> to the <code>World</code>
     * @param c The <code>Component</></code>
     */
    public void add(Component c) {
        world.put(c.getUUID(), c);
    }

    /**
     * Method to get a component with a certain <code>UUID</code>
     * @param uuid The <code>UUID</code>
     * @return The <code>Component</code> with that <code>UUID</code>,
     * null if it doesn't exist
     */
    public Component get(UUID uuid) {
        return world.get(uuid);
    }

    /**
     * Method to remove a <code>Component</code>
     * @param uuid The <code>UUID</code> of the <code>Component</code>
     */
    public void remove(UUID uuid) {
        Component component = get(uuid);
        if(component != null)
            world.remove(component.getUUID());
    }

    /**
     * Method to make the <code>World</code> class <code>Iterable</code>
     * @return The <code>Iterator</code>
     */
    @Override
    public Iterator<Map.Entry<UUID, Component>> iterator() {
        return world.entrySet().iterator();
    }
}