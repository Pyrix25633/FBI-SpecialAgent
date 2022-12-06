package net.pyrix25633.fbi.component;

import net.pyrix25633.fbi.gui.GUIHelper;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;

import javax.swing.*;
import java.awt.*;

public class Component extends JComponent {
    protected final Position.Float position;
    protected final HitBox.Float hitBox;

    /**
     * Constructor
     * @param position The <code>Position.Float</code>
     * @param hitBox The <code>HitBox.Float</code>
     */
    public Component(Position.Float position, HitBox.Float hitBox) {
        this.position = position;
        this.hitBox = hitBox;
    }

    /**
     * Method to paint the component
     * @param g The <code>Graphics</code>
     * @param helper The <code>GUIHelper</code>
     */
    public void paintComponent(Graphics g, GUIHelper helper) {
        super.paintComponent(g);

        HitBox.Integer calculatedHitBox = helper.calculateHitBox(hitBox);
        Position.Integer calculatedPosition = helper.calculateWorldWindowPosition(position, calculatedHitBox);

        g.fill3DRect(calculatedPosition.getX(), calculatedPosition.getY(),
                calculatedHitBox.getWidth(), calculatedHitBox.getHeight(), false);
    }

    /**
     * Method to get the <code>Position.Float</code>
     * @return The <code>Position.Float</code>
     */
    public Position.Float getPosition() {
        return position;
    }

    /**
     * Method to get the <code>HitBox.Float</code>
     * @return The <code>HitBox.Float</code>
     */
    public HitBox.Float getHitBox() {
        return hitBox;
    }
}