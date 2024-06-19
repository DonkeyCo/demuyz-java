package dev.donkz.demuyz;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.core.util.logger.Logger;

public class Emulator {
    public static void main(String[] args) {
        Logger logger = new Logger(false);
        Chip8 chip8 = new Chip8(logger);

        chip8.loadROM("D:\\coding\\workspaces\\demuyz\\demuyz-java\\src\\dev\\donkz\\demuyz\\1-chip8-logo.ch8");
        chip8.start();
    }
}
