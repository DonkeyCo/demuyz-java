package dev.donkz.demuyz.chip8.instructions;

import dev.donkz.demuyz.chip8.Chip8;
import dev.donkz.demuyz.chip8.Instruction;
import dev.donkz.demuyz.chip8.Register;
import dev.donkz.demuyz.chip8.util.Assertions;

public class SUBNVxVy extends Instruction {
    public SUBNVxVy(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 2);
    }

    @Override
    public void execute() {
        logger.debug("SUBN Vx, Vy", "Instruction");
        Assertions.assertRegister(parameters[0]);
        Assertions.assertRegister(parameters[1]);

        Register x = cpu.getRegister(parameters[0]);
        Register y = cpu.getRegister(parameters[1]);

        int diff = y.getValue() - x.getValue();
        int borrow = 0;
        if (x.getValue() > y.getValue()) {
            diff = x.getValue() - y.getValue();
            borrow = 1;
        }

        cpu.getRegister(0xF).setValue(borrow);
        x.setValue(diff);
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8, (instructionCode & 0x00F0) >>> 4 };
    }
}
