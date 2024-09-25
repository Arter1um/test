package com.javarush.services;

public class FileNameGenerator {
    public String generateOutputFilePath(String inputFilePath, String command) {
        int dotIndex = inputFilePath.lastIndexOf('.');
        String outputFilePath = null;
        if(command.equalsIgnoreCase("encrypt")) {
            outputFilePath = inputFilePath.substring(0,dotIndex) + "_encrypt.txt";
        } else if (command.equalsIgnoreCase("decrypt")) {
            outputFilePath = inputFilePath.substring(0,dotIndex) + "_decrypt.txt";
        } else if (command.equalsIgnoreCase("bruteforce")) {
            outputFilePath = inputFilePath.substring(0,dotIndex) + "bruteforce.txt";
        } else if (command.equalsIgnoreCase("staticAnaliz")){
            outputFilePath = inputFilePath.substring(0,dotIndex) + "_static.txt";
        } else {
                System.out.println("Невідома команда " + command);
            return outputFilePath;
            }
        return outputFilePath;
    }

}
