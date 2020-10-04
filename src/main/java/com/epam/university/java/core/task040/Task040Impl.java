package com.epam.university.java.core.task040;

import java.util.Arrays;

public class Task040Impl implements Task040 {
    @Override
    public int countScore(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] attempts = str.split(" ");
        int score = 0;
        String frame;
        for (int i = 0; i < attempts.length; i++) {
            frame = attempts[i];
            if (frame.contains("X")) {
                if (i != attempts.length - 1) {
                    if (i < attempts.length - 1) {
                        if (attempts[i + 1].contains("X")) {
                            if (i < attempts.length - 2) {
                                if (attempts[i + 2].contains("X")) {
                                    score += 30;
                                } else {
                                    score += 20 + Integer.parseInt(String
                                            .valueOf(attempts[i + 2].charAt(0)));
                                }
                            } else {
                                if (attempts[i + 1].contains("XX")) {
                                    score += 30;
                                } else {
                                    score += 20;
                                }
                            }
                        } else {
                            if (attempts[i + 1].contains("/")) {
                                score += 20;
                            } else {
                                score += 10 + Integer.parseInt(String
                                        .valueOf(attempts[i + 1].charAt(0))) + Integer
                                        .parseInt(String
                                                .valueOf(attempts[i + 1].charAt(1)));
                            }
                        }
                    } else {
                        score += 10;
                    }
                } else {
                    String[] finalAttempt = frame.split("");
                    for (String s : finalAttempt) {
                        if (s.equals("X")) {
                            score += 10;
                        } else {
                            score += Integer.parseInt(s);
                        }
                    }
                }
            } else if (frame.contains("/")) {
                if (i < attempts.length - 1) {
                    if (attempts[i + 1].contains("X")) {
                        score += 20;
                    } else {
                        score += 10 + Integer.parseInt(String.valueOf(attempts[i + 1].charAt(0)));
                    }
                }
            } else {
                score += Integer.parseInt(String
                        .valueOf(frame.charAt(0))) + Integer.parseInt(String
                        .valueOf(frame.charAt(1)));
            }
        }
        return score;
    }
}
