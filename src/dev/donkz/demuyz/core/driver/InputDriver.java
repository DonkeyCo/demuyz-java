package dev.donkz.demuyz.core.driver;

import dev.donkz.demuyz.core.base.Interaction;

public interface InputDriver {
    void registerKey(int keyCode, Interaction action);
    void keyPressed(int keyCode);
    int getKeyCode(char key);
}
