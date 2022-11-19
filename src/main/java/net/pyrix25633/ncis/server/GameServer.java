package net.pyrix25633.ncis.server;

import net.pyrix25633.ncis.client.ConnectedClient;
import net.pyrix25633.ncis.component.Component;
import net.pyrix25633.ncis.component.MovableComponent;
import net.pyrix25633.ncis.component.Player;
import net.pyrix25633.ncis.util.HitBox;
import net.pyrix25633.ncis.util.Position;
import net.pyrix25633.ncis.world.World;

import java.util.ArrayList;
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
        ConnectedClient connectedClient = new ConnectedClient(new Player(new Position<>(0F, 0F), new HitBox<>(1F, 1F)));
        connectedClients.add(connectedClient);
        return connectedClient;
    }

    /**
     * Method to get a <code>ConnectedClient</code>
     * @param uuid The <code>UUID</code>
     * @return The <code>Position</code>
     */
    public Position<Float> getConnectedClientPosition(UUID uuid) {
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
        for(Component c : world)
            if(c instanceof MovableComponent) ((MovableComponent)c).move();
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