package com.javarush.constants;

@SuppressWarnings("ALL")
public class CryptoAlphabet {
    private static final String lettersUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lettersLowerCAse = "abcdefghijklmnopqrstuvwxyz";
    private static final String numbers = "0123456789";
    private static final String symbols = ".,':-!?—";
    private static final String uaLettersUpperCase= "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";
    private static final String uaLettersLowerCAse= "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
    public static final String ALPHABET = lettersUpperCase + lettersLowerCAse ;
    public static final String UA_ALPHABET = uaLettersUpperCase + uaLettersLowerCAse;
    public static final String SYMBOLS = numbers + symbols + "\n" + " ";

}
