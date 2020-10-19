package com.epam.university.java.core.task045;

import java.util.ArrayList;
import java.util.List;

public class Task045Impl implements Task045 {
    @Override
    public String doAnagram(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        if (input.isBlank()) {
            return input;
        }
        String[] words = input.split(" ");
        StringBuilder sb = new StringBuilder();
        char[] plain;
        char[] reversed;
        for (String word : words) {
            plain = word.toCharArray();
            reversed = new char[plain.length];
            for (int i = 0; i < plain.length; i++) {
                if (!Character.isLetter(plain[i])) {
                    reversed[i] = plain[i];
                }
            }
            List<Character> charList = new ArrayList<>();
            for (char c : plain) {
                charList.add(c);
            }
            charList.removeIf(character -> !Character.isLetter(character));
            int index = reversed.length - 1;
            for (Character c : charList) {
                if ((reversed[index]) != Character.MIN_VALUE) {
                    while ((reversed[index]) != Character.MIN_VALUE) {
                        index--;
                    }
                }
                reversed[index] = c;
                index--;
            }
            sb.append(reversed);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
