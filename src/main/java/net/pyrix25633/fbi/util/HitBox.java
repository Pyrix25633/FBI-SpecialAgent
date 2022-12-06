package net.pyrix25633.fbi.util;

import net.pyrix25633.fbi.resource.ResourceLoader;
import org.json.JSONObject;

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

        /**
         * Method to get an <code>HitBox.Float</code> from a <code>JSONObject</code>
         * @param object The <code>JSONObject</code>
         * @return The <code>HitBox.Float</code>
         */
        public static Float fromJSON(JSONObject object) {
            return new Float(object.getFloat(ResourceLoader.WKEY), object.getFloat(ResourceLoader.HKEY));
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