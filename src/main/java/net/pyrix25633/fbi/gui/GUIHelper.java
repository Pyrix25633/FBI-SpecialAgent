package net.pyrix25633.fbi.gui;

import net.pyrix25633.fbi.Main;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.PositionRelativeTo;

public class GUIHelper {
    private int scale;
    private HitBox.Integer windowDimension;
    private Position.Float clientPosition;
    private HitBox.Integer scaledClientHitBox;

    /**
     * Constructor
     * @param clientPosition The <code>ConnectedClient</code>'s <code>Player</code>'s <code>Position.Float</code>
     */
    public GUIHelper(Position.Float clientPosition) {
        scale = 0;
        windowDimension = new HitBox.Integer(0, 0);
        this.clientPosition = clientPosition;
        scaledClientHitBox = new HitBox.Integer(0, 0);
    }

    /**
     * Method to calculate the <code>Position.Integer</code> of a <code>World</code>'s <code>Component</code> on the <code>Window</code>
     * @param position The <code>World</code>'s <code>Component</code>'s <code>Position.Float</code>
     * @param scaledHitBox The previously calculated <code>HitBox.Integer</code>
     * @return The <code>Position.Integer</code> on the <code>Window</code>
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
     * Method to calculate the <code>Position.Integer</code> of a <code>GUIComponent</code> on the <code>Window</code>
     * @param position The <code>GUIComponent</code>'s <code>Position.Float</code>
     * @param scaledHitBox The previously calculated <code>HitBox.Integer</code>
     * @param positionRelativeTo The <code>GUIComponent</code> <code>PositionRelativeTo</code>
     * @return The <code>Position.Integer</code> on the <code>Window</code>
     */
    public Position.Integer calculateWindowRelativePosition(Position.Float position, HitBox.Integer scaledHitBox,
                                                            PositionRelativeTo positionRelativeTo) {
        Position.Float scaledPosition = new Position.Float(position.getX() * scale, position.getY() * scale);
        int x = (int)switch(positionRelativeTo.getX()) {
            case LEFT -> scaledPosition.getX();
            case CENTER -> windowDimension.getWidth() / 2F + scaledPosition.getX();
            case RIGHT -> windowDimension.getWidth() - scaledHitBox.getWidth() - scaledPosition.getX();
        };
        int y = (int)switch(positionRelativeTo.getY()) {
            case TOP -> scaledPosition.getY();
            case CENTER -> windowDimension.getHeight() / 2F + scaledPosition.getY();
            case BOTTOM -> windowDimension.getHeight() - scaledHitBox.getHeight() - scaledPosition.getY();
        };
        return new Position.Integer(x, y);
    }

    /**
     * Method to calculate the scaled <code>HitBox.Integer</code>
     * @param hitBox The <code>Component</code>'s <code>HitBox.Float</code>
     * @return The scaled <code>HitBox.Integer</code>
     */
    public HitBox.Integer calculateHitBox(HitBox.Float hitBox) {
        return new HitBox.Integer(Math.round(hitBox.getWidth() * scale), Math.round(hitBox.getHeight() * scale));
    }

    /**
     * Method to calculate the scale
     */
    public void calculateScale() {
        Window window = Main.client.getWindow();
        windowDimension = window.getDimension();
        scale = Math.max(windowDimension.getWidth() / 32, windowDimension.getHeight() / 18);
        scaledClientHitBox = calculateHitBox(Main.client.getConnectedClient().getPlayer().getHitBox());
    }

    /**
     * Method to refresh the helper
     * @param clientPosition The <code>ConnectedClient</code>'s <code>Player</code>'s <code>Position.Float</code>
     */
    public void refresh(Position.Float clientPosition) {
        this.clientPosition = clientPosition;
    }
}