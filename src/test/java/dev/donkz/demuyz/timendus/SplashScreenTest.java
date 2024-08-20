package dev.donkz.demuyz.timendus;

import dev.donkz.demuyz.util.TestUtil;

import java.io.FileNotFoundException;

/**
 * Tests the following codes:
 *
 * 00E0 - Clear the screen
 * 6xnn - Load normal register with immediate value
 * Annn - Load index register with immediate value
 * Dxyn - Draw sprite to screen (only aligned)
 *
 * Credit to Timendus (https://github.com/Timendus/chip8-test-suite)
 */
public class SplashScreenTest {
    public static void main(String[] args) throws FileNotFoundException {
        TestUtil.runTestFile("splashscreen_test.ch8");
    }
}
