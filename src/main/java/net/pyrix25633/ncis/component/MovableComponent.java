package net.pyrix25633.ncis.component;

import net.pyrix25633.ncis.util.HitBox;
import net.pyrix25633.ncis.util.Position;
import net.pyrix25633.ncis.util.Vector;

public class MovableComponent extends Component {
    protected Vector<Float> movement;

    /**
     * Constructor
     * @param position The <code>Position</code>
     * @param hitBox The <code>HitBox</code>
     */
    public MovableComponent(Position<Float> position, HitBox<Float> hitBox) {
        super(position, hitBox);
        movement = new Vector<>(0F, 0F);
    }

    /**
     * Method to set the movement <code>Vector</code>
     * @param movement The movement <code>Vector</code>
     */
    public void setMovement(Vector<Float> movement) {
        this.movement = movement;
    }

    /**
     * Method to move the <code>MovableComponent</code> by its movement <code>Vector</code>
     */
    public void move() {
        position.move(movement);
    }
}