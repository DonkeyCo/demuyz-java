package dev.donkz.demuyz.core.emulator;

import dev.donkz.demuyz.core.driver.DisplayDriver;

public abstract class BaseDisplay {
    protected DisplayDriver driver;
    protected final int width;
    protected final int height;
    protected final int refreshRate;
    protected int scale;

    public BaseDisplay(DisplayDriver driver, int width, int height, int refreshRate) {
        this(driver, width, height, refreshRate, 1);
    }

    public BaseDisplay(DisplayDriver driver, int width, int height, int refreshRate, int scale) {
        this.driver = driver;
        this.width = width;
        this.height = height;
        this.refreshRate = refreshRate;
        this.scale = scale;
    }

    public void on() {
        driver.on();
    }

    public void off() {
        driver.off();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }
}
