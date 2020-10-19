package com.epam.university.java.core.task049;

import java.util.ArrayList;
import java.util.List;

public class Task049Impl implements Task049 {
    @Override
    public String getResultList(String first, String second) {
        if (first == null || second == null || first.isBlank() || second.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (first.equals(second)) {
            return first;
        }
        StringBuilder sb = new StringBuilder();
        List<String> substrings = new ArrayList<>();
        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();
        outer:
        for (int i = 0; i < firstArray.length; i++) {
            for (int j = 0; j < secondArray.length; j++) {
                if (firstArray[i] == secondArray[j]) {
                    sb.append(firstArray[i]);
                    i++;
                    if (i >= firstArray.length) {
                        substrings.add(sb.toString());
                        break outer;
                    }
                } else {
                    if (!sb.toString().isEmpty()) {
                        substrings.add(sb.toString());
                        sb = new StringBuilder();
                    }
                }
            }
        }
        String answer = null;
        int maxLength = 0;
        for (String s : substrings) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                answer = s;
            }
        }
        return answer;
    }
}
