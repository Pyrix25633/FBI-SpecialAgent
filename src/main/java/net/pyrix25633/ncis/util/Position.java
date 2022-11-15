package net.pyrix25633.ncis.util;

public class Position {
    private float x, y;

    /**
     * Constructor
     * @param x The <code>float</code> x coordinate
     * @param y The <code>float</code> y coordinate
     */
    public Position(float x, float y) {
        set(x, y);
    }

    /**
     * Method to set the x coordinate
     * @param x The <code>float</code> x coordinate
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Method to set the y coordinate
     * @param y The <code>float</code> y coordinate
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Method to set both coordinates
     * @param x The <code>float</code> x coordinate
     * @param y The <code>float</code> y coordinate
     */
    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method to set both coordinates
     * @param position The <code>Position</code>
     */
    public void set(Position position) {
        this.x = position.getX();
        this.y = position.getY();
    }

    public void move(Vector vector) {
        this.x += vector.getWidth();
        this.y += vector.getHeight();
    }

    /**
     * Method to get the x coordinate
     * @return The <code>float</code> x coordinate
     */
    public float getX() {
        return x;
    }

    /**
     * Method to get the y coordinate
     * @return The <code>float</code> y coordinate
     */
    public float getY() {
        return y;
    }
}