package net.pyrix25633.fbi.resource;

import net.pyrix25633.fbi.util.HitBox;
import net.pyrix25633.fbi.util.Position;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Texture {
    protected BufferedImage image;

    public Texture(BufferedImage image) {
        this.image = image;
    }

    public void draw(Position.Integer position, HitBox.Integer hitBox, Graphics g) {
        g.drawImage(image, position.getX(), position.getY(), hitBox.getWidth(), hitBox.getHeight(), null);
    }
}