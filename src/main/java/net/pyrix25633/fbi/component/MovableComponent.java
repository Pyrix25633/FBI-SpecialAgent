package net.pyrix25633.fbi.component;

import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.Vector;

public class MovableComponent extends Component implements Movable {
    protected Vector.Float movement;

    /**
     * Constructor
     * @param position The <code>Position</code>
     * @param hitBox The <code>HitBox</code>
     */
    public MovableComponent(Position.Float position, HitBox.Float hitBox) {
        super(position, hitBox);
        movement = new Vector.Float(0F, 0F);
    }

    /**
     * Method to set the movement <code>Vector</code>
     * @param movement The movement <code>Vector</code>
     */
    @Override
    public void setMovement(Vector.Float movement) {
        this.movement = movement;
    }

    /**
     * Method to move the <code>MovableComponent</code> by its movement <code>Vector</code>
     */
    @Override
    public void move() {
        position.move(movement);
    }
}