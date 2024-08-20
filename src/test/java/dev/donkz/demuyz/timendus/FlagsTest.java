package dev.donkz.demuyz.timendus;

import dev.donkz.demuyz.util.TestUtil;

import java.io.FileNotFoundException;

/**
 * Tests if math operations function properly and see if VF is set correctly.
 *
 * Credit to Timendus (https://github.com/Timendus/chip8-test-suite)
 */
public class FlagsTest {
    public static void main(String[] args) throws FileNotFoundException {
        TestUtil.runTestFile("4-flags.ch8");
    }
}
