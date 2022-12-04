package net.pyrix25633.fbi.util;

public class HitBox {
    public static class Float extends Vector.Float {
        /**
         * Constructor
         * @param width The <code>float</code> width
         * @param height The <code>float</code> height
         */
        public Float(float width, float height) {
            super(width, height);
        }
    }

    public static class Integer extends Vector.Integer {
        /**
         * Constructor
         * @param width The <code>int</code> width
         * @param height The <code>int</code> height
         */
        public Integer(int width, int height) {
            super(width, height);
        }
    }
}