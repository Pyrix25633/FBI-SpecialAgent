package net.pyrix25633.fbi.component;

import net.pyrix25633.fbi.resource.Texture;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.PositionRelativeTo;

import java.util.UUID;

public class IdentifiableGUIComponent extends GUIComponent implements Identifiable {
    protected final UUID uuid;

    /**
     * Constructor
     * @param uuid The <code>UUID</code>
     * @param position The <code>Position.Float</code>
     * @param hitBox The <code>HitBox.Float</code>
     * @param positionRelativeTo The <code>PositionRelativeTo</code>
     * @param texture The <code>Texture</code>
     */
    public IdentifiableGUIComponent(UUID uuid, Position.Float position, HitBox.Float hitBox,
                                    PositionRelativeTo positionRelativeTo, Texture texture) {
        super(position, hitBox, positionRelativeTo, texture);
        this.uuid = uuid;
    }

    /**
     * Method to get the <code>UUID</code>
     * @return The <code>UUID</code>
     */
    @Override
    public UUID getUUID() {
        return uuid;
    }
}