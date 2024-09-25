package com.javarush.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileService {
    private static final FileService instance = new FileService();

    private FileService() {}

    public static FileService getInstance() {
        return instance;
    }
    public String readFile(String filePath) throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            content.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        return content.toString().trim();
    }

    public void writeFile(String filePath, String content) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write(content);
        writer.close();
    }
}