package net.pyrix25633.fbi.component;

import net.pyrix25633.fbi.Main;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;

import java.util.UUID;

public class IdentifiableComponent extends Component implements Identifiable {
    protected final UUID uuid;

    /**
     * Constructor
     * @param uuid The <code>UUID</code>
     * @param position The <code>Position.Float</code>
     * @param hitBox The <code>HitBox.Float</code>
     */
    public IdentifiableComponent(UUID uuid, Position.Float position, HitBox.Float hitBox) {
        super(position, hitBox);
        this.uuid = (uuid != null) ? uuid : Main.generateUUID(this);
    }

    /**
     * Method to get the UUID
     * @return The <code>UUID</code>
     */
    public UUID getUUID() {
        return uuid;
    }
}