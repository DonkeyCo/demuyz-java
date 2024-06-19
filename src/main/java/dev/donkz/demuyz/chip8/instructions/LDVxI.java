package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;
import main.java.dev.donkz.demuyz.chip8.util.Assertions;

public class LDVxI extends Instruction {
    public LDVxI(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 1);
    }

    @Override
    public void execute() {
        logger.debug("LD Vx, I", "Instruction");

        Assertions.assertRegister(parameters[0]);

        int[] buffer = cpu.getMemory().read(cpu.getI().getValue(), parameters[0] + 1);
        for (int i = 0; i < buffer.length; i++) {
            cpu.getRegister(i).setValue(buffer[i]);
        }
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8 };
    }
}
