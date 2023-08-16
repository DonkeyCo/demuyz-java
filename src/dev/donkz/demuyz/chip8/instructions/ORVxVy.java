package dev.donkz.demuyz.chip8.instructions;

import dev.donkz.demuyz.chip8.Chip8;
import dev.donkz.demuyz.chip8.Instruction;
import dev.donkz.demuyz.chip8.Register;
import dev.donkz.demuyz.chip8.util.Assertions;

public class ORVxVy extends Instruction {
    public ORVxVy(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 2);
    }

    @Override
    public void execute() {
        logger.debug("OR Vx, Vy", "Instruction");

        Assertions.assertRegister(parameters[0]);
        Assertions.assertRegister(parameters[1]);

        Register vx = cpu.getRegister(parameters[0]);
        vx.setValue(vx.getValue() | cpu.getRegister(parameters[1]).getValue());
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >> 8, (instructionCode & 0x00F0) >>> 4 };
    }
}
