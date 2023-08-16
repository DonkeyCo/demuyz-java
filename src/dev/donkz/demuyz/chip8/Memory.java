package dev.donkz.demuyz.chip8;

import dev.donkz.demuyz.core.emulator.BaseMemory;

public class Memory extends BaseMemory {
    public final int FONT_ADDRESS = 0x050;

    public Memory() {
        super(4096);
        storeFont();
    }

    /**
     * Store font in memory (starting at 050 up to 09F)
     */
    private void storeFont() {
        int i = FONT_ADDRESS;
        for (Font font : Font.values()) {
            int[] representation = font.representation;
            for (int fontByte : representation) {
                memory[i] = fontByte;
                i++;
            }
        }
    }

}
