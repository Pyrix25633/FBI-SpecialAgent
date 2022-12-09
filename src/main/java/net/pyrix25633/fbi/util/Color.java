package net.pyrix25633.fbi.util;

public enum Color {
    RED, ORANGE, YELLOW, GREEN, LIME, AQUA, BLUE, PURPLE, WHITE;

    /**
     * Method to get a <code>Color</code> from an <code>char</code> value
     * @param v The <code>char</code> value
     * @return The <code>Color</code>
     */
    public static Color fromChar(char v) {
        return switch(v) {
            case '0' -> RED;
            case '1' -> ORANGE;
            case '2' -> YELLOW;
            case '3' -> GREEN;
            case '4' -> LIME;
            case '5' -> AQUA;
            case '6' -> BLUE;
            case '7' -> PURPLE;
            default -> WHITE;
        };
    }

    /**
     * Method to get the <code>int</code> RGB of the <code>Color</code>
     * @return The <code>int</code> RGB
     */
    public int toRGB() {
        return switch(this) {
            case RED -> 0xFFFF0000;
            case ORANGE -> 0xFFFF8000;
            case YELLOW -> 0xFFFFFF00;
            case GREEN -> 0xFF0B300;
            case LIME -> 0xFF33FF66;
            case AQUA -> 0xFF1AFFC6;
            case BLUE -> 0xFF0000FF;
            case PURPLE -> 0xFF9933FF;
            case WHITE -> 0xFFFFFFFF;
        };
    }
}