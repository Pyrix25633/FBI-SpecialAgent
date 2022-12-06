package net.pyrix25633.fbi.client;

import net.pyrix25633.fbi.Main;
import net.pyrix25633.fbi.gui.GUIHelper;
import net.pyrix25633.fbi.gui.Window;
import net.pyrix25633.fbi.util.Vector;

public class Client {
    private final Window window;
    private final GUIHelper helper;
    private ConnectedClient connectedClient;
    public static final String version = "0.1.0";

    /**
     * Constructor
     */
    public Client() {
        connect();
        helper = new GUIHelper(connectedClient.getPosition());
        window = new Window(helper);
    }

    /**
     * Method to get the <code>ConnectedClient</code>
     * @return The <code>ConnectedClient</code>
     */
    public ConnectedClient getConnectedClient() {
        return connectedClient;
    }

    /**
     * Method to connect the client
     */
    public void connect() {
        connectedClient = Main.server.connectClient();
    }

    /**
     * Method to set the movement of the <code>ConnectedClient</code>
     * @param vector The movement <code>Vector.Float</code>
     */
    public void setMovement(Vector.Float vector) {
        connectedClient.setMovement(vector);
    }

    /**
     * Method to get the <code>Window</code>
     * @return The <code>Window</code>
     */
    public Window getWindow() {
        return window;
    }

    /**
     * Method to repaint the <code>Window</code>
     */
    public void repaint() {
        helper.calculateScale();
        window.repaint();
    }

    public void refreshHelper() {
        helper.refresh(connectedClient.getPosition());
    }
}