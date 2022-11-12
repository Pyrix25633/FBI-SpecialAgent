package net.pyrix25633.ncis.client;

import net.pyrix25633.ncis.client.gui.GameWindow;

public class GameClient {
    private final GameWindow window;
    public static final String version = "0.1.0";

    /**
     * Constructor
     */
    public GameClient() {
        window = new GameWindow();
    }
}