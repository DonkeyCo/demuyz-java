package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;

public class CALL extends Instruction {

    public CALL(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 1);
    }

    @Override
    public void execute() {
        logger.debug("CALL", "Instruction");

        cpu.getStack().push(cpu.getPC());
        cpu.setPC(parameters[0]);
        logger.debug("Call address " + parameters[0], "Instruction", "CALL");
    }

    @Override
    public int[] getParameters() {
        return new int[]{ instructionCode & 0x0FFF };
    }
}
