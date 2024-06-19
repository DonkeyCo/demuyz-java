package dev.donkz.demuyz;

import main.java.dev.donkz.demuyz.core.util.logger.Logger;
import main.java.dev.donkz.demuyz.chip8.Chip8;

public class SplashScreenTest {
    public static void main(String[] args) {
        Logger logger = new Logger(false);
        Chip8 chip8 = new Chip8(logger);

        chip8.loadROM("D:\\coding\\workspaces\\demuyz\\demuyz-java\\src\\test\\resources\\splashscreen_test.ch8");
        chip8.start();
    }
}
