package net.pyrix25633.fbi.util;

import net.pyrix25633.fbi.resource.ResourceLoader;
import org.json.JSONObject;

public class Position {
    public static class Float {
        private float x;
        private float y;

        /**
         * Constructor
         * @param x The <code>float</code> x coordinate
         * @param y The <code>float</code> y coordinate
         */
        public Float(float x, float y) {
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
        public void set(Position.Float position) {
            this.x = position.getX();
            this.y = position.getY();
        }

        /**
         * Method to move a <code>Position</code> with a <code>Vector</code>
         * @param vector The <code>Vector</code>
         */
        public void move(Vector.Float vector) {
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

        /**
         * Method to get a <code>Position.Float</code> from a <code>JSONObject</code>
         * @param object The <code>JSONObject</code>
         * @return The <code>Position.Float</code>
         */
        public static Float fromJSON(JSONObject object) {
            return new Float(object.getFloat(ResourceLoader.XKEY), object.getFloat(ResourceLoader.YKEY));
        }
    }

    public static class Integer {
        private int x;
        private int y;

        /**
         * Constructor
         * @param x The <code>int</code> x coordinate
         * @param y The <code>int</code> y coordinate
         */
        public Integer(int x, int y) {
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
        public void set(Position.Integer position) {
            this.x = position.getX();
            this.y = position.getY();
        }

        /**
         * Method to move a <code>Position</code> with a <code>Vector</code>
         * @param vector The <code>Vector</code>
         */
        public void move(Vector.Integer vector) {
            this.x += vector.getWidth();
            this.y += vector.getHeight();
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
}