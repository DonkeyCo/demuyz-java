package dev.donkz.demuyz.chip8.instructions;

import dev.donkz.demuyz.chip8.Chip8;
import dev.donkz.demuyz.chip8.Instruction;
import dev.donkz.demuyz.chip8.util.Assertions;

public class DRWVxVyN extends Instruction {
    public DRWVxVyN(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 3);
    }

    @Override
    public void execute() {
        logger.debug("DRW Vx, Vy", "Instruction");

        Assertions.assertRegister(parameters[0]);
        Assertions.assertRegister(parameters[1]);

        // TODO: Implement Drawing
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8, (instructionCode & 0x00F0) >>> 4, instructionCode & 0x000F };
    }
}
