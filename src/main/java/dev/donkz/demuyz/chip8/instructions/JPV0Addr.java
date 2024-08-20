package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;
import main.java.dev.donkz.demuyz.chip8.Register;
import main.java.dev.donkz.demuyz.core.emulator.Jumping;

public class JPV0Addr extends Instruction implements Jumping {
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
