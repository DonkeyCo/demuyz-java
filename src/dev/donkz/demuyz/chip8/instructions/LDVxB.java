package dev.donkz.demuyz.chip8.instructions;

import dev.donkz.demuyz.chip8.Chip8;
import dev.donkz.demuyz.chip8.Instruction;
import dev.donkz.demuyz.chip8.util.Assertions;
import dev.donkz.demuyz.core.util.binary.BinaryUtil;

public class LDVxB extends Instruction {
    public LDVxB(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 2);
    }

    @Override
    public void execute() {
        logger.debug("LD Vx, byte", "Instruction");

        Assertions.assertRegister(parameters[0]);
        cpu.getRegister(parameters[0]).setValue(parameters[1]);
        logger.debug("V" + parameters[0] + " := " + BinaryUtil.getHexString(parameters[1], 4));
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8, instructionCode & 0x00FF };
    }
}
