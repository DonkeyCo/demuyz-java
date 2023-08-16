package dev.donkz.demuyz.ui;

import dev.donkz.demuyz.core.base.Interaction;
import dev.donkz.demuyz.core.driver.InputDriver;

public class AWTInputDriver implements InputDriver {
    @Override
    public void registerKey(int keyCode, Interaction action) {

    }

    @Override
    public void keyPressed(int keyCode) {

    }

    @Override
    public int getKeyCode(char key) {
        return 0;
    }
}
