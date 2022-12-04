package net.pyrix25633.special_agent;

import net.pyrix25633.special_agent.client.GameClient;
import net.pyrix25633.special_agent.component.Component;
import net.pyrix25633.special_agent.component.GUIComponent;
import net.pyrix25633.special_agent.server.GameServer;
import net.pyrix25633.special_agent.util.HitBox;
import net.pyrix25633.special_agent.util.Position;
import net.pyrix25633.special_agent.util.PositionRelativeTo;

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