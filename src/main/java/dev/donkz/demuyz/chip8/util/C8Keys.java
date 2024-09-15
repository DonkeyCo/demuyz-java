package main.java.dev.donkz.demuyz.chip8.util;

import main.java.dev.donkz.demuyz.core.base.KeyCode;

public enum C8Keys {
    // Chip8 Keyboard Mapping
    ONE(0x1, KeyCode.NUM_1), TWO(0x2, KeyCode.NUM_2), THREE(0x3, KeyCode.NUM_3), C(0xC, KeyCode.NUM_4),
    FOUR(0x4, KeyCode.Q), FIVE(0x5, KeyCode.W), SIX(0x6, KeyCode.E), D(0xD, KeyCode.R),
    SEVEN(0x7, KeyCode.A), EIGHT(0x8, KeyCode.S), NINE(0x9, KeyCode.D), E(0xE, KeyCode.F),
    A(0xA, KeyCode.Z), ZERO(0x0, KeyCode.X), B(0xB, KeyCode.C), F(0xF, KeyCode.V),
    ANY(0, KeyCode.A);

    public final int c8Key;
    public final KeyCode keyCode;
    C8Keys(int c8Key, KeyCode keyCode) {
        this.c8Key = c8Key;
        this.keyCode = keyCode;
    }

    public static C8Keys fromKeyCode(KeyCode keyCode) {
        for (C8Keys c8Key : C8Keys.values()) {
            if (c8Key.keyCode == keyCode) {
                return c8Key;
            }
        }
        return null;
    }

    public static C8Keys fromCode(int code) {
        for (C8Keys c8Key : C8Keys.values()) {
            KeyCode keyCode = KeyCode.fromCode(code);
            if (c8Key.keyCode == keyCode) {
                return c8Key;
            }
        }
        return null;
    }

    public static C8Keys fromValue(int value) {
        for (C8Keys c8Key : C8Keys.values()) {
            if (c8Key.c8Key == value) {
                return c8Key;
            }
        }
        return null;
    }
}
