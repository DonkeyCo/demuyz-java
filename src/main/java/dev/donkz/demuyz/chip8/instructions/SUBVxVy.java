package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;
import main.java.dev.donkz.demuyz.chip8.Register;
import main.java.dev.donkz.demuyz.chip8.util.Assertions;

public class SUBVxVy extends Instruction {
    public SUBVxVy(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 2);
    }

    @Override
    public void execute() {
        logger.debug("SUB Vx, Vy", "Instruction");

        Assertions.assertRegister(parameters[0]);
        Assertions.assertRegister(parameters[1]);

        Register x = cpu.getRegister(parameters[0]);
        Register y = cpu.getRegister(parameters[1]);
        logger.debug(x.getValue() + " - " + y.getValue());

        int carry = 0;
        if (x.getValue() >= y.getValue()) {
            carry = 1;
        }

        x.setValue((x.getValue() - y.getValue()) & 0xFF);
        cpu.getRegister(0xF).setValue(carry);
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8, (instructionCode & 0x00F0) >>> 4 };
    }
}
