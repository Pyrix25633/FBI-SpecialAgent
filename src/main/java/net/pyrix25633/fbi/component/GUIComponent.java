package net.pyrix25633.fbi.component;

import net.pyrix25633.fbi.gui.GUIHelper;
import net.pyrix25633.fbi.resource.Texture;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.PositionRelativeTo;

import java.awt.*;

public class GUIComponent extends Component {
    protected final PositionRelativeTo positionRelativeTo;
    /**
     * Constructor
     * @param position The <code>Position.Float</code>
     * @param hitBox The <code>HitBox.Float</code>
     * @param positionRelativeTo The <code>PositionRelativeTo</code>
     * @param texture The <code>Texture</code>
     */
    public GUIComponent(Position.Float position, HitBox.Float hitBox,
                        PositionRelativeTo positionRelativeTo, Texture texture) {
        super(position, hitBox, texture);
        this.positionRelativeTo = positionRelativeTo;
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
        Position.Integer calculatedPosition = helper.calculateWindowRelativePosition(position, calculatedHitBox, positionRelativeTo);

        texture.draw(calculatedPosition, calculatedHitBox, g);
    }
}