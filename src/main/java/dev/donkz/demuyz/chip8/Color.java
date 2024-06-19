package main.java.dev.donkz.demuyz.chip8;

public enum Color {
    BLACK(new main.java.dev.donkz.demuyz.core.base.Color(0, 0, 0)),
    WHITE(new main.java.dev.donkz.demuyz.core.base.Color(255, 255, 255));

    public final main.java.dev.donkz.demuyz.core.base.Color color;
    Color(main.java.dev.donkz.demuyz.core.base.Color color) {
        this.color = color;
    }

    public int red() {
        return color.r();
    }

    public int green() {
        return color.g();
    }

    public int blue() {
        return color.b();
    }
}
