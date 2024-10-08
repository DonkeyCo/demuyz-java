package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;
import main.java.dev.donkz.demuyz.chip8.Register;
import main.java.dev.donkz.demuyz.chip8.util.Assertions;

public class SHRVx extends Instruction {
    public SHRVx(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 1);
    }

    @Override
    public void execute() {
        logger.debug("SHR Vx", "Instruction");

        Assertions.assertRegister(parameters[0]);

        Register x = cpu.getRegister(parameters[0]);

        int val = x.getValue() & 1;

        x.setValue((x.getValue() >>> 1) & 0xFF);
        cpu.getRegister(0xF).setValue(val);
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8 };
    }
}
