package net.pyrix25633.ncis.gui;

import net.pyrix25633.ncis.Main;
import net.pyrix25633.ncis.util.HitBox;
import net.pyrix25633.ncis.util.Position;

public class GUIHelper {
    private int scale = 1;
    private final Position<Float> clientPosition;

    /**
     * Constructor
     * @param clientPosition The <code>ConnectedClient</code> <code>Player</code> <code>Position</code>
     */
    public GUIHelper(Position<Float> clientPosition) {
        this.clientPosition = clientPosition;
    }

    /**
     * Method to calculate the <code>Position</code> of a <code>World</code> <code>Component</code> on the <code>GameWindow</code>
     * @param position The <code>World</code> <code>Component</code> <code>Position</code>
     * @param calculatedHitBox The previously calculated <code>HitBox</code>
     * @return The <code>Position</code> on the <code>GameWindow</code>
     */
    public Position<Integer> calculateWorldWindowPosition(Position<Float> position, HitBox<Integer> calculatedHitBox) {
        Position<Float> scaledClientPosition = new Position<>(clientPosition.getX() * scale,
                clientPosition.getY() * scale);
        Position<Float> scaledPosition = new Position<>(position.getX() * scale, position.getY() * scale);
        GameWindow window = Main.gameClient.getWindow();
        return new Position<>(Math.round(scaledPosition.getX() -
                (scaledClientPosition.getX() - ((window.getWidth() - (float)calculatedHitBox.getWidth()) / 2))),
            Math.round(window.getHeight() -
                (scaledPosition.getY() - (scaledClientPosition.getY() - (float)(window.getHeight() / 2) -
                calculatedHitBox.getHeight() * 1.5F))));
    }

    /**
     * Method to calculate the scaled <code>HitBox</code>
     * @param hitBox The <code>Component</code> <code>HitBox</code>
     * @return The scaled <code>HitBox</code>
     */
    public HitBox<Integer> calculateHitBox(HitBox<Float> hitBox) {
        return new HitBox<>(Math.round(hitBox.getWidth() * scale), Math.round(hitBox.getHeight() * scale));
    }

    /**
     * Method to calculate the scale
     */
    public void calculateScale() {
        GameWindow window = Main.gameClient.getWindow();
        scale = Math.max(window.getWidth() / 32, window.getHeight() / 18);
    }
}