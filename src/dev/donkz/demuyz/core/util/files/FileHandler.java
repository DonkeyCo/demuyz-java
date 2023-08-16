package dev.donkz.demuyz.core.util.files;

import java.io.FileInputStream;
import java.io.IOException;

public class FileHandler {
    public static byte[] readFile(String filePath) {
        try (FileInputStream stream = new FileInputStream(filePath)) {
            byte[] b = stream.readAllBytes();
            return b;
        } catch (IOException e) {
            System.out.println("File not found");
            return null;
        }
    }
}
