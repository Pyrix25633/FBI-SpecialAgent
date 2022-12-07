package net.pyrix25633.fbi.resource;

import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PartialTexture extends Texture {
    protected final Position.Integer startPos, endPos;

    public PartialTexture(BufferedImage image, Position.Integer startPos, Position.Integer endPos) {
        super(image);
        this.startPos = startPos;
        this.endPos = endPos;
    }

    @Override
    public void draw(Position.Integer position, HitBox.Integer hitBox, Graphics g) {
        g.drawImage(image, position.getX(), position.getY(),
                position.getX() + hitBox.getWidth(), position.getY() + hitBox.getHeight(),
                this.startPos.getX(), this.startPos.getY(), this.endPos.getX(), this.endPos.getY(), null);
    }
}