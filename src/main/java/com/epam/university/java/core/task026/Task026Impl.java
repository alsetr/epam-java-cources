package com.epam.university.java.core.task026;

public class Task026Impl implements Task026 {
    @Override
    public String encrypt(String sourceString, int shift) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        char current;
        for (int i = 0; i < sourceString.length(); i++) {
            current = sourceString.charAt(i);
            if (Character.isLetter(current)) {
                if (Character.isUpperCase(current)) {
                    current = (char) (current + shift % 26);
                    if (current > 'Z') {
                        current = (char) (current - 26);
                    }
                } else {
                    current = (char) (current + shift % 26);
                    if (current > 'z') {
                        current = (char) (current - 26);
                    }
                }
            }
            sb.append(current);
        }
        return sb.toString();
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        if (encryptedString == null) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        char current;
        char m;
        for (int i = 0; i < encryptedString.length(); i++) {
            current = m = encryptedString.charAt(i);
            if (Character.isLetter(current)) {
                if (Character.isUpperCase(current)) {
                    current = (char) (current - shift % 26);
                    if (current < 'A') {
                        current = (char) (current + 26);
                    }
                } else {
                    current = (char) (current - shift % 26);
                    if (current < 'a') {
                        current = (char) (current + 26);
                    }
                }
            }
            sb.append(current);
        }
        return sb.toString();
    }
}
