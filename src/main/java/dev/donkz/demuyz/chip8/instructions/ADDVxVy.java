package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;
import main.java.dev.donkz.demuyz.chip8.Register;
import main.java.dev.donkz.demuyz.chip8.util.Assertions;

public class ADDVxVy extends Instruction {
    public ADDVxVy(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 2);
    }

    @Override
    public void execute() {
        logger.debug("ADD Vx, Vy", "Instruction");

        Assertions.assertRegister(parameters[0]);
        Assertions.assertRegister(parameters[1]);

        Register x = cpu.getRegister(parameters[0]);
        int sum = x.getValue() + cpu.getRegister(parameters[1]).getValue();

        x.setValue(sum & 0xFF);
        cpu.getRegister(0xF).setValue(sum > 0xFF ? 1 : 0);
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8, (instructionCode & 0x00F0) >>> 4 };
    }
}
