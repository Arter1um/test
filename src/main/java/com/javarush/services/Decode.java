package com.javarush.services;

import com.javarush.entity.Result;
import com.javarush.constants.CryptoAlphabet;
import com.javarush.exception.ApplicationException;
import com.javarush.repository.ResultCode;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Decode implements Function {

    private final FileService fileService = FileService.getInstance();
    private final FileNameGenerator fileNameGenerator = new FileNameGenerator();

    @Override
    public Result executes(String[] parameters) {
        try {
            String inputFilePath = parameters[2];
            int key = Integer.parseInt(parameters[1]);

            String content = fileService.readFile(inputFilePath);
            String decodedMessage = decryptMessage(content, key);

            String outputFilePath = fileNameGenerator.generateOutputFilePath(inputFilePath, "decrypt");
            fileService.writeFile(outputFilePath, decodedMessage);

            System.out.println("Розшифроване повідомлення:\n" + decodedMessage);
            System.out.println("Ключ = " + key);
            return new Result(ResultCode.OK);
        } catch (FileNotFoundException e) {
            return new Result(ResultCode.ERROR, new ApplicationException("Файл не знайдено", e));
        } catch (NumberFormatException e) {
            return new Result(ResultCode.ERROR, new ApplicationException("Некоректний ключ", e));
        } catch (IOException e) {
            return new Result(ResultCode.ERROR, new ApplicationException("Помилка вводу/виводу", e));
        }
    }

    private String decryptMessage(String encryptedText, int key) {
        CaesarCipher caesarCipher = new CaesarCipher();
        return caesarCipher.encrypt(encryptedText, -key); // Використовуємо шифрування з від'ємним ключем для розшифрування
    }
}
