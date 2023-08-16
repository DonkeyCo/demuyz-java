package dev.donkz.demuyz.chip8.util;

import dev.donkz.demuyz.chip8.Chip8;

public class Assertions {
    public static void assertRegister(int register) {
        assert register < Chip8.REGISTERS : "Register " + register + " does not exist.";
    }
}
