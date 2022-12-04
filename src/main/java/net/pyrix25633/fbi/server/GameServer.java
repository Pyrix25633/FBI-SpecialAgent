package net.pyrix25633.fbi.server;

import net.pyrix25633.fbi.client.ConnectedClient;
import net.pyrix25633.fbi.component.Component;
import net.pyrix25633.fbi.component.Movable;
import net.pyrix25633.fbi.component.MovableComponent;
import net.pyrix25633.fbi.component.Player;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.world.World;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public class GameServer {
    private final World world;
    private final ArrayList<ConnectedClient> connectedClients;

    /**
     * Constructor
     */
    public GameServer() {
        world = new World();
        connectedClients = new ArrayList<>();
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
     * Function to remove an <code>UUID</code>
     * @param uuid The <code>UUID</code>
     */
    public void removeComponent(UUID uuid) {
        world.remove(uuid);
    }

    /**
     * Method to connect a <code>ConnectedClient</code>
     * @return The <code>ConnectedClient</code>
     */
    public ConnectedClient connectClient() {
        ConnectedClient connectedClient = new ConnectedClient(new Player(new Position.Float(0F, 0F), new HitBox.Float(1F, 1F)));
        connectedClients.add(connectedClient);
        return connectedClient;
    }

    /**
     * Method to get a <code>ConnectedClient</code>
     * @param uuid The <code>UUID</code>
     * @return The <code>Position</code>
     */
    public Position.Float getConnectedClientPosition(UUID uuid) {
        int i = findConnectedClient(uuid);
        if(i != -1) return connectedClients.get(i).getPosition();
        return null;
    }

    /**
     * Method to set a <code>ConnectedClient</code> <code>Position</code>
     * @param connectedClient The <code>ConnectedClient</code>, that contains both the
     *                        <code>UUID</code> and the <code>Position</code>
     */
    public void setConnectedClientPosition(ConnectedClient connectedClient) {
        int i = findConnectedClient(connectedClient.getUUID());
        if(i != -1) connectedClients.get(i).getPosition().set(connectedClient.getPosition());
    }

    /**
     * Method to disconnect a <code>ConnectedClient</code>
     * @param uuid The <code>UUID</code>
     */
    public void disconnectClient(UUID uuid) {
        int i = findConnectedClient(uuid);
        if(i != -1) connectedClients.remove(i);
    }

    /**
     * Method to process the movements in the <code>World</code>
     */
    public void processMovements() {
        for(Map.Entry<UUID, Component> e : world) {
            Component c = e.getValue();
            if(c instanceof Movable) ((Movable)c).move();
        }

    }

    /**
     * Method to find a <code>ConnectedClient</code>
     * @param uuid The <code>UUID</code>
     * @return The <code>int</code> index, -1 if not found
     */
    private int findConnectedClient(UUID uuid) {
        for(int i = 0; i < connectedClients.size(); i++) {
            if(connectedClients.get(i).getUUID() == uuid) return i;
        }
        return -1;
    }
}