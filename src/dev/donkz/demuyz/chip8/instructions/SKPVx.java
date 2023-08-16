package dev.donkz.demuyz.chip8.instructions;

import dev.donkz.demuyz.chip8.Chip8;
import dev.donkz.demuyz.chip8.Instruction;
import dev.donkz.demuyz.chip8.Register;
import dev.donkz.demuyz.chip8.util.Assertions;

public class SKPVx extends Instruction {
    public SKPVx(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 1);
    }

    @Override
    public void execute() {
        logger.debug("SKP Vx", "Instruction");

        Assertions.assertRegister(parameters[0]);
        Register vx = cpu.getRegister(parameters[0]);

        // TODO: Handle keypress
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8 };
    }
}
