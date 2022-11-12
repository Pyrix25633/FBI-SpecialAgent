package net.pyrix25633.ncis.util;

public class HitBox {
    private int width, height;

    /**
     * Constructor
     * @param width The <code>int</code> width
     * @param height The <code>int</code> height
     */
    public HitBox(int width, int height) {
        set(width, height);
    }

    /**
     * Method to set the width
     * @param width The <code>int</code> width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Method to set the height
     * @param height The <code>int</code> height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Method to set both width and height
     * @param width The <code>int</code> width
     * @param height The <code>int</code> height
     */
    public void set(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Method to get the width
     * @return The <code>int</code> width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Method to get the height
     * @return The <code>int</code> height
     */
    public int getHeight() {
        return height;
    }
}