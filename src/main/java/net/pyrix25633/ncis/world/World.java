package net.pyrix25633.ncis.world;

import net.pyrix25633.ncis.component.Component;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

public class World implements Iterable<Component> {
    private final ArrayList<Component> world;

    /**
     * Constructor
     */
    public World() {
        world = new ArrayList<>();
    }

    /**
     * Method to add a <code>Component</code> to the <code>World</code>
     * @param c The <code>Component</></code>
     */
    public void add(Component c) {
        world.add(c);
    }

    /**
     * Method to get a component with a certain <code>UUID</code>
     * @param uuid The <code>UUID</code>
     * @return The <code>Component</code> with that <code>UUID</code>,
     * null if it doesn't exist
     */
    public Component get(UUID uuid) {
        for(Component c : world) {
            if(c.getUuid() == uuid) return c;
        }
        return null;
    }

    /**
     * Method to remove a <code>Component</code>
     * @param uuid The <code>UUID</code> of the <code>Component</code>
     */
    public void remove(UUID uuid) {
        Component component = get(uuid);
        if(component != null)
            world.remove(component);
    }

    /**
     * Method to make the <code>World</code> class <code>Iterable</code>
     * @return The <code>Iterator</code>
     */
    @Override
    public Iterator<Component> iterator() {
        return world.iterator();
    }
}