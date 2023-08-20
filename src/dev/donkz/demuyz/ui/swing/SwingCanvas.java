package dev.donkz.demuyz.ui.swing;

import dev.donkz.demuyz.core.base.Color;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class SwingCanvas extends JPanel {
    private int screenWidth;
    private int screenHeight;
    private int factor;
    private Color[][] pixels;

    public SwingCanvas(int screenWidth, int screenHeight, int factor) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.factor = factor;
        this.pixels = new Color[screenWidth][screenHeight];
    }

    @Override
    protected void paintComponent(Graphics g) {
        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                Color c = Objects.requireNonNullElse(pixels[x][y], new Color(0, 0, 0));
                g.setColor(new java.awt.Color(c.r(), c.g(), c.b()));

                int pX = x * factor, pY = y * factor;
                g.fillRect(pX, pY, factor, factor);
            }
        }
    }
}
