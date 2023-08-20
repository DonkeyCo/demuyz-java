package dev.donkz.demuyz.core.driver;

import dev.donkz.demuyz.core.base.Color;

public interface DisplayDriver {
    /**
     * Draws a pixel at x, y with given color.
     * @param x position x
     * @param y position y
     * @param color pixel color
     */
    void drawPixel(int x, int y, Color color);

    Color getPixel(int x, int y);

    /**
     * Clears display
     */
    void clearDisplay();

    /**
     * Renders the display
     */
    void render();

    void on();

    void off();

    int getScreenWidth();

    int getScreenHeight();
}
