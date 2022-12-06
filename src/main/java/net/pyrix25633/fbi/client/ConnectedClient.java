package net.pyrix25633.fbi.client;

import net.pyrix25633.fbi.component.Identifiable;
import net.pyrix25633.fbi.component.Player;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.Vector;

import java.util.UUID;

public class ConnectedClient implements Identifiable {
    private final Player player;

    /**
     * Constructor
     * @param player The <code>Player</code>
     */
    public ConnectedClient(Player player) {
        this.player = player;
    }

    /**
     * Method to get the <code>Player</code>'s <code>UUID</code>
     * @return The <code>Player</code>'s <code>UUID</code>
     */
    public UUID getUUID() {
        return player.getUUID();
    }

    /**
     * Method to get the <code>Player</code> <code>Position.Float</code>
     * @return The <code>Player</code> <code>Position.Float</code>
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
     * Method to set the <code>Player</code> movement <code>Vector.Float</code>
     * @param movement The movement <code>Vector.Float</code>
     */
    public void setMovement(Vector.Float movement) {
        player.setMovement(movement);
    }
}