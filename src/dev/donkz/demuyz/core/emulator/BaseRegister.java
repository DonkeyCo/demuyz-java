package dev.donkz.demuyz.core.emulator;

public abstract class BaseRegister<T> {
    protected T value;

    public BaseRegister(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
}
