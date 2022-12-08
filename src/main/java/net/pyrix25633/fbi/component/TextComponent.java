package net.pyrix25633.fbi.component;

import net.pyrix25633.fbi.Main;
import net.pyrix25633.fbi.gui.GUIHelper;
import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;
import net.pyrix25633.fbi.util.PositionRelativeTo;

import java.awt.*;
import java.util.ArrayList;
import java.util.UUID;

public class TextComponent extends IdentifiableGUIComponent {
    public static final float CHARW = 0.5F, CHARH = 0.5F, XSTEP = 0.4375F, YSTEP = 0.5625F;

    protected ArrayList<GUIComponent> characters;

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
        System.out.println("Start position: " + startX);
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
                    characters.add(new GUIComponent(new Position.Float(x, y), new HitBox.Float(CHARW, CHARH),
                            positionRelativeTo, Main.resourceLoader.getCharTexture(c)));
                    x += XSTEP;
                }
            }
        }
    }

    /**
     * Method to paint the component
     * @param g The <code>Graphics</code>
     * @param helper The <code>GUIHelper</code>
     */
    @Override
    public void paintComponent(Graphics g, GUIHelper helper) {
        super.paintComponent(g);

        for(GUIComponent c : characters) {
            c.paintComponent(g, helper);
        }
    }
}