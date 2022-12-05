package net.pyrix25633.fbi.component;

import net.pyrix25633.fbi.gui.GUIHelper;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.PositionRelativeTo;

import java.awt.*;
import java.util.UUID;

public class GUIComponent extends Component {
    protected final PositionRelativeTo.X posRelToX;
    protected final PositionRelativeTo.Y posRelToY;
    /**
     * Constructor
     * @param uuid The <code>UUID</code>
     * @param position The <code>Position</code>
     * @param hitBox The <code>HitBox</code>
     * @param posRelToX The <code>PositionRelativeTo.X</code>
     * @param posRelToY The <code>PositionRelativeTo.Y</code>
     */
    public GUIComponent(UUID uuid, Position.Float position, HitBox.Float hitBox,
                          PositionRelativeTo.X posRelToX, PositionRelativeTo.Y posRelToY) {
        super(uuid, position, hitBox);
        this.posRelToX = posRelToX;
        this.posRelToY = posRelToY;
    }

    /**
     * Method to paint the component
     * @param g The <code>Graphics</code>
     * @param helper The <code>GUIHelper</code>
     */
    @Override
    public void paintComponent(Graphics g, GUIHelper helper) {
        super.paintComponent(g);

        HitBox.Integer calculatedHitBox = helper.calculateHitBox(hitBox);
        Position.Integer calculatedPosition = helper.calculateWindowRelativePosition(position, calculatedHitBox, posRelToX, posRelToY);

        g.fill3DRect(calculatedPosition.getX(), calculatedPosition.getY(),
                calculatedHitBox.getWidth(), calculatedHitBox.getHeight(), false);
    }
}