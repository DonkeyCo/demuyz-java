package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;
import main.java.dev.donkz.demuyz.chip8.util.Assertions;
import main.java.dev.donkz.demuyz.core.util.binary.BinaryUtil;

public class LDIVx extends Instruction {
    public LDIVx(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 1);
    }

    @Override
    public void execute() {
        logger.debug("LD I, Vx", "Instruction");
        logger.debug("Load V0 to V" + parameters[0] + " into Memory at " + BinaryUtil.getHexString(cpu.getI().getValue(), 4),
                "Instruction", "LD");

        Assertions.assertRegister(parameters[0]);

        int[] buffer = new int[parameters[0] + 1];
        for (int i = 0; i <= parameters[0]; i++) {
            buffer[i] = cpu.getRegister(i).getValue() & 0xFF;
        }
        cpu.getMemory().write(buffer, cpu.getI().getValue());
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8 };
    }
}
