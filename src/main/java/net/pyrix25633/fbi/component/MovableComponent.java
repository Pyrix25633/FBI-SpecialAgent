package net.pyrix25633.fbi.component;

import net.pyrix25633.fbi.resource.Texture;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.Vector;

import java.util.UUID;

public class MovableComponent extends IdentifiableComponent implements Movable {
    protected Vector.Float movement;

    /**
     * Constructor
     * @param uuid The <code>UUID</code>
     * @param position The <code>Position.Float</code>
     * @param hitBox The <code>HitBox.Float</code>
     * @param texture The <code>Texture</code>
     */
    public MovableComponent(UUID uuid, Position.Float position, HitBox.Float hitBox, Texture texture) {
        super(uuid, position, hitBox, texture);
        movement = new Vector.Float(0F, 0F);
    }

    /**
     * Method to set the movement <code>Vector.Float</code>
     * @param movement The movement <code>Vector.Float</code>
     */
    @Override
    public void setMovement(Vector.Float movement) {
        this.movement = movement;
    }

    /**
     * Method to move the <code>MovableComponent</code> by its movement <code>Vector.Float</code>
     */
    @Override
    public void move() {
        position.move(movement);
    }
}