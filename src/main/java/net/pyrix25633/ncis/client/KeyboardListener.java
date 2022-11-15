package net.pyrix25633.ncis.client;

import net.pyrix25633.ncis.Main;
import net.pyrix25633.ncis.util.Vector;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Main.gameClient.move(switch(e.getKeyChar()) {
            case 'a' -> new Vector(-1, 0);
            case 'd' -> new Vector(1, 0);
            case 's' -> new Vector(0, -1);
            case 'w' -> new Vector(0, 1);
            default -> new Vector(0, 0);
        });
        System.out.println("Key pressed: " + e.getKeyChar());
        Main.gameClient.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}