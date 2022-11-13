package net.pyrix25633.ncis.client;

import net.pyrix25633.ncis.util.Position;

import java.util.UUID;

public class ConnectedClient {
    private final UUID uuid;
    private final Position position;

    /**
     * Constructor
     * @param uuid The <code>UUID</code>
     * @param position The <code>Position</code>
     */
    public ConnectedClient(UUID uuid, Position position) {
        this.uuid = uuid;
        this.position = position;
    }

    /**
     * Method to get the <code>UUID</code>
     * @return The <code>UUID</code>
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Method to get the <code>Position</code>
     * @return The <code>Position</code>
     */
    public Position getPosition() {
        return position;
    }
}