package net.pyrix25633.special_agent;

import net.pyrix25633.special_agent.client.GameClient;
import net.pyrix25633.special_agent.component.Component;
import net.pyrix25633.special_agent.server.GameServer;
import net.pyrix25633.special_agent.util.HitBox;
import net.pyrix25633.special_agent.util.Position;

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

        gameServer.getWorld().add(gameClient.getConnectedClient().getPlayer());
        gameServer.getWorld().add(new Component(new Position.Float(12F, 19F), new HitBox.Float(1F, 1F)));

        gameClient.getConnectedClient().getPosition().set(10F, 20F);

        gameServer.setConnectedClientPosition(gameClient.getConnectedClient());

        while(true) {
            gameServer.processMovements();
            gameClient.repaint();
            Thread.sleep(1000 / 60);
        }
    }
}