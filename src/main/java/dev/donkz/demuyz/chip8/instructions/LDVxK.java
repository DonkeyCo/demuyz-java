package main.java.dev.donkz.demuyz.chip8.instructions;

import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.chip8.Instruction;
import main.java.dev.donkz.demuyz.chip8.Keypad;
import main.java.dev.donkz.demuyz.chip8.Register;
import main.java.dev.donkz.demuyz.chip8.util.Assertions;
import main.java.dev.donkz.demuyz.chip8.util.KeyUtils;
import main.java.dev.donkz.demuyz.core.base.ActionState;
import main.java.dev.donkz.demuyz.core.event.KeyEventInfo;

public class LDVxK extends Instruction {
    public LDVxK(int instructionCode, Chip8 cpu) {
        super(instructionCode, cpu, 1);
    }

    @Override
    public void execute() {
        logger.debug("LD Vx, K", "Instruction");

        Assertions.assertRegister(parameters[0]);
        Register vx = cpu.getRegister(parameters[0]);

        Keypad keypad = cpu.getKeypad();
        keypad.waitForKeyPress(eventInfo -> vx.setValue(eventInfo.code()));
    }

    @Override
    public int[] getParameters() {
        return new int[]{ (instructionCode & 0x0F00) >>> 8 };
    }
}
