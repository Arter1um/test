package com.javarush.services;

import com.javarush.constants.CryptoAlphabet;
import com.javarush.constants.LetterFrequencies;
import com.javarush.entity.Result;
import com.javarush.exception.ApplicationException;
import com.javarush.repository.ResultCode;

import java.util.*;

public class StaticAnaliz implements Function{
    private final FileService fileService = FileService.getInstance();
    private final FileNameGenerator fileNameGenerator = new FileNameGenerator();
    @Override
    public Result executes(String[] parameters) {
        String filePath = parameters[2];
        String language = parameters[3];
        try {
            String encryptedText = fileService.readFile(filePath);
            encryptedText = encryptedText.toLowerCase();

            String decryptedMessage = performStaticAnalysis(encryptedText, language);

            if (decryptedMessage == null){
                throw new ApplicationException("Не вдалось розшифрувати текст за допомогою статистичного аналізу");
            }

            String outputFilePath = fileNameGenerator.generateOutputFilePath(filePath, "staticAnaliz");
            fileService.writeFile(outputFilePath,decryptedMessage);

            System.out.println("Розшифрований текст збережено до: " + outputFilePath);

            return new Result(ResultCode.OK);
        } catch (Exception e) {
            return new Result(ResultCode.ERROR, new ApplicationException("Помилка розшифрування Статистичним аналізом.", e));
        }
    }
    private String performStaticAnalysis(String encryptedText, String language) {
        Map<Character, Double> charFrequency = calculateCharFrequency(encryptedText);

        List<Map.Entry<Character, Double>> sortedEntries = sortFrequencyMap(charFrequency);
        List<Map.Entry<Character, Double>> sortedEntriesEnglishLetters = sortFrequencyMap(LetterFrequencies.ENGLISH_LETTER_FREQUENCIES);
        List<Map.Entry<Character, Double>> sortedEntriesUkrainianLetters = sortFrequencyMap(LetterFrequencies.UKRAINIAN_LETTER_FREQUENCIES);
        String textLanguage = language;
        String decryptedText = encryptedText;

        boolean isEnglish = language.equals("1");

        List<Map.Entry<Character, Double>> sortedEntriesFromLanguage = isEnglish? sortedEntriesEnglishLetters : sortedEntriesUkrainianLetters;
        for (int i = 0; i < Math.min(sortedEntriesFromLanguage.size(), sortedEntries.size()); i++) {
            char encryptedChar = sortedEntriesFromLanguage.get(i).getKey();
            char targetChar = sortedEntries.get(i).getKey();
            decryptedText = replaceCharacters(decryptedText, targetChar,encryptedChar);

            Map<Character, Double> updatedFrequency = calculateCharFrequency(decryptedText);
            sortedEntries = sortFrequencyMap(updatedFrequency);
        }
        System.out.println(decryptedText);
        System.out.println("Чи правильний текст? Введіть 'yes' для підтвердження або здійсніть корекцію через replaceCharacters:");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("yes")) {
                break;
            } else {
                System.out.println("Введіть символ, який потрібно замінити:");
                char char1 = scanner.next().charAt(0);
                System.out.println("Введіть символ, на який потрібно замінити:");
                char char2 = scanner.next().charAt(0);

                decryptedText = replaceCharacters(decryptedText, char1, char2);
                System.out.println(decryptedText);

                System.out.println("Замінено! Продовжуйте розгляд розшифрованого тексту. Введіть 'yes', якщо текст вірний:");
                scanner.nextLine();
            }
        }

        scanner.close();

        return decryptedText;
    }
    private String replaceCharacters(String text, char char1, char char2) {
        text = text.replace(char1, '@').replace(char2, '§');
        text = text.replace('@',char2).replace('§', char1);
        return text;
    }

    private Map<Character, Double> calculateCharFrequency(String text) {
        Map<Character, Double> frequencyMap = new HashMap<>();
        for (char ch : text.toLowerCase().toCharArray()) {
            if(CryptoAlphabet.ALPHABET.contains(String.valueOf(ch)) || CryptoAlphabet.UA_ALPHABET.contains(String.valueOf(ch))) {
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0.0) + 1);
            }
        }
        return frequencyMap;
    }
    private List<Map.Entry<Character, Double>> sortFrequencyMap(Map<Character, Double> frequencyMap) {
        List<Map.Entry<Character, Double>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());

        sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        return sortedEntries;
    }


}
