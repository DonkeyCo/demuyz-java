package main.java.dev.donkz.demuyz.chip8.util;

import main.java.dev.donkz.demuyz.core.base.KeyCode;

import java.util.Arrays;

public class KeyUtils {
    public static C8Keys getKeyFromActionCode(KeyCode code) {
        return Arrays.stream(C8Keys.values()).filter(key -> key.keyCode == code).findFirst().orElse(null);
    }

    public static C8Keys getKeyFromC8Key(int c8Key) {
        return Arrays.stream(C8Keys.values()).filter(key -> key.c8Key == c8Key).findFirst().orElse(null);
    }

    public static KeyCode getActionCodeFromC8Key(int c8Key) {
        return Arrays.stream(C8Keys.values()).filter(key -> key.c8Key == c8Key).map(key -> key.keyCode).findFirst().orElse(null);
    }
}
