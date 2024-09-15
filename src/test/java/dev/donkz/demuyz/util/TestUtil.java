package dev.donkz.demuyz.util;

import dev.donkz.demuyz.timendus.SplashScreenTest;
import main.java.dev.donkz.demuyz.chip8.Chip8;
import main.java.dev.donkz.demuyz.core.util.logger.Logger;
import main.java.dev.donkz.demuyz.swing.SwingDriver;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestUtil {
    public static void runTestFile(String filename) throws FileNotFoundException {
        Logger logger = new Logger(false);
        SwingDriver swingDriver = new SwingDriver(64, 32, 5);
        Chip8 chip8 = new Chip8(swingDriver, swingDriver.getInputDriver(), logger);

        URL resourceUrl = SplashScreenTest.class.getClassLoader().getResource(filename);

        if (resourceUrl == null) {
            System.out.println("Resource was not found.");
            throw new FileNotFoundException();
        }

        try {
            Path path = Paths.get(resourceUrl.toURI());
            chip8.loadROM(path.toAbsolutePath().toString());
            chip8.start();
        } catch (URISyntaxException e) {
            throw new FileNotFoundException();
        }
    }
}
