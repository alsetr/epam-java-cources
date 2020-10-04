package com.epam.university.java.core.task028;

public class Task028Impl implements Task028 {
    @Override
    public int getWays(int value, int power) {
        return numberOfWays(value, power, 1);
    }

    private int numberOfWays(int value, int power, int start) {
        int difference = (int) (value - Math.pow(start, power));
        if (difference == 0) {
            return 1;
        }
        if (difference < 0) {
            return 0;
        }
        return numberOfWays(value, power, start + 1)
                + numberOfWays(difference, power, start + 1);
    }
}
