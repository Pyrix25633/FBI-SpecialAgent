package net.pyrix25633.fbi.component;

import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;

import java.util.UUID;

public class Player extends MovableComponent {
    /**
     * Constructor
     * @param uuid The <code>UUID</code>
     * @param position The <code>Position.Float</code>
     * @param hitBox The <code>HitBox.Float</code>
     */
    public Player(UUID uuid, Position.Float position, HitBox.Float hitBox) {
        super(uuid, position, hitBox);
    }
}