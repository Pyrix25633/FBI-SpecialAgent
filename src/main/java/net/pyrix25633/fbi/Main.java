package net.pyrix25633.fbi;

import net.pyrix25633.fbi.client.GameClient;
import net.pyrix25633.fbi.component.Component;
import net.pyrix25633.fbi.component.GUIComponent;
import net.pyrix25633.fbi.parser.GameParser;
import net.pyrix25633.fbi.server.GameServer;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.PositionRelativeTo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.UUID;

public class Main {
    public static GameClient gameClient;
    public static GameServer gameServer;
    public static GameParser gameParser;

    /**
     * Program entrypoint
     * @param args Program arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        gameServer = new GameServer();

        gameClient = new GameClient();

        gameParser = new GameParser();

        gameServer.getWorld().add(gameClient.getConnectedClient().getPlayer());
        //gameServer.getWorld().add(new Component(new Position.Float(12F, 19F), new HitBox.Float(1F, 1F)));
        //gameServer.getWorld().add(new Component(new Position.Float(13F, 19F), new HitBox.Float(0.5F, 0.5F)));
        //gameServer.getWorld().add(new Component(new Position.Float(14F, 19F), new HitBox.Float(2F, 2F)));

        gameClient.getConnectedClient().getPosition().set(10F, 20F);

        gameServer.setConnectedClientPosition(gameClient.getConnectedClient());

        gameParser.loadGUI("main");

        while(true) {
            gameServer.processMovements();
            gameClient.repaint();
            Thread.sleep(1000 / 60);
        }
    }

    public static UUID generateUUID(Component component) {
        return (component instanceof GUIComponent) ? gameClient.getWindow().generateUUID() : gameServer.generateUUID();
    }
}