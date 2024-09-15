package main.java.dev.donkz.demuyz.chip8;

import main.java.dev.donkz.demuyz.chip8.util.C8Keys;
import main.java.dev.donkz.demuyz.core.base.*;
import main.java.dev.donkz.demuyz.core.driver.InputDriver;
import main.java.dev.donkz.demuyz.core.emulator.BaseInput;
import main.java.dev.donkz.demuyz.core.event.Callback;
import main.java.dev.donkz.demuyz.core.event.KeyEventInfo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Keypad extends BaseInput {
    private final Set<C8Keys> pressedKeys;
    private final Map<C8Keys, Callback<KeyEventInfo>> waitMap;

    public Keypad(InputDriver driver) {
        super(driver);
        pressedKeys = new HashSet<>();
        waitMap = new HashMap<>();

        initialize();
    }

    private void initialize() {
        driver.register(ActionState.PRESSED, this::pressed);
        driver.register(ActionState.RELEASED, this::released);
    }

    private void pressed(KeyEventInfo eventInfo) {
        C8Keys key = C8Keys.fromCode(eventInfo.code());
        if (waitMap.containsKey(key)) {
            Callback<KeyEventInfo> callback = waitMap.remove(key);
            callback.execute(eventInfo);
        } else if (waitMap.containsKey(C8Keys.ANY)) {
            Callback<KeyEventInfo> callback = waitMap.remove(C8Keys.ANY);
            callback.execute(eventInfo);
        }
        pressedKeys.add(key);
    }

    private void released(KeyEventInfo eventInfo) {
        pressedKeys.remove(C8Keys.fromCode(eventInfo.code()));
    }

    public boolean isKeyPressed(C8Keys key) {
        return pressedKeys.contains(key);
    }

    public void waitForKeyPress(C8Keys key, Callback<KeyEventInfo> callback) {
        waitMap.put(key, callback);
    }

    public void waitForKeyPress(Callback<KeyEventInfo> callback) {
        waitMap.put(C8Keys.ANY, callback);
    }
}
