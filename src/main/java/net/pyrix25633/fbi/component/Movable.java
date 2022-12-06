package net.pyrix25633.fbi.component;

import net.pyrix25633.fbi.util.Vector;

public interface Movable {
    /**
     * Method to set the movement <code>Vector.Float</code>
     * @param movement The movement <code>Vector.Float</code>
     */
    void setMovement(Vector.Float movement);

    /**
     * Method to move the <code>MovableComponent</code> by its movement <code>Vector.Float</code>
     */
    void move();
}