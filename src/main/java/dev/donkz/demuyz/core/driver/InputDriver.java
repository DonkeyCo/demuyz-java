package main.java.dev.donkz.demuyz.core.driver;

import main.java.dev.donkz.demuyz.core.base.Interaction;
import main.java.dev.donkz.demuyz.core.base.KeyCode;

public interface InputDriver {
    void registerKey(KeyCode keyCode, Interaction action);
    void keyPressed(KeyCode keyCode);
    KeyCode getKeyCode(char key);
}
