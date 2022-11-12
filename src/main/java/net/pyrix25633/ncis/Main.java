package net.pyrix25633.ncis;

import net.pyrix25633.ncis.client.GameClient;
import net.pyrix25633.ncis.component.Component;
import net.pyrix25633.ncis.server.GameServer;
import net.pyrix25633.ncis.util.HitBox;
import net.pyrix25633.ncis.util.Position;

public class Main {
    public static GameClient gameClient;
    public static GameServer gameServer;

    /**
     * Program entrypoint
     * @param args Program arguments
     */
    public static void main(String[] args) {
        gameServer = new GameServer();
        gameServer.getWorld().add(new Component(new Position(10, 10), new HitBox(100, 100)));

        gameClient = new GameClient();
    }
}