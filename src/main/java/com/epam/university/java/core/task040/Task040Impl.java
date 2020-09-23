package com.epam.university.java.core.task040;

public class Task040Impl implements Task040 {
    @Override
    public int countScore(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String[] attempts = str.split(" ");
        int score = 0;
        for (String frame : attempts) {

        }
        return 0;
    }
}
