package main.java.dev.donkz.demuyz;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.core.util.logger.Logger;
import main.java.dev.donkz.demuyz.swing.SwingDriver;

public class Emulator {
    public static void main(String[] args) {
        Logger logger = new Logger(false);
        SwingDriver swingDriver = new SwingDriver(64, 32, 5);

        Chip8 chip8 = new Chip8(swingDriver, swingDriver.getInputDriver(), logger);

        chip8.loadROM("D:\\coding\\workspaces\\demuyz\\demuyz-java\\src\\dev\\donkz\\demuyz\\1-chip8-logo.ch8");
        chip8.start();
    }
}
