package com.javarush.services;

import com.javarush.constants.CryptoAlphabet;
import com.javarush.entity.Result;
import com.javarush.exception.ApplicationException;
import com.javarush.repository.ResultCode;
import com.javarush.constants.CryptoDictionary;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class BruteForce implements Function {
    private final FileService fileService = FileService.getInstance();
    private final CaesarCipher caesarCipher = new CaesarCipher();
    private final FileNameGenerator fileNameGenerator = new FileNameGenerator();

    @Override
    public Result executes(String[] parameters) {
        String filePath = parameters[2];

        try {
            String encryptedText = fileService.readFile(filePath);

            int maxShift = CryptoAlphabet.ALPHABET.length();
            String decryptedMessage = null;

            for (int shift = maxShift; shift > 0; shift--) {
                String decryptedAttempt = caesarCipher.encrypt(encryptedText, shift).toLowerCase();
                System.out.println("Розшифровано ключем" + shift + ":\n" + decryptedAttempt);
                boolean isEnglish = containsCommonWords(decryptedAttempt, CryptoDictionary.COMMON_ENGLISH_WORDS);
                boolean isUkrainian = containsCommonWords(decryptedAttempt, CryptoDictionary.COMMON_UKRAINIAN_WORDS);


                if (isEnglish || isUkrainian) {
                    if (confirmDecryption(decryptedAttempt)) {
                        decryptedMessage = decryptedAttempt;
                        System.out.println(shift);
                        break;
                    }
                }
            }

            if (decryptedMessage == null) {
                throw new ApplicationException("Не вдалося розшифрувати текст за допомогою brute force.");
            }
            String outputFilePath = fileNameGenerator.generateOutputFilePath(filePath, "bruteforce");
            fileService.writeFile(outputFilePath, decryptedMessage);

            System.out.println("Розшифрований текст збережено до: " + outputFilePath);

            return new Result(ResultCode.OK);
        } catch (IOException e) {
            return new Result(ResultCode.ERROR, new ApplicationException("Помилка вводу/виводу.", e));
        } catch (Exception e) {
            return new Result(ResultCode.ERROR, new ApplicationException("Помилка розшифрування методом брутфорс.", e));
        }
    }
    private boolean containsCommonWords(String decryptedText, Set<String> commonWords) {
        String[] words = decryptedText.split("\\s+");

        int count = 0;

        for (String word : words) {
            if (commonWords.contains(word.toLowerCase())) {
                if (CryptoDictionary.COMMON_ENGLISH_WORDS.contains(word.toLowerCase())) {
                    count++;
                }
                if (CryptoDictionary.COMMON_UKRAINIAN_WORDS.contains(word.toLowerCase())) {
                    count++;
                }
            }
        }

        return (count > 10? true:false);
    }

    private boolean confirmDecryption(String decryptedText) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Це правильний розшифрований текст? (так/ні): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("так") || response.equals("т") || response.equals("yes") || response.equals("y");
    }
}
