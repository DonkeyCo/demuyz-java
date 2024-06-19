package main.java.dev.donkz.demuyz.swing;

import main.java.dev.donkz.demuyz.core.base.Interaction;
import main.java.dev.donkz.demuyz.core.base.KeyCode;
import main.java.dev.donkz.demuyz.core.driver.InputDriver;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class KeypadDriver implements InputDriver, KeyListener {

    private final Map<KeyCode, Interaction> keyMap;

    public KeypadDriver() {
        this.keyMap = new HashMap<>();
    }

    /* InputDriver */

    @Override
    public void registerKey(KeyCode keyCode, Interaction action) {
        keyMap.put(keyCode, action);
    }

    @Override
    public void keyPressed(KeyCode keyCode) {
        // TODO: Implement
    }

    @Override
    public KeyCode getKeyCode(char key) {
        // TODO: Implement
        return null;
    }

    /* KeyListener */

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (keyMap.containsKey(KeyCode.ALL)) {
            keyMap.get(KeyCode.ALL).act();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
