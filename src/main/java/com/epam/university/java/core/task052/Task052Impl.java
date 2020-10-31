package com.epam.university.java.core.task052;

public class Task052Impl implements Task052 {

    @Override
    public boolean validateCard(long number) {
        if (number < 10000) {
            throw new IllegalArgumentException();
        }
        int lastDigit = (int) (number % 10);
        number = number / 10;
        String[] split = new StringBuilder(String.valueOf(number))
                .reverse().toString().split("");
        int[] ints = new int[split.length];
        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            if (i % 2 == 0) {
                ints[i] = Integer.parseInt(split[i]) * 2;
                if (ints[i] >= 10) {
                    ints[i] = ints[i] % 10 + ints[i] / 10;
                }
            } else {
                ints[i] = Integer.parseInt(split[i]);
            }
            sum += ints[i];
        }
        return (10 - sum % 10) == lastDigit;
    }
}
