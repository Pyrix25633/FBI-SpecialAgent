package net.pyrix25633.special_agent.component;

import net.pyrix25633.special_agent.gui.GUIHelper;
import net.pyrix25633.special_agent.util.HitBox;
import net.pyrix25633.special_agent.util.Position;
import net.pyrix25633.special_agent.util.PositionRelativeTo;

import java.awt.*;

public class GUIComponent extends Component {
    protected final PositionRelativeTo.X posRelToX;
    protected final PositionRelativeTo.Y posRelToY;
    /**
     * Constructor
     * @param position The <code>Position</code>
     * @param hitBox The <code>HitBox</code>
     */
    public GUIComponent(Position.Float position, HitBox.Float hitBox,
                        PositionRelativeTo.X posRelToX, PositionRelativeTo.Y posRelToY) {
        super(position, hitBox);
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
        Position.Integer calculatedPosition = helper.calculateWorldWindowPosition(position, calculatedHitBox);

        g.fill3DRect(calculatedPosition.getX(), calculatedPosition.getY(),
                calculatedHitBox.getWidth(), calculatedHitBox.getWidth(), false);
    }
}