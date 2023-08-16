package dev.donkz.demuyz.chip8;

import dev.donkz.demuyz.core.driver.DisplayDriver;
import dev.donkz.demuyz.core.emulator.BaseDisplay;

public class Display extends BaseDisplay {
    public Display(DisplayDriver driver) {
        this(driver, 1);
    }

    public Display(DisplayDriver driver, int scale) {
        super(driver, 64, 32, scale);
    }

    public void drawSprite() {
        // TODO: Implement and get parameters
    }

    public void clearDisplay() {

    }
}
