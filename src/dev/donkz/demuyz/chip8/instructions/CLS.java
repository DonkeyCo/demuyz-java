package dev.donkz.demuyz.chip8.instructions;

import dev.donkz.demuyz.chip8.Chip8;
import dev.donkz.demuyz.chip8.Instruction;

public class CLS extends Instruction {

    public CLS(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu);
    }

    @Override
    public void execute() {
        logger.debug("CLS", "Instruction");
        cpu.getDisplay().clearDisplay();
    }
}
