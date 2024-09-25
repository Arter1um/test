package com.javarush.constants;

import java.util.HashMap;
import java.util.Map;

public class LetterFrequencies {
    public static final Map<Character, Double> ENGLISH_LETTER_FREQUENCIES = new HashMap<>();
    public static final Map<Character, Double> UKRAINIAN_LETTER_FREQUENCIES = new HashMap<>();

    static {
        // Частоти символів англійської мови
        ENGLISH_LETTER_FREQUENCIES.put('e', 12.70);
        ENGLISH_LETTER_FREQUENCIES.put('t', 9.06);
        ENGLISH_LETTER_FREQUENCIES.put('a', 8.17);
        ENGLISH_LETTER_FREQUENCIES.put('o', 7.51);
        ENGLISH_LETTER_FREQUENCIES.put('i', 6.97);
        ENGLISH_LETTER_FREQUENCIES.put('n', 6.75);
        ENGLISH_LETTER_FREQUENCIES.put('s', 6.33);
        ENGLISH_LETTER_FREQUENCIES.put('h', 6.09);
        ENGLISH_LETTER_FREQUENCIES.put('r', 5.99);
        ENGLISH_LETTER_FREQUENCIES.put('d', 4.25);
        ENGLISH_LETTER_FREQUENCIES.put('l', 4.03);
        ENGLISH_LETTER_FREQUENCIES.put('c', 2.78);
        ENGLISH_LETTER_FREQUENCIES.put('u', 2.76);
        ENGLISH_LETTER_FREQUENCIES.put('m', 2.41);
        ENGLISH_LETTER_FREQUENCIES.put('w', 2.36);
        ENGLISH_LETTER_FREQUENCIES.put('f', 2.23);
        ENGLISH_LETTER_FREQUENCIES.put('g', 2.02);
        ENGLISH_LETTER_FREQUENCIES.put('y', 1.97);
        ENGLISH_LETTER_FREQUENCIES.put('p', 1.93);
        ENGLISH_LETTER_FREQUENCIES.put('b', 1.49);
        ENGLISH_LETTER_FREQUENCIES.put('v', 0.98);
        ENGLISH_LETTER_FREQUENCIES.put('k', 0.77);
        ENGLISH_LETTER_FREQUENCIES.put('j', 0.15);
        ENGLISH_LETTER_FREQUENCIES.put('x', 0.15);
        ENGLISH_LETTER_FREQUENCIES.put('q', 0.10);
        ENGLISH_LETTER_FREQUENCIES.put('z', 0.07);

        // Частоти символів української мови
        UKRAINIAN_LETTER_FREQUENCIES.put('а', 782.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('о', 743.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('и', 538.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('в', 522.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('н', 384.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('і', 363.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('к', 360.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('р', 343.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('т', 334.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('е', 328.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('с', 309.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('л', 307.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('у', 278.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('д', 284.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('п', 226.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('м', 215.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('з', 217.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('б', 163.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('г', 141.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('й', 147.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('я', 144.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('ш', 145.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('ч', 123.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('ь', 116.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('х', 83.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('ж', 75.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('ю', 70.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('є', 13.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('ї', 21.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('щ', 25.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('ц', 44.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('ґ', 2.0);
        UKRAINIAN_LETTER_FREQUENCIES.put('ф', 2.0);
    }
}
