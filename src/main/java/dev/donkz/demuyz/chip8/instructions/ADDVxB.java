package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;
import main.java.dev.donkz.demuyz.chip8.Register;
import main.java.dev.donkz.demuyz.chip8.util.Assertions;

public class ADDVxB extends Instruction {
    public ADDVxB(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 2);
    }

    @Override
    public void execute() {
        logger.debug("ADD Vx, byte", "Instruction");

        Assertions.assertRegister(parameters[0]);
        Register vx = cpu.getRegister(parameters[0]);
        vx.setValue((vx.getValue() + parameters[1]) & 0xFF);
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8, instructionCode & 0x00FF };
    }
}
