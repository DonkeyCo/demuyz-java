package dev.donkz.demuyz.chip8.instructions;

import dev.donkz.demuyz.chip8.Chip8;
import dev.donkz.demuyz.chip8.Instruction;
import dev.donkz.demuyz.chip8.Register;
import dev.donkz.demuyz.chip8.util.Assertions;

public class ADDIVx extends Instruction {
    public ADDIVx(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 1);
    }

    @Override
    public void execute() {
        logger.debug("ADD I, Vx", "Instruction");

        Assertions.assertRegister(parameters[0]);

        Register i = cpu.getI();

        i.setValue(i.getValue() + cpu.getRegister(parameters[0]).getValue());
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8 };
    }
}
