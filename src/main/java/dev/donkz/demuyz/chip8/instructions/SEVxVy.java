package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;
import main.java.dev.donkz.demuyz.chip8.util.Assertions;

public class SEVxVy extends Instruction {
    public SEVxVy(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 2);
    }

    @Override
    public void execute() {
        logger.debug("SE Vx, Vy", "Instruction");

        Assertions.assertRegister(parameters[0]);
        Assertions.assertRegister(parameters[1]);
        if (cpu.getRegister(parameters[0]).getValue().equals(cpu.getRegister(parameters[1]).getValue())) {
            int pc = cpu.getPC();
            cpu.setPC(pc + 2);
            logger.debug("Skipped instruction", "Instruction", "SE");
        }
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8, (instructionCode & 0x00F0) >>> 4 };
    }
}
