package dev.donkz.demuyz.chip8;

import dev.donkz.demuyz.core.emulator.BaseInstruction;
import dev.donkz.demuyz.core.util.logger.Logger;

public abstract class Instruction implements BaseInstruction {
    protected final Logger logger;
    protected final int instructionCode;
    protected final Chip8 cpu;
    protected final int expectedParameters;
    protected final int[] parameters;

    public Instruction(int instructionCode, Chip8 cpu, int expectedParameters) {
        this.instructionCode = instructionCode;
        this.cpu = cpu;
        this.expectedParameters = expectedParameters;
        logger = cpu.getLogger();

        parameters = getParameters();
        assert parameters.length == expectedParameters : "Mismatch in expected parameters " + expectedParameters + " != " + parameters.length;
    }

    public Instruction(int instructionCode, Chip8 cpu) {
        this(instructionCode, cpu, 0);
    }

    @Override
    public int[] getParameters() {
        return new int[]{};
    }
}
