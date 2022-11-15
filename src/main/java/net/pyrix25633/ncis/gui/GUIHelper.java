package net.pyrix25633.ncis.gui;

import net.pyrix25633.ncis.Main;
import net.pyrix25633.ncis.util.HitBox;
import net.pyrix25633.ncis.util.Position;

public class GUIHelper {
    private static int scale = 1;

    public static Position calculateWindowPosition(Position position, HitBox calculatedHitBox) {
        Position clientPosition = Main.gameClient.getConnectedClient().getPosition();
        Position scaledClientPosition = new Position(clientPosition.getX() * scale,
                clientPosition.getY() * scale);
        Position scaledPosition = new Position(position.getX() * scale, position.getY() * scale);
        GameWindow window = Main.gameClient.getWindow();
        return new Position(scaledPosition.getX() -
                (scaledClientPosition.getX() - ((window.getWidth() - calculatedHitBox.getWidth()) / 2)),
            window.getHeight() -
                (scaledPosition.getY() - (scaledClientPosition.getY() - (float)(window.getHeight() / 2) -
                calculatedHitBox.getHeight() * 1.5F)));
    }

    public static HitBox calculateHitBox(HitBox hitBox) {
        return new HitBox(hitBox.getWidth() * scale, hitBox.getHeight() * scale);
    }

    public static void calculateScale() {
        GameWindow window = Main.gameClient.getWindow();
        scale = Math.max(window.getWidth() / 32, window.getHeight() / 18);
    }
}