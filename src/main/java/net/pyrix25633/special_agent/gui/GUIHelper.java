package net.pyrix25633.special_agent.gui;

import net.pyrix25633.special_agent.Main;
import net.pyrix25633.special_agent.util.HitBox;
import net.pyrix25633.special_agent.util.Position;
import net.pyrix25633.special_agent.util.PositionRelativeTo;

public class GUIHelper {
    private int width, height, scale;
    private final Position.Float clientPosition;
    private HitBox.Integer calculatedClientHitBox;

    /**
     * Constructor
     * @param clientPosition The <code>ConnectedClient</code> <code>Player</code> <code>Position</code>
     */
    public GUIHelper(Position.Float clientPosition) {
        width = 0; height = 0; scale = 0;
        this.clientPosition = clientPosition;
        calculatedClientHitBox = new HitBox.Integer(0, 0);
    }

    /**
     * Method to calculate the <code>Position</code> of a <code>World</code> <code>Component</code> on the <code>GameWindow</code>
     * @param position The <code>World</code> <code>Component</code> <code>Position</code>
     * @param calculatedHitBox The previously calculated <code>HitBox</code>
     * @return The <code>Position</code> on the <code>GameWindow</code>
     */
    public Position.Integer calculateWorldWindowPosition(Position.Float position, HitBox.Integer calculatedHitBox) {
        Position.Float scaledClientPosition = new Position.Float(clientPosition.getX() * scale,
                clientPosition.getY() * scale);
        Position.Float scaledPosition = new Position.Float(position.getX() * scale, position.getY() * scale);
        GameWindow window = Main.gameClient.getWindow();
        //TODO: work here
        return new Position.Integer(Math.round(scaledPosition.getX() -
                (scaledClientPosition.getX() - ((window.getWidth() - (float)calculatedClientHitBox.getWidth()) / 2))),
            Math.round(window.getHeight() -
                (scaledPosition.getY() - (scaledClientPosition.getY() - (float)(window.getHeight() / 2) -
                calculatedClientHitBox.getHeight() * 1.5F)) - calculatedHitBox.getHeight()));
    }

    public Position.Integer calculateWindowRelativePosition(Position.Float position, PositionRelativeTo.X posRelToX,
                                                            PositionRelativeTo.Y posRelToY) {
        //TODO: work here
        return new Position.Integer(0, 0);
    }

    /**
     * Method to calculate the scaled <code>HitBox</code>
     * @param hitBox The <code>Component</code> <code>HitBox</code>
     * @return The scaled <code>HitBox</code>
     */
    public HitBox.Integer calculateHitBox(HitBox.Float hitBox) {
        return new HitBox.Integer(Math.round(hitBox.getWidth() * scale), Math.round(hitBox.getHeight() * scale));
    }

    /**
     * Method to calculate the scale
     */
    public void calculateScale() {
        GameWindow window = Main.gameClient.getWindow();
        width = window.getWidth();
        height = window.getHeight();
        scale = Math.max(width / 32, height / 18);
        calculatedClientHitBox = calculateHitBox(Main.gameClient.getConnectedClient().getPlayer().getHitBox());
    }
}