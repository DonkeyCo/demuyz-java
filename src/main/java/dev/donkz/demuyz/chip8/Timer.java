package main.java.dev.donkz.demuyz.chip8;

import main.java.dev.donkz.demuyz.core.emulator.BaseTimer;

public class Timer extends BaseTimer<Integer> {

    public Timer(int speed) {
        this(0, speed);
    }

    public Timer(int value, int speed) {
        super(value, speed);
    }

    @Override
    public void decreaseTimer() {
        value--;
    }
}
