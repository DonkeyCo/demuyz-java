package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;
import main.java.dev.donkz.demuyz.chip8.Register;
import main.java.dev.donkz.demuyz.chip8.util.Assertions;

public class LDBVx extends Instruction {
    public LDBVx(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 1);
    }

    @Override
    public void execute() {
        logger.debug("LD B, Vx", "Instruction");

        Assertions.assertRegister(parameters[0]);

        Register x = cpu.getRegister(parameters[0]);
        Register i = cpu.getI();

        int value = x.getValue();
        cpu.getMemory().write(new int[]{
                Math.floorDiv(value, 100),
                Math.floorDiv(value, 10) % 10,
                value % 10
        }, i.getValue());
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8 };
    }
}