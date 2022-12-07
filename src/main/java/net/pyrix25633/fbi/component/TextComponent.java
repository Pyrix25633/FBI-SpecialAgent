package net.pyrix25633.fbi.component;

import net.pyrix25633.fbi.resource.Texture;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.PositionRelativeTo;

import java.util.UUID;

public class TextComponent extends IdentifiableGUIComponent {
    //TODO: work on TextComponent
    /**
     * Constructor
     * @param uuid The <code>UUID</code>
     * @param position The <code>Position.Float</code>
     * @param hitBox The <code>HitBox.Float</code>
     * @param positionRelativeTo The <code>PositionRelativeTo</code>
     */
    public TextComponent(UUID uuid, Position.Float position, HitBox.Float hitBox, PositionRelativeTo positionRelativeTo) {
        super(uuid, position, hitBox, positionRelativeTo, null);
    }
}