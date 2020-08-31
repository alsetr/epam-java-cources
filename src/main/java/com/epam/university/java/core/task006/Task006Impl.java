package com.epam.university.java.core.task006;

import java.util.Collection;
import java.util.Iterator;

public class Task006Impl implements Task006 {
    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException();
        }
        Iterator<Measurement> iterator = measurements.iterator();
        double numerator = 0;
        double denominator = 0;
        while (iterator.hasNext()) {
            Measurement current = iterator.next();
            numerator += current.getAmperage() * current.getVoltage();
            denominator += current.getAmperage() * current.getAmperage();
        }
        return numerator / denominator;
    }
}
