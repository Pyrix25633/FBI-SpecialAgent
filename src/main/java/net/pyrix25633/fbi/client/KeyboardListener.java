package net.pyrix25633.fbi.client;

import net.pyrix25633.fbi.Main;
import net.pyrix25633.fbi.util.Vector;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    /**
     * Method called when a key is typed
     * @param e The <code>KeyEvent</code> to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Method called when a key is pressed
     * @param e The <code>KeyEvent</code> to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyChar()) {
            case 'a' -> Main.client.setMovement(new Vector.Float(-0.1F, 0F));
            case 'd' -> Main.client.setMovement(new Vector.Float(0.1F, 0F));
            case 's' -> Main.client.setMovement(new Vector.Float(0F, -0.1F));
            case 'w' -> Main.client.setMovement(new Vector.Float(0F, 0.1F));
        }
    }

    /**
     * Method called when a key is released
     * @param e The <code>KeyEvent</code> to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        char key = e.getKeyChar();
        if(key == 'a' || key == 'd' || key == 's' || key == 'w')
            Main.client.setMovement(new Vector.Float(0F,0F));
    }
}