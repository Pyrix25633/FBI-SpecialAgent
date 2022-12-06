package net.pyrix25633.fbi.util;

import net.pyrix25633.fbi.resource.ResourceLoader;
import org.json.JSONObject;

public class PositionRelativeTo {
    private final X x;
    private final Y y;

    /**
     * Constructor
     * @param x The <code>String</code> that will be converted to <code>PositionRelativeTo.X</code>
     * @param y The <code>String</code> that will be converted to <code>PositionRelativeTo.Y</code>
     */
    public PositionRelativeTo(String x, String y) {
        this(X.fromString(x), Y.fromString(y));
    }

    /**
     * Constructor
     * @param x The <code>PositionRelativeTo.X</code>
     * @param y The <code>PositionRelativeTo.Y</code>
     */
    public PositionRelativeTo(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Method to get the <code>PositionRelativeTo.X</code>
     * @return The <code>PositionRelativeTo.X</code>
     */
    public X getX() {
        return x;
    }

    /**
     * Method to get the <code>PositionRelativeTo.Y</code>
     * @return The <code>PositionRelativeTo.Y</code>
     */
    public Y getY() {
        return y;
    }

    /**
     * Method to get an <code>HitBox.Float</code> from a <code>JSONObject</code>
     * @param object The <code>JSONObject</code>
     * @return The <code>HitBox.Float</code>
     */
    public static PositionRelativeTo fromJSON(JSONObject object) {
        return new PositionRelativeTo(X.fromString(object.getString(ResourceLoader.XKEY)),
                Y.fromString(object.getString(ResourceLoader.YKEY)));
    }

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