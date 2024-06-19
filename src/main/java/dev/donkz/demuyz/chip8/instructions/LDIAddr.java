package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;
import main.java.dev.donkz.demuyz.core.util.binary.BinaryUtil;

public class LDIAddr extends Instruction {
    public LDIAddr(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 1);
    }

    @Override
    public void execute() {
        logger.debug("LD I, Addr", "Instruction");

        cpu.getI().setValue(parameters[0]);
        logger.debug("I := " + BinaryUtil.getHexString(parameters[0], 3));
    }

    @Override
    public int[] getParameters() {
        return new int[]{ instructionCode & 0x0FFF };
    }
}
