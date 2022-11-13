package net.pyrix25633.ncis.util;

public class Position {
    private int x, y;

    /**
     * Constructor
     * @param x The <code>int</code> x coordinate
     * @param y The <code>int</code> y coordinate
     */
    public Position(int x, int y) {
        set(x, y);
    }

    /**
     * Method to set the x coordinate
     * @param x The <code>int</code> x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Method to set the y coordinate
     * @param y The <code>int</code> y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Method to set both coordinates
     * @param x The <code>int</code> x coordinate
     * @param y The <code>int</code> y coordinate
     */
    public void set(int x, int y) {
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

    /**
     * Method to get the x coordinate
     * @return The <code>int</code> x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Method to get the y coordinate
     * @return The <code>int</code> y coordinate
     */
    public int getY() {
        return y;
    }
}