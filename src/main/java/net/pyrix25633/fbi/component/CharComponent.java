package net.pyrix25633.fbi.component;

import net.pyrix25633.fbi.resource.Texture;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.PositionRelativeTo;

public class CharComponent extends GUIComponent {
    //TODO: Work on CharComponent
    /**
     * Constructor
     * @param position The <code>Position</code>
     * @param hitBox The <code>HitBox</code>
     */
    public CharComponent(Position.Float position, HitBox.Float hitBox,
                         PositionRelativeTo positionRelativeTo, Texture texture) {
        super(position, hitBox, positionRelativeTo, texture);
    }


}