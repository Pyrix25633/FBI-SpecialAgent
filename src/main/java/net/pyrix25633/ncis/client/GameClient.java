package net.pyrix25633.ncis.client;

import net.pyrix25633.ncis.Main;
import net.pyrix25633.ncis.gui.GameWindow;

public class GameClient {
    private final GameWindow window;
    private final ConnectedClient connectedClient;
    public static final String version = "0.1.0";

    /**
     * Constructor
     */
    public GameClient() {
        window = new GameWindow();
        connectedClient = Main.gameServer.connectClient();
    }

    /**
     * Method to get the <code>ConnectedClient</code>
     * @return The <code>ConnectedClient</code>
     */
    public ConnectedClient getConnectedClient() {
        return connectedClient;
    }

    /**
     * Method to repaint the <code>GameWindow</code>
     */
    public void repaint() {
        window.repaint();
    }
}