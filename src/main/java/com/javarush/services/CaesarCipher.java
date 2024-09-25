package com.javarush.services;


import com.javarush.constants.CryptoAlphabet;

public class CaesarCipher {
    public String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

            for (char character : text.toCharArray()) {
                String alphabet = determineAlphabet(character);
                if (alphabet != null) {
                    int index = alphabet.indexOf(character);
                    int newIndex = (index + shift) % alphabet.length();

                    if (newIndex < 0) {
                        newIndex += alphabet.length();
                    }

                    result.append(alphabet.charAt(newIndex));
                } else {
                    result.append(character);
                }
            }
        return result.toString();
    }

    private String determineAlphabet(char character) {
        if (CryptoAlphabet.ALPHABET.indexOf(character) != -1) {
            return CryptoAlphabet.ALPHABET;
        } else if (CryptoAlphabet.UA_ALPHABET.indexOf(character) != -1) {
            return CryptoAlphabet.UA_ALPHABET;
        } else {
            return null;
        }
    }
}