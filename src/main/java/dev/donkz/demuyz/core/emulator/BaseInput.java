package main.java.dev.donkz.demuyz.core.emulator;

import main.java.dev.donkz.demuyz.chip8.util.C8Keys;
import main.java.dev.donkz.demuyz.core.driver.InputDriver;
import main.java.dev.donkz.demuyz.core.event.Callback;
import main.java.dev.donkz.demuyz.core.event.KeyEventInfo;

public abstract class BaseInput {
    protected final InputDriver driver;

    public BaseInput(InputDriver driver) {
        this.driver = driver;
    }

    public InputDriver getDriver() {
        return driver;
    }

    public abstract boolean isKeyPressed(C8Keys key);
    public abstract void waitForKeyPress(C8Keys key, Callback<KeyEventInfo> callback);
    public abstract void waitForKeyPress(Callback<KeyEventInfo> callback);
}
