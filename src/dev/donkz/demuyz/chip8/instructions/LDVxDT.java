package dev.donkz.demuyz.chip8.instructions;

import dev.donkz.demuyz.chip8.Chip8;
import dev.donkz.demuyz.chip8.Instruction;
import dev.donkz.demuyz.chip8.util.Assertions;

public class LDVxDT extends Instruction {
    public LDVxDT(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 1);
    }

    @Override
    public void execute() {
        logger.debug("LD Vx, DT", "Instruction");

        Assertions.assertRegister(parameters[0]);

        cpu.getRegister(parameters[0]).setValue(cpu.getDelay().getValue());
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8 };
    }
}
