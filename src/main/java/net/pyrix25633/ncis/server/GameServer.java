package net.pyrix25633.ncis.server;

import net.pyrix25633.ncis.world.World;

import java.util.ArrayList;
import java.util.UUID;

public class GameServer {
    private final ArrayList<UUID> uuids;
    private final World world;

    /**
     * Constructor
     */
    public GameServer() {
        uuids = new ArrayList<>();
        world = new World();
    }

    /**
     * Method to get the <code>World</code>
     * @return The <code>World</code>
     */
    public World getWorld() {
        return world;
    }

    /**
     * Function to generate an <code>UUID</code>
     * @return An <code>UUID</code>
     */
    public UUID generateUUID() {
        UUID uuid;
        do {
            uuid = UUID.randomUUID();
        } while(uuids.contains(uuid));
        uuids.add(uuid);
        return uuid;
    }

    /**
     * Function to remove an <code>UUID</code>
     * @param uuid The <code>UUID</code>
     */
    public void removeUUID(UUID uuid) {
        uuids.remove(uuid);
    }
}