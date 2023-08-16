package dev.donkz.demuyz.core.util.logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Logger {

    public enum Level {
        VERBOSE, INFO, DEBUG, ERROR;
    }

    private final int LINE_LIMIT = 10000;
    private static final String DEFAULT_NAME = "LOGGER";
    private PrintStream out;
    private int logCount = 0;

    private final String name;
    private final Level[] levels;
    private final boolean inFile;

    public Logger() {
        this(DEFAULT_NAME, new Level[]{Level.VERBOSE, Level.INFO, Level.DEBUG, Level.ERROR});
    }

    public Logger(boolean inFile) {
        this(DEFAULT_NAME, new Level[]{Level.VERBOSE, Level.INFO, Level.DEBUG, Level.ERROR}, inFile);
    }

    public Logger(String name, boolean inFile) {
        this(name, new Level[]{Level.VERBOSE, Level.INFO, Level.DEBUG, Level.ERROR}, inFile);
    }

    public Logger(String name, Level[] levels) {
        this(name, levels, true);
    }

    public Logger(String name, Level[] levels, boolean inFile) {
        this.name = name;
        this.levels = levels;
        this.inFile = inFile;
        if (this.inFile) {
            this.out = this.switchFile();
        } else {
            this.out = System.out;
        }
    }

    private PrintStream switchFile() {
        Path path = Paths.get(String.format("logs/%s%d.txt", this.name, logCount / LINE_LIMIT)).toAbsolutePath();
        try {
            Files.createDirectories(path.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new PrintStream(path.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void log(Level level, String message, String... tags) {
        if (Arrays.asList(this.levels).contains(level)) {
            String color = "", reset = "";
            if (!this.inFile) {
                color = ConsoleColor.valueOf(level.name()).colorCode;
                reset = ConsoleColor.RESET.colorCode;
            }
            String format = "%s[%s][%s]%-5s %s %s";
            if (this.inFile && logCount % LINE_LIMIT == 0) {
                this.out = switchFile();
            }
            String desc = tags.length > 0 ? Arrays.stream(tags).collect(Collectors.joining("][", "[", "]")) : "";
            this.out.printf((format) + "%n", color, name, level.name(), desc, message, reset);
            this.logCount++;
        }
    }

    public void info(String message) {
        this.log(Level.INFO, message);
    }

    public void verbose(String message) {
        this.log(Level.VERBOSE, message);
    }

    public void debug(String message) {
        this.log(Level.DEBUG, message);
    }

    public void error(String message) {
        this.log(Level.ERROR, message);
    }

    public void info(String message, String... tags) {
        this.log(Level.INFO, message, tags);
    }

    public void verbose(String message, String... tags) {
        this.log(Level.VERBOSE, message, tags);
    }

    public void debug(String message, String... tags) {
        this.log(Level.DEBUG, message, tags);
    }

    public void error(String message, String... tags) {
        this.log(Level.ERROR, message, tags);
    }

}
