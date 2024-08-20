package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;
import main.java.dev.donkz.demuyz.core.emulator.Jumping;

public class JP extends Instruction implements Jumping {
    public JP(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 1);
    }

    @Override
    public void execute() {
        logger.debug("JP", "Instruction");

        cpu.setPC(parameters[0]);
        logger.debug("Set PC to " + parameters[0], "Instruction", "JP");
    }

    @Override
    public int[] getParameters() {
        return new int[]{instructionCode & 0x0FFF};
    }
}
