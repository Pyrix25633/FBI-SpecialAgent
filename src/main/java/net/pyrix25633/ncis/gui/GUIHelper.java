package net.pyrix25633.ncis.gui;

import net.pyrix25633.ncis.Main;
import net.pyrix25633.ncis.util.HitBox;
import net.pyrix25633.ncis.util.Position;
import org.jetbrains.annotations.NotNull;

public class GUIHelper {
    private static int scale = 1;

    public static Position calculateWindowPosition(@NotNull Position position) {
        Position clientPosition = Main.gameClient.getConnectedClient().getPosition();
        Position scaledClientPosition = new Position(clientPosition.getX() * scale,
                clientPosition.getY() * scale);
        Position scaledPosition = new Position(position.getX() * scale, position.getY() * scale);
        GameWindow window = Main.gameClient.getWindow();
        return new Position(scaledPosition.getX() - (scaledClientPosition.getX() - (window.getWidth() / 2)),
                window.getHeight() - (scaledPosition.getY() - (scaledClientPosition.getY() - (window.getHeight() / 2))));
    }

    public static HitBox calculateHitBox(HitBox hitBox) {
        return new HitBox(hitBox.getWidth() * scale, hitBox.getHeight() * scale);
    }

    public static void calculateScale() {
        GameWindow window = Main.gameClient.getWindow();
        scale = Math.max(window.getWidth() / 320, window.getHeight() / 180);
    }
}