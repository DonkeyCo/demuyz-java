package dev.donkz.demuyz.chip8.instructions;

import dev.donkz.demuyz.chip8.Chip8;
import dev.donkz.demuyz.chip8.Instruction;
import dev.donkz.demuyz.chip8.Register;

public class JPV0Addr extends Instruction {
    public JPV0Addr(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 1);
    }

    @Override
    public void execute() {
        logger.debug("JP V0, Addr", "Instruction");

        Register v0 = cpu.getRegister(0);
        cpu.setPC(parameters[0] + v0.getValue());
    }

    @Override
    public int[] getParameters() {
        return new int[]{ instructionCode & 0x0FFF };
    }
}
