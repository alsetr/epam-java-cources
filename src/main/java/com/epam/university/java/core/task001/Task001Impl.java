package com.epam.university.java.core.task001;

public class Task001Impl implements Task001 {
    private static double f;
    private static double s;

    @Override
    public double addition(String firstNumber, String secondNumber) {
        checkArgument(firstNumber, secondNumber);
        return f + s;
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        checkArgument(firstNumber, secondNumber);
        return f - s;
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        checkArgument(firstNumber, secondNumber);
        return f * s;
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        checkArgument(firstNumber, secondNumber);
        return f / s;
    }

    private void checkArgument(String firstNumber, String secondNumber) {
        if (firstNumber == null || secondNumber == null) {
            throw new IllegalArgumentException();
        }
        f = Double.parseDouble(firstNumber);
        s = Double.parseDouble(secondNumber);
    }
}


