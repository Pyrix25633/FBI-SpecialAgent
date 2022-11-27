package net.pyrix25633.special_agent.client;

import net.pyrix25633.special_agent.component.Player;
import net.pyrix25633.special_agent.util.Position;
import net.pyrix25633.special_agent.util.Vector;

import java.util.UUID;

public class ConnectedClient {
    private final Player player;

    /**
     * Constructor
     * @param player The <code>Player</code>
     */
    public ConnectedClient(Player player) {
        this.player = player;
    }

    /**
     * Method to get the <code>Player</code> <code>UUID</code>
     * @return The <code>Player</code> <code>UUID</code>
     */
    public UUID getUUID() {
        return player.getUUID();
    }

    /**
     * Method to get the <code>Player</code> <code>Position</code>
     * @return The <code>Player</code> <code>Postion</code>
     */
    public Position.Float getPosition() {
        return player.getPosition();
    }

    /**
     * Method to get the <code>Player</code>
     * @return The <code>Player</code>
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Method to set the <code>Player</code> movement <code>Vector</code>
     * @param movement The movement <code>Vector</code>
     */
    public void setMovement(Vector.Float movement) {
        player.setMovement(movement);
    }
}