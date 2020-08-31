package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {
    @Override
    public PiHolder findPi(int digits) {
        if (digits < 1 || digits > 10) {
            throw new IllegalArgumentException();
        }
        int bottomBorder = (int) Math.pow(10, digits - 1);
        int upperBorder = (int) Math.pow(10, digits) - 1;
        int bottomDivider;
        int upperDivider;
        double difference = 1000;
        PiHolder result = null;
        for (int i = bottomBorder * 3; i < upperBorder; i++) {
            upperDivider = i / 3;
            bottomDivider = i / 4;
            for (int j = upperDivider; j > bottomDivider; j--) {
                if (Math.abs(((double) i / (double) j) - Math.PI) < difference) {
                    result = new PiHolderImpl(i, j);
                    difference = Math.abs(((double) i / (double) j) - Math.PI);
                }
            }
        }
        return result;
    }
}
