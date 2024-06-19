package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;

public class RET extends Instruction {
    public RET(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu);
    }

    @Override
    public void execute() {
        logger.debug("RET", "Instruction");

        assert cpu.getStack().size() > 0 : "Stack is empty";
        int address = cpu.getStack().pop();
        cpu.setPC(address);
        logger.debug("Return to address " + address, "Instruction", "RET");
    }
}
