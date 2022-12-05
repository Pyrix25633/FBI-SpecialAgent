package net.pyrix25633.fbi.component;

import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;

import java.util.UUID;

public class CharComponent extends Component {
    //TODO: Work on CharComponent
    /**
     * Constructor
     * @param position The <code>Position</code>
     * @param hitBox The <code>HitBox</code>
     */
    public CharComponent(UUID uuid, Position.Float position, HitBox.Float hitBox) {
        super(uuid, position, hitBox);
    }
}