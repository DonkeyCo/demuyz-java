package main.java.dev.donkz.demuyz.chip8;

import main.java.dev.donkz.demuyz.core.emulator.BaseRegister;

public class Register extends BaseRegister<Integer> {
    public Register() {
        this(0);
    }
    public Register(int value) {
        super(value);
    }
}
