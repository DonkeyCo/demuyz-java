package main.java.dev.donkz.demuyz.chip8.util;

import main.java.dev.donkz.demuyz.chip8.Chip8;

public class Assertions {
    public static void assertRegister(int register) {
        assert register < Chip8.REGISTERS : "Register " + register + " does not exist.";
    }
}
