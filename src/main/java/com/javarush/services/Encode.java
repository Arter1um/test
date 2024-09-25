package com.javarush.services;

import com.javarush.entity.Result;
import com.javarush.exception.ApplicationException;
import com.javarush.repository.ResultCode;


public class Encode implements Function {
    private final FileService fileService = FileService.getInstance();
    private final FileNameGenerator fileNameGenerator = new FileNameGenerator();
    private final CaesarCipher caesarCipher = new CaesarCipher();

    @Override
    public Result executes(String[] parameters) {
        try {
            String filePath = parameters[2];
            String content = fileService.readFile(filePath);
            int key = Integer.parseInt(parameters[1]);

            String encodedMessage = caesarCipher.encrypt(content, key);
            String outputFilePath = fileNameGenerator.generateOutputFilePath(filePath, "encrypt");
            fileService.writeFile(outputFilePath, encodedMessage);

            System.out.println("Зашифроване повідомлення:\n" + encodedMessage);
            System.out.println("Ключ = " + key);
            return new Result(ResultCode.OK);
        } catch (Exception e) {
            return new Result(ResultCode.ERROR, new ApplicationException("Помилка шифрування", e));
        }
    }
}