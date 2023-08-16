package dev.donkz.demuyz.chip8.instructions;

import dev.donkz.demuyz.chip8.Chip8;
import dev.donkz.demuyz.chip8.Instruction;
import dev.donkz.demuyz.chip8.Register;
import dev.donkz.demuyz.chip8.util.Assertions;

public class RNDVxB extends Instruction {
    public RNDVxB(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 2);
    }

    @Override
    public void execute() {
        logger.debug("RND Vx, Byte", "Instruction");

        Assertions.assertRegister(parameters[0]);

        Register x = cpu.getRegister(parameters[0]);
        int random = (int) Math.floor(Math.random() * (255 + 1));

        x.setValue(random & parameters[1]);
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8, instructionCode & 0x00FF };
    }
}
