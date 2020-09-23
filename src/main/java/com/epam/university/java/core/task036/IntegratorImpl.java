package com.epam.university.java.core.task036;

import java.util.function.Function;

public class IntegratorImpl implements Integrator {
    @Override
    public double integrate(double left, double right, Function<Double, Double> function) {
        double sum = 0;
        while (left <= right) {
            sum += function.apply(left) * 0.000001;
            left = left + 0.000001;
        }
        return sum;
    }
}
