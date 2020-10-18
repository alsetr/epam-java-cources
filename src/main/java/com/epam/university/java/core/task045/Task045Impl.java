package com.epam.university.java.core.task045;

import java.nio.charset.CharsetEncoder;
import java.util.Arrays;

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
            outer :
            for (int i = 0; i < plain.length; i++) {



//                if (Character.isLetter(plain[i])) {
//                    if (reversed[plain.length - 1 - i] == Character.MIN_VALUE) {
//                        reversed[plain.length - 1 - i] = plain[i];
//                    } else {
//                        int k = plain.length - 1 - i;
//                        while (reversed[k] != Character.MIN_VALUE) {
//                            k--;
//                        }
//                        reversed[k] = plain[i];
//                        for (char c : reversed) {
//                            int count = 0;
//                            if (c == Character.MIN_VALUE) {
//                                break;
//                            } else {
//                                count++;
//                            }
//                            if (count == reversed.length) {
//                                break outer;
//                            }
//                        }
//                    }
//                } else {
//
//                }
            }
            sb.append(reversed);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
