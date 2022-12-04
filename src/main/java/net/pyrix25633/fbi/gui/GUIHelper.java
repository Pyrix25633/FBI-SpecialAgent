package net.pyrix25633.fbi.gui;

import net.pyrix25633.fbi.Main;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.PositionRelativeTo;

public class GUIHelper {
    private int scale;
    private HitBox.Integer windowDimension;
    private final Position.Float clientPosition;
    private HitBox.Integer scaledClientHitBox;

    /**
     * Constructor
     * @param clientPosition The <code>ConnectedClient</code> <code>Player</code> <code>Position</code>
     */
    public GUIHelper(Position.Float clientPosition) {
        scale = 0;
        windowDimension = new HitBox.Integer(0, 0);
        this.clientPosition = clientPosition;
        scaledClientHitBox = new HitBox.Integer(0, 0);
    }

    /**
     * Method to calculate the <code>Position</code> of a <code>World</code> <code>Component</code> on the <code>GameWindow</code>
     * @param position The <code>World</code> <code>Component</code> <code>Position</code>
     * @param scaledHitBox The previously calculated <code>HitBox</code>
     * @return The <code>Position</code> on the <code>GameWindow</code>
     */
    public Position.Integer calculateWorldWindowPosition(Position.Float position, HitBox.Integer scaledHitBox) {
        Position.Float scaledClientPosition = new Position.Float(clientPosition.getX() * scale,
                clientPosition.getY() * scale);
        Position.Float scaledPosition = new Position.Float(position.getX() * scale, position.getY() * scale);
        return new Position.Integer((int)Math.floor((windowDimension.getWidth() - scaledClientHitBox.getWidth()) / 2F +
                        (scaledPosition.getX() - scaledClientPosition.getX())),
                (int)Math.floor((windowDimension.getHeight() + scaledClientHitBox.getHeight()) / 2F -
                        (scaledPosition.getY() - scaledClientPosition.getY()) - (scaledHitBox.getHeight())));
    }

    /**
     * Method to calculate the <code>Position</code> of a <code>GUIComponent</code> on the <code>GameWindow</code>
     * @param position The <code>GUIComponent</code> <code>Position</code>
     * @param scaledHitBox The previously calculated <code>HitBox</code>
     * @return The <code>Position</code> on the <code>GameWindow</code>
     */
    public Position.Integer calculateWindowRelativePosition(Position.Float position, HitBox.Integer scaledHitBox,
                                                             PositionRelativeTo.X posRelToX, PositionRelativeTo.Y posRelToY) {
        Position.Float scaledPosition = new Position.Float(position.getX() * scale, position.getY() * scale);
        int x = (int)switch(posRelToX) {
            case LEFT -> scaledPosition.getX();
            case CENTER -> (windowDimension.getWidth() - scaledHitBox.getWidth()) / 2F + scaledPosition.getX();
            case RIGHT -> windowDimension.getWidth() - scaledHitBox.getWidth() - scaledPosition.getX();
        };
        int y = (int)switch(posRelToY) {
            case TOP -> scaledPosition.getY();
            case CENTER -> (windowDimension.getHeight() - scaledHitBox.getHeight()) / 2F + scaledPosition.getY();
            case BOTTOM -> windowDimension.getHeight() - scaledHitBox.getHeight() - scaledPosition.getY();
        };
        return new Position.Integer(x, y);
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
        windowDimension = window.getDimension();
        scale = Math.max(windowDimension.getWidth() / 32, windowDimension.getHeight() / 18);
        scaledClientHitBox = calculateHitBox(Main.gameClient.getConnectedClient().getPlayer().getHitBox());
    }
}