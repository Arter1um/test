package com.javarush.constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CryptoDictionary {
    public static final Set<String> COMMON_ENGLISH_WORDS = new HashSet<>(Arrays.asList(
            "the", "be", "to", "of", "and", "a", "in", "that", "have", "I",
            "it", "for", "not", "on", "with", "he", "as", "you", "do", "at"
    ));

    public static final Set<String> COMMON_UKRAINIAN_WORDS = new HashSet<>(Arrays.asList(
            "бути", "він", "для", "його",
            "але", "вона", "щоб", "від", "все", "так", "вже", "також",
            "був", "вони", "якщо", "або", "які", "тут",
            "може", "було", "ми", "цього", "нього", "вона",
            "цей", "йому", "коли", "була",  "мене", "мені",  "цьому",
            "тому", "ним", "їхній", "тебе", "вас", "ними", "своє", "цієї"
    ));

}
