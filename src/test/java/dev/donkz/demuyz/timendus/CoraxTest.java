package dev.donkz.demuyz.timendus;

import dev.donkz.demuyz.util.TestUtil;

import java.io.FileNotFoundException;

/**
 * Tests the following codes:
 *
 * 00E0 - Clear the screen
 * 6xnn - Load normal register with immediate value
 * Annn - Load index register with immediate value
 * 7xnn - Add immediate value to normal register
 * Dxyn - Draw sprite to screen (un-aligned)
 *
 * 1nnn - Jump
 *
 * Credit to Timendus (https://github.com/Timendus/chip8-test-suite)
 */
public class CoraxTest {
    public static void main(String[] args) throws FileNotFoundException {
        TestUtil.runTestFile("3-corax+.ch8");
    }
}
