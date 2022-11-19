package net.pyrix25633.ncis.util;

public class Vector <T extends Number> {
    private T width, height;

    /**
     * Constructor
     * @param width The <code>T</code> width
     * @param height The <code>T</code> height
     */
    public Vector(T width, T height) {
        set(width, height);
    }

    /**
     * Method to set the width
     * @param width The <code>T</code> width
     */
    public void setWidth(T width) {
        this.width = width;
    }

    /**
     * Method to set the height
     * @param height The <code>T</code> height
     */
    public void setHeight(T height) {
        this.height = height;
    }

    /**
     * Method to set both width and height
     * @param width The <code>T</code> width
     * @param height The <code>T</code> height
     */
    public void set(T width, T height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Method to get the width
     * @return The <code>T</code> width
     */
    public T getWidth() {
        return width;
    }

    /**
     * Method to get the height
     * @return The <code>T</code> height
     */
    public T getHeight() {
        return height;
    }
}