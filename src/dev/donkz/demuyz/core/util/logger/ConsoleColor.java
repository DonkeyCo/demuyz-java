package dev.donkz.demuyz.core.util.logger;

public enum ConsoleColor {
    VERBOSE("\033[0;37m"),
    INFO("\033[0;34m"),
    DEBUG("\033[0;33m"),
    ERROR("\033[0;31m"),
    RESET("\033[0m");

    public final String colorCode;
    ConsoleColor(String colorCode) {
        this.colorCode = colorCode;
    }
}
