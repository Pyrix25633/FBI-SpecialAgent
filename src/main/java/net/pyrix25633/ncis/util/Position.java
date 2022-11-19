package net.pyrix25633.ncis.util;

public class Position <T extends Number> {
    private T x;
    private T y;

    /**
     * Constructor
     * @param x The <code>T</code> x coordinate
     * @param y The <code>T</code> y coordinate
     */
    public Position(T x, T y) {
        set(x, y);
    }

    /**
     * Method to set the x coordinate
     * @param x The <code>T</code> x coordinate
     */
    public void setX(T x) {
        this.x = x;
    }

    /**
     * Method to set the y coordinate
     * @param y The <code>T</code> y coordinate
     */
    public void setY(T y) {
        this.y = y;
    }

    /**
     * Method to set both coordinates
     * @param x The <code>T</code> x coordinate
     * @param y The <code>T</code> y coordinate
     */
    public void set(T x, T y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method to set both coordinates
     * @param position The <code>Position</code>
     */
    public void set(Position<T> position) {
        this.x = position.getX();
        this.y = position.getY();
    }

    /**
     * Method to move a <code>Position</code> with a <code>Vector</code>
     * @param vector The <code>Vector</code>
     */
    public void move(Vector<T> vector) {
        this.x = Generics.sum(vector.getWidth(), this.x);
        this.y = Generics.sum(vector.getHeight(), this.y);
    }

    /**
     * Method to get the x coordinate
     * @return The <code>T</code> x coordinate
     */
    public T getX() {
        return x;
    }

    /**
     * Method to get the y coordinate
     * @return The <code>T</code> y coordinate
     */
    public T getY() {
        return y;
    }
}