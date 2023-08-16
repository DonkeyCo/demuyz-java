package dev.donkz.demuyz.chip8.instructions;

import dev.donkz.demuyz.chip8.Chip8;
import dev.donkz.demuyz.chip8.Instruction;
import dev.donkz.demuyz.core.util.binary.BinaryUtil;

public class LDIAddr extends Instruction {
    public LDIAddr(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 1);
    }

    @Override
    public void execute() {
        logger.debug("LD I, Addr", "Instruction");

        cpu.getI().setValue(parameters[0]);
        logger.debug("I := " + BinaryUtil.getHexString(parameters[0], 2));
    }

    @Override
    public int[] getParameters() {
        return new int[]{ instructionCode & 0x0FFF };
    }
}
