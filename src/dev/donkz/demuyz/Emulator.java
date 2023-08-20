package dev.donkz.demuyz;

import dev.donkz.demuyz.chip8.Chip8;
import dev.donkz.demuyz.core.util.logger.Logger;
import dev.donkz.demuyz.ui.swing.SwingDisplay;

public class Emulator {
    public static void main(String[] args) {
        Logger logger = new Logger(false);
        Chip8 chip8 = new Chip8(logger);

        chip8.loadROM("D:\\coding\\workspaces\\demuyz\\demuyz-java\\src\\dev\\donkz\\demuyz\\test_opcode.ch8");
        chip8.start();
    }
}
