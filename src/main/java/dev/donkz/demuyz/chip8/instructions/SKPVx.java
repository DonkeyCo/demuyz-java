package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;
import main.java.dev.donkz.demuyz.chip8.Register;
import main.java.dev.donkz.demuyz.chip8.util.Assertions;
import main.java.dev.donkz.demuyz.chip8.util.C8Keys;

public class SKPVx extends Instruction {
    public SKPVx(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 1);
    }

    @Override
    public void execute() {
        logger.debug("SKP Vx", "Instruction");

        Assertions.assertRegister(parameters[0]);
        Register vx = cpu.getRegister(parameters[0]);

        if (cpu.getKeypad().isKeyPressed(C8Keys.fromValue(vx.getValue()))) {
            cpu.setPC(cpu.getPC() + 2);
        }
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8 };
    }
}
