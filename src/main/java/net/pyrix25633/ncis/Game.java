package net.pyrix25633.ncis;

import net.pyrix25633.ncis.gui.GameWindow;

public class Game {
    private final GameWindow window;
    private final String version;

    /**
     * Constructor
     */
    public Game() {
        version = "0.1.0";
        window = new GameWindow(version);
    }
}