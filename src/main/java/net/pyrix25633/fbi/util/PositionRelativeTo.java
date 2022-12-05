package net.pyrix25633.fbi.util;

public class PositionRelativeTo {
    public enum X {
        LEFT, CENTER, RIGHT;

        /**
         * Method to get a <code>PositionRelativeTo.X</code> from a string
         * @param s The <code>String</code>
         * @return The corresponding <code>PositionRelativeTo.X</code>
         */
        public static X fromString(String s) {
            return switch(s) {
                case "left" -> LEFT;
                case "center" -> CENTER;
                default -> RIGHT;
            };
        }
    }

    public enum Y {
        TOP, CENTER, BOTTOM;

        /**
         * Method to get a <code>PositionRelativeTo.Y</code> from a string
         * @param s The <code>String</code>
         * @return The corresponding <code>PositionRelativeTo.Y</code>
         */
        public static Y fromString(String s) {
            return switch(s) {
                case "top" -> TOP;
                case "center" -> CENTER;
                default -> BOTTOM;
            };
        }
    }
}