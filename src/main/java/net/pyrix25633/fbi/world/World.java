package net.pyrix25633.fbi.world;

import net.pyrix25633.fbi.component.IdentifiableComponent;

import java.util.*;

public class World implements Iterable<Map.Entry<UUID, IdentifiableComponent>> {
    private final HashMap<UUID, IdentifiableComponent> world;

    /**
     * Constructor
     */
    public World() {
        world = new HashMap<>();
    }

    /**
     * Method to add a <code>IdentifiableComponent</code> to the <code>World</code>
     * @param c The <code>IdentifiableComponent</></code>
     */
    public void add(IdentifiableComponent c) {
        world.put(c.getUUID(), c);
    }

    /**
     * Method to get a component with a certain <code>UUID</code>
     * @param uuid The <code>UUID</code>
     * @return The <code>IdentifiableComponent</code> with that <code>UUID</code>,
     * null if it doesn't exist
     */
    public IdentifiableComponent get(UUID uuid) {
        return world.get(uuid);
    }

    /**
     * Method to remove an <code>IdentifiableComponent</code>
     * @param uuid The <code>UUID</code> of the <code>IdentifiableComponent</code> to remove
     */
    public void remove(UUID uuid) {
        IdentifiableComponent component = get(uuid);
        if(component != null)
            world.remove(component.getUUID());
    }

    /**
     * Method to empty the <code>World</code>
     */
    public void empty() {
        world.clear();
    }

    /**
     * Method to make the <code>World</code> class <code>Iterable</code>
     * @return The <code>Iterator</code>
     */
    @Override
    public Iterator<Map.Entry<UUID, IdentifiableComponent>> iterator() {
        return world.entrySet().iterator();
    }
}