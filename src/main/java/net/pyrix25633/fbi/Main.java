package net.pyrix25633.fbi;

import net.pyrix25633.fbi.client.GameClient;
import net.pyrix25633.fbi.component.Component;
import net.pyrix25633.fbi.component.GUIComponent;
import net.pyrix25633.fbi.server.GameServer;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.PositionRelativeTo;

import java.util.UUID;

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
        gameServer.getWorld().add(new Component(new Position.Float(13F, 19F), new HitBox.Float(0.5F, 0.5F)));

        gameClient.getConnectedClient().getPosition().set(10F, 20F);

        gameServer.setConnectedClientPosition(gameClient.getConnectedClient());

        gameClient.getWindow().add(new GUIComponent(new Position.Float(0F, 0F), new HitBox.Float(1F, 1F), PositionRelativeTo.X.LEFT, PositionRelativeTo.Y.TOP));
        gameClient.getWindow().add(new GUIComponent(new Position.Float(0F, 0F), new HitBox.Float(1F, 1F), PositionRelativeTo.X.CENTER, PositionRelativeTo.Y.TOP));
        gameClient.getWindow().add(new GUIComponent(new Position.Float(0F, 0F), new HitBox.Float(1F, 1F), PositionRelativeTo.X.RIGHT, PositionRelativeTo.Y.TOP));
        gameClient.getWindow().add(new GUIComponent(new Position.Float(0F, 0F), new HitBox.Float(1F, 1F), PositionRelativeTo.X.LEFT, PositionRelativeTo.Y.CENTER));
        gameClient.getWindow().add(new GUIComponent(new Position.Float(0F, 0F), new HitBox.Float(1F, 1F), PositionRelativeTo.X.CENTER, PositionRelativeTo.Y.CENTER));
        gameClient.getWindow().add(new GUIComponent(new Position.Float(0F, 0F), new HitBox.Float(1F, 1F), PositionRelativeTo.X.RIGHT, PositionRelativeTo.Y.CENTER));
        gameClient.getWindow().add(new GUIComponent(new Position.Float(0F, 0F), new HitBox.Float(1F, 1F), PositionRelativeTo.X.LEFT, PositionRelativeTo.Y.BOTTOM));
        gameClient.getWindow().add(new GUIComponent(new Position.Float(0F, 0F), new HitBox.Float(1F, 1F), PositionRelativeTo.X.CENTER, PositionRelativeTo.Y.BOTTOM));
        gameClient.getWindow().add(new GUIComponent(new Position.Float(0F, 0F), new HitBox.Float(1F, 1F), PositionRelativeTo.X.RIGHT, PositionRelativeTo.Y.BOTTOM));


        while(true) {
            gameServer.processMovements();
            gameClient.repaint();
            Thread.sleep(1000 / 60);
        }
    }

    public static UUID generateUUID(Component component) {
        System.out.println("The component is instance of " + ((component instanceof GUIComponent) ? "GUIComponent" : "Component"));
        return (component instanceof GUIComponent) ? gameClient.getWindow().generateUUID() : gameServer.generateUUID();
    }
}