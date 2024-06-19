package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;

public class LDVxK extends Instruction {
    public LDVxK(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 1);
    }

    @Override
    public void execute() {
        logger.debug("LD Vx, K", "Instruction");

        // TODO: Handle key press
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8 };
    }
}
