package com.epam.university.java.core.task051;

import java.util.List;

public class Task051Impl implements Task051 {

    @Override
    public String replace(String source) {
        if (source == null || source.isEmpty() || source.isBlank()) {
            throw new IllegalArgumentException();
        }
        String[] strings = source.split(" ");
        if (strings.length == 1 || Character.isUpperCase(strings[0].charAt(0))) {
            throw new IllegalArgumentException();
        }
        List<Character> vowels = List.of('a', 'e', 'i', 'y', 'u', 'o');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals("the")) {
                if (vowels.contains(strings[i + 1].charAt(0))) {
                    strings[i] = "an";
                } else {
                    strings[i] = "a";
                }
            }
            sb.append(strings[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
