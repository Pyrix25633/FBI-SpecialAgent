package net.pyrix25633.ncis;

import net.pyrix25633.ncis.client.GameClient;
import net.pyrix25633.ncis.component.Component;
import net.pyrix25633.ncis.server.GameServer;
import net.pyrix25633.ncis.util.HitBox;
import net.pyrix25633.ncis.util.Position;

import java.util.Timer;

public class Main {
    public static GameClient gameClient;
    public static GameServer gameServer;

    /**
     * Program entrypoint
     * @param args Program arguments
     */
    public static void main(String[] args) throws InterruptedException {
        gameServer = new GameServer();

        gameClient = new GameClient();

        gameServer.getWorld().add(new Component(gameClient.getConnectedClient().getPosition(), new HitBox(10, 10)));
        gameServer.getWorld().add(new Component(new Position(50, 30), new HitBox(10, 10)));

        gameClient.getConnectedClient().getPosition().set(10, 20);

        gameServer.setConnectedClientPosition(gameClient.getConnectedClient());

        while(true) {
            gameClient.repaint();
            Thread.sleep(1000 / 60);
        }
    }
}