package net.pyrix25633.ncis;

import net.pyrix25633.ncis.client.GameClient;
import net.pyrix25633.ncis.component.Component;
import net.pyrix25633.ncis.server.GameServer;
import net.pyrix25633.ncis.util.HitBox;

public class Main {
    public static GameClient gameClient;
    public static GameServer gameServer;

    /**
     * Program entrypoint
     * @param args Program arguments
     */
    public static void main(String[] args) {
        gameServer = new GameServer();

        gameClient = new GameClient();

        gameServer.getWorld().add(new Component(gameClient.getConnectedClient().getPosition(), new HitBox(100, 100)));

        gameClient.repaint();
    }
}