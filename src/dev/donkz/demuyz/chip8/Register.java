package dev.donkz.demuyz.chip8;

import dev.donkz.demuyz.core.emulator.BaseRegister;

public class Register extends BaseRegister<Integer> {
    public Register() {
        this(0);
    }
    public Register(int value) {
        super(value);
    }
}
