package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;
import main.java.dev.donkz.demuyz.chip8.util.Assertions;

import java.util.Arrays;

public class DRWVxVyN extends Instruction {
    public DRWVxVyN(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 3);
    }

    @Override
    public void execute() {
        logger.debug("DRW Vx, Vy", "Instruction");

        Assertions.assertRegister(parameters[0]);
        Assertions.assertRegister(parameters[1]);

        int x = cpu.getRegister(parameters[0]).getValue(), y = cpu.getRegister(parameters[1]).getValue();
        int n = parameters[2];
        int I = cpu.getI().getValue();

        int[] sprite = new int[n];
        for (int i = 0; i < n; i++) {
            sprite[i] = cpu.getMemory().read(I + i, 1)[0];
        }
        logger.debug(x + ", " + y + " - " + Arrays.toString(sprite) + " " + n, "Instruction", "DRW");

        boolean collision = cpu.getDisplay().drawSprite(x, y, sprite, n);
        cpu.getI().setValue(collision ? 1 : 0);
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8, (instructionCode & 0x00F0) >>> 4, instructionCode & 0x000F };
    }
}
