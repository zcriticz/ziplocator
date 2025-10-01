package com.github.zcriticz.ziplocator.util;

public class ZipWriter {
    public static void writeToFile(String filename, String content) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filename)) {
            writer.write(content);
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void moveToFile(String source, String destination) {
        java.nio.file.Path sourcePath = java.nio.file.Paths.get(source);
        java.nio.file.Path destinationPath = java.nio.file.Paths.get(destination);
        try {
            java.nio.file.Files.move(sourcePath, destinationPath, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("Error moving file: " + e.getMessage());
        }
    }
}

