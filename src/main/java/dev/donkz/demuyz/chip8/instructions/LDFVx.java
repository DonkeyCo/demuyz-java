package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;
import main.java.dev.donkz.demuyz.chip8.Register;
import main.java.dev.donkz.demuyz.chip8.util.Assertions;

public class LDFVx extends Instruction {
    public LDFVx(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 1);
    }

    @Override
    public void execute() {
        logger.debug("LD F, Vx", "Instruction");

        Assertions.assertRegister(parameters[0]);

        Register x = cpu.getRegister(parameters[0]);
        int sprite = x.getValue();

        int i = sprite * 5 + cpu.getMemory().FONT_ADDRESS;
        cpu.getI().setValue(i);
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8 };
    }
}
