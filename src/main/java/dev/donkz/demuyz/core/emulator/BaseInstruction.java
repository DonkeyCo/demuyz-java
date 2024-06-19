package main.java.dev.donkz.demuyz.core.emulator;

public interface BaseInstruction {
    void execute();
    int[] getParameters();
}
