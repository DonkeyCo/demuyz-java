package dev.donkz.demuyz.chip8.instructions;

import dev.donkz.demuyz.chip8.Chip8;
import dev.donkz.demuyz.chip8.Instruction;
import dev.donkz.demuyz.chip8.util.Assertions;

public class LDDTVx extends Instruction {
    public LDDTVx(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 1);
    }

    @Override
    public void execute() {
        logger.debug("LD DT, Vx", "Instruction");

        Assertions.assertRegister(parameters[0]);

        cpu.getDelay().setValue(cpu.getRegister(parameters[0]).getValue());
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8 };
    }
}
