package net.pyrix25633.ncis.client;

import net.pyrix25633.ncis.Main;
import net.pyrix25633.ncis.util.Vector;

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
            case 'a' -> Main.gameClient.setMovement(new Vector<>(-0.1F, 0F));
            case 'd' -> Main.gameClient.setMovement(new Vector<>(0.1F, 0F));
            case 's' -> Main.gameClient.setMovement(new Vector<>(0F, -0.1F));
            case 'w' -> Main.gameClient.setMovement(new Vector<>(0F, 0.1F));
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
            Main.gameClient.setMovement(new Vector<>(0F,0F));
    }
}