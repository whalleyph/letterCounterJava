package org.academy.lettercounter;

import java.util.*;

public class LetterCounter {
    private Map<Character, Integer> countedLetters;

    public LetterCounter() {
        countedLetters = new HashMap<>();
    }

    public void countAll(String word) {
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            countOneLetter(word.charAt(i));
        }
    }

    public List<String> generateReport() {
        List<String> report = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry: countedLetters.entrySet()) {
            report.add(entry.getKey() + ": " + entry.getValue());
        }
        Collections.sort(report);
        return report;
    }

    public int getCountForLetter(char letter) {
        if (countedLetters.get(Character.toLowerCase(letter)) == null) {
            return 0;
        } else return countedLetters.get(Character.toLowerCase(letter));
    }

    public void countOneLetter(Character inputLetter) {
        inputLetter = Character.toLowerCase(inputLetter);
        char[] alphabet = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        boolean found = false;
        for (char c : alphabet) {
            if (inputLetter == c) {
                found = true;
                break;
            }
        }
        if (found) {
            if (countedLetters.containsKey(inputLetter)) {
                countedLetters.put(inputLetter, countedLetters.get(inputLetter) + 1);
            } else {
                countedLetters.put(inputLetter, 1);
            }
        }
    }
}
