package net.pyrix25633.ncis.component;

import net.pyrix25633.ncis.Main;
import net.pyrix25633.ncis.gui.GUIHelper;
import net.pyrix25633.ncis.util.HitBox;
import net.pyrix25633.ncis.util.Position;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

public class Component extends JComponent {
    protected final UUID uuid;
    protected final Position position;
    protected final HitBox hitBox;

    /**
     * Constructor
     */
    public Component(Position position, HitBox hitBox) {
        uuid = Main.gameServer.generateUUID();
        this.position = position;
        this.hitBox = hitBox;
    }

    /**
     * Method to paint the component
     * @param g The <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        HitBox calculatedHitBox = GUIHelper.calculateHitBox(hitBox);
        Position calculatedPosition = GUIHelper.calculateWindowPosition(position, calculatedHitBox);

        g.fill3DRect((int)calculatedPosition.getX(), (int)calculatedPosition.getY(),
                (int)calculatedHitBox.getWidth(), (int)calculatedHitBox.getWidth(), false);
    }

    /**
     * Method to get the UUID
     * @return The <code>UUID</code>
     */
    public UUID getUuid() {
        return uuid;
    }
}