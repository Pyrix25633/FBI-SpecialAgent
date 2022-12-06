package net.pyrix25633.fbi.server;

import net.pyrix25633.fbi.client.ConnectedClient;
import net.pyrix25633.fbi.component.IdentifiableComponent;
import net.pyrix25633.fbi.component.Movable;
import net.pyrix25633.fbi.component.Player;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.world.World;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Server {
    private final World world;
    private final HashMap<UUID, ConnectedClient> connectedClients;

    /**
     * Constructor
     */
    public Server() {
        world = new World();
        connectedClients = new HashMap<>();
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
        } while(world.get(uuid) != null);
        return uuid;
    }

    /**
     * Method to connect a <code>ConnectedClient</code>
     * @return The <code>ConnectedClient</code>
     */
    public ConnectedClient connectClient() {
        ConnectedClient connectedClient = new ConnectedClient(new Player(null, new Position.Float(0F, 0F), new HitBox.Float(1F, 1F)));
        connectedClients.put(connectedClient.getUUID(), connectedClient);
        return connectedClient;
    }

    /**
     * Method to get a <code>ConnectedClient</code>'s <code>Position.Float</code>
     * @param uuid The <code>UUID</code>
     * @return The <code>Position.Float</code>
     */
    public Position.Float getConnectedClientPosition(UUID uuid) {
        ConnectedClient c = connectedClients.get(uuid);
        if(c != null) return c.getPosition();
        return null;
    }

    /**
     * Method to disconnect a <code>ConnectedClient</code>
     * @param uuid The <code>UUID</code>
     */
    public void disconnectClient(UUID uuid) {
        ConnectedClient c = connectedClients.get(uuid);
        if(c != null) connectedClients.remove(uuid);
    }

    /**
     * Method to process the movements in the <code>World</code>
     */
    public void processMovements() {
        for(Map.Entry<UUID, IdentifiableComponent> e : world) {
            IdentifiableComponent c = e.getValue();
            if(c instanceof Movable) ((Movable)c).move();
        }
    }
}