package main.java.dev.donkz.demuyz.swing;

import main.java.dev.donkz.demuyz.core.base.ActionState;
import main.java.dev.donkz.demuyz.core.event.Callback;
import main.java.dev.donkz.demuyz.core.driver.InputDriver;
import main.java.dev.donkz.demuyz.core.event.KeyEventInfo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class SwingKeyListener implements KeyListener, InputDriver {
    private final HashMap<ActionState, Callback<KeyEventInfo>> callbacks;

    public SwingKeyListener() {
        callbacks = new HashMap<>();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("test");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Callback<KeyEventInfo> callback = callbacks.get(ActionState.PRESSED);
        if (callback != null) {
            callback.execute(new KeyEventInfo(e.getKeyCode()));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Callback<KeyEventInfo> callback = callbacks.get(ActionState.RELEASED);
        if (callback != null) {
            callback.execute(new KeyEventInfo(e.getKeyCode()));
        }
    }

    @Override
    public void register(ActionState state, Callback<KeyEventInfo> callback) {
        callbacks.put(state, callback);
    }

    @Override
    public void deregister(ActionState state, Callback<KeyEventInfo> callback) {
        callbacks.remove(state, callback);
    }

    @Override
    public void reset() {
        callbacks.clear();
    }
}
