package net.pyrix25633.fbi.component;

import net.pyrix25633.fbi.Main;
import net.pyrix25633.fbi.resource.Texture;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.PositionRelativeTo;

import java.util.ArrayList;
import java.util.UUID;

public class TextComponent extends IdentifiableGUIComponent {
    public static final int CHARW = 8, CHARH = 8, XSTEP = 7, YSTEP = 9;

    protected ArrayList<Component> characters;

    /**
     * Constructor
     * @param uuid The <code>UUID</code>
     * @param position The <code>Position.Float</code>
     * @param hitBox The <code>HitBox.Float</code>
     * @param positionRelativeTo The <code>PositionRelativeTo</code>
     */
    public TextComponent(UUID uuid, Position.Float position, HitBox.Float hitBox,
                         PositionRelativeTo positionRelativeTo, String text) {
        super(uuid, position, hitBox, positionRelativeTo, null);
        setText(text);
    }

    /**
     * Method to set the text
     * @param text The <code>String</code> text
     */
    public void setText(String text) {
        characters = new ArrayList<>();
        float startX = (positionRelativeTo.getX() == PositionRelativeTo.X.RIGHT) ? position.getX() - hitBox.getWidth() :
                position.getX(), x = startX;
        float y = (positionRelativeTo.getY() == PositionRelativeTo.Y.BOTTOM) ? position.getY() - hitBox.getHeight() :
                position.getY();
        for(int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            switch(c) {
                case '\n' -> {
                    x = startX;
                    y += YSTEP;
                }
                case '§' -> {
                    //TODO: coloring
                }
                default -> {
                    characters.add(new Component(new Position.Float(x, y), new HitBox.Float(CHARW, CHARH),
                            Main.resourceLoader.getCharTexture(c)));
                    x += XSTEP;
                }
            }
        }
    }
}