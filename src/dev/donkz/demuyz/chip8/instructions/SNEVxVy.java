package dev.donkz.demuyz.chip8.instructions;

import dev.donkz.demuyz.chip8.Chip8;
import dev.donkz.demuyz.chip8.Instruction;
import dev.donkz.demuyz.chip8.Register;
import dev.donkz.demuyz.chip8.util.Assertions;

public class SNEVxVy extends Instruction {
    public SNEVxVy(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 2);
    }

    @Override
    public void execute() {
        logger.debug("SNE Vx, Vy", "Instruction");

        Assertions.assertRegister(parameters[0]);
        Assertions.assertRegister(parameters[1]);

        Register x = cpu.getRegister(parameters[0]);
        Register y = cpu.getRegister(parameters[1]);

        if (!x.getValue().equals(y.getValue())) {
            cpu.setPC(cpu.getPC() + 2);
        }
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8, (instructionCode & 0x00F0) >>> 4 };
    }
}
