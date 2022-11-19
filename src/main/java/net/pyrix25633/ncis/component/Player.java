package net.pyrix25633.ncis.component;

import net.pyrix25633.ncis.util.HitBox;
import net.pyrix25633.ncis.util.Position;

public class Player extends MovableComponent {
    /**
     * Constructor
     * @param position The <code>Position</code>
     * @param hitBox The <code>HitBox</code>
     */
    public Player(Position<Float> position, HitBox<Float> hitBox) {
        super(position, hitBox);
    }
}