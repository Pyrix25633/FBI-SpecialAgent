package net.pyrix25633.special_agent.util;

public class Vector {
    public static class Float {
        private float width, height;

        /**
         * Constructor
         * @param width The <code>float</code> width
         * @param height The <code>float</code> height
         */
        public Float(float width, float height) {
            set(width, height);
        }

        /**
         * Method to set the width
         * @param width The <code>float</code> width
         */
        public void setWidth(float width) {
            this.width = width;
        }

        /**
         * Method to set the height
         * @param height The <code>float</code> height
         */
        public void setHeight(float height) {
            this.height = height;
        }

        /**
         * Method to set both width and height
         * @param width The <code>float</code> width
         * @param height The <code>float</code> height
         */
        public void set(float width, float height) {
            this.width = width;
            this.height = height;
        }

        /**
         * Method to get the width
         * @return The <code>float</code> width
         */
        public float getWidth() {
            return width;
        }

        /**
         * Method to get the height
         * @return The <code>float</code> height
         */
        public float getHeight() {
            return height;
        }
    }

    public static class Integer {
        private int width, height;

        /**
         * Constructor
         * @param width The <code>int</code> width
         * @param height The <code>int</code> height
         */
        public Integer(int width, int height) {
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
}