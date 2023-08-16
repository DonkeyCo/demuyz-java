package dev.donkz.demuyz.core.emulator;

public abstract class BaseTimer<T> extends BaseRegister<T> {
    protected final int speed; // in Hz

    public BaseTimer(T value, int speed) {
        super(value);
        this.speed = speed;
    }

    public abstract void decreaseTimer();

    public void setTimer(T timer) {
        value = timer;
    }
}
