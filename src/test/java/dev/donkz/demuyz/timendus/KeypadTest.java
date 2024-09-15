package dev.donkz.demuyz.timendus;

import dev.donkz.demuyz.util.TestUtil;

import java.io.FileNotFoundException;

/**
 * This test allows you to test all three CHIP-8 key input opcodes. It shows you a little menu, asking which opcode you would like to test
 * <p>
 * Credit to <a href="https://github.com/Timendus/chip8-test-suite">Timendus</a>
 */
public class KeypadTest {
    public static void main(String[] args) throws FileNotFoundException {
        TestUtil.runTestFile("6-keypad.ch8");
    }
}
