package dev.donkz.demuyz.chip8;

import dev.donkz.demuyz.core.driver.DisplayDriver;
import dev.donkz.demuyz.core.emulator.BaseDisplay;
import dev.donkz.demuyz.core.util.binary.BinaryUtil;

import java.util.Arrays;

public class Display extends BaseDisplay {
    public Display(DisplayDriver driver) {
        this(driver, 1);
    }

    public Display(DisplayDriver driver, int scale) {
        super(driver, 64, 32, scale);
    }

    public boolean drawSprite(int x, int y, int[] sprite, int n) {
        boolean collision = false;
        for (int i = 0; i < n; i++) {
            int spriteByte = sprite[i];
            for (int b = 7; b >= 0; b--) {
                int bit = (spriteByte >> b) & 1;
                int pX = (x + 7 - b) % driver.getScreenWidth(), pY = (y + i) % driver.getScreenHeight();
                int currentColor = Arrays.stream(Color.values())
                        .filter(c -> c.color == driver.getPixel(pX, pY))
                        .findFirst().orElse(Color.WHITE).ordinal();
                Color newColor = Color.values()[bit];
                int color = currentColor ^ newColor.ordinal();

                driver.drawPixel(pX, pY, newColor.color);
                collision |= (currentColor ^ color) == 1;
            }
        }

        return collision;
    }

    public void clearDisplay() {
        driver.clearDisplay();
    }
}
