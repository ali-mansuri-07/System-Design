package com.flyweightdesignpattern.wordprocessor.solution;

import java.util.HashMap;
import java.util.Map;

public class LetterFactory {
    public static final Map<Character, ILetter> letterMapCache = new HashMap<>();

    public static ILetter createLetter(char character) {
        if (!letterMapCache.containsKey(character)) {
            // For simplicity, we are using default fontType and size
            letterMapCache.put(character, new DocumentCharacter(character, "Arial", 12));
            return letterMapCache.get(character);
        } else {
            DocumentCharacter existingCharacter = (DocumentCharacter) letterMapCache.get(character);
            letterMapCache.put(character, new DocumentCharacter(character, "Arial", 10));
            return existingCharacter;
        }
    }

    public int getTotalLetters() {
        return letterMapCache.size();
    }
}
