package main.java.dev.donkz.demuyz.swing;

import main.java.dev.donkz.demuyz.core.base.Color;
import main.java.dev.donkz.demuyz.core.driver.DisplayDriver;
import main.java.dev.donkz.demuyz.core.driver.EventDriver;
import main.java.dev.donkz.demuyz.core.driver.InputDriver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.Objects;

public class SwingDisplay extends JFrame implements DisplayDriver, EventDriver {

    private int screenWidth;
    private int screenHeight;
    private int factor;
    private Color[][] pixels;
    private Canvas canvas;

    public SwingDisplay(int screenWidth, int screenHeight) {
        this(screenWidth, screenHeight, 1);
    }

    public SwingDisplay(int screenWidth, int screenHeight, int factor) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.factor = factor;
        this.pixels = new Color[screenWidth][screenHeight];
    }

    private void initialize() {
        Dimension dimension = new Dimension(screenWidth * factor, screenHeight * factor);
        this.setSize(dimension);

        canvas = new Canvas();
        canvas.setSize(dimension);

        FlowLayout layout = new FlowLayout();
        layout.setHgap(0);
        layout.setVgap(0);

        this.setLayout(layout);
        this.add(canvas);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void on() {
        initialize();
        this.pack();
        this.setVisible(true);
        canvas.createBufferStrategy(2);
    }

    @Override
    public void off() {

    }

    @Override
    public void paint(Graphics graphics) {
        BufferStrategy strategy = canvas.getBufferStrategy();
        if (strategy == null) {
            return;
        }
        Graphics g = strategy.getDrawGraphics();

        for (int x = 0; x < screenWidth; x++) {
            for (int y = 0; y < screenHeight; y++) {
                Color c = Objects.requireNonNullElse(pixels[x][y], new Color(0, 0, 0));
                g.setColor(new java.awt.Color(c.r(), c.g(), c.b()));

                int pX = x * factor, pY = y * factor;
                g.fillRect(pX, pY, factor, factor);
            }
        }

        canvas.getBufferStrategy().show();
    }

    @Override
    public void render() {
        repaint();
    }

    @Override
    public void drawPixel(int x, int y, Color color) {
        pixels[x][y] = color;
    }

    @Override
    public Color getPixel(int x, int y) {
        return pixels[x][y];
    }

    @Override
    public void clearDisplay() {
        pixels = new Color[screenWidth][screenHeight];
        repaint();
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    @Override
    public int getScreenWidth() {
        return screenWidth;
    }

    @Override
    public int getScreenHeight() {
        return screenHeight;
    }

    @Override
    public void registerInput(InputDriver driver) {
        KeyListener listener = (KeyListener) driver;
        this.addKeyListener(listener);
    }
}
