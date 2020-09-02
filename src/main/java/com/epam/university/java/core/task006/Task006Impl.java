package com.epam.university.java.core.task006;

import java.util.Collection;
import java.util.Iterator;

public class Task006Impl implements Task006 {
    @Override
    public double resistance(Collection<Measurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException();
        }
        if (measurements.isEmpty()) {
            return 0;
        }
        int n = measurements.size();
        double sumOfI = 0;
        double sumOfU = 0;
        double sumOfUi = 0;
        double sumOfISquared = 0;
        for (Measurement m: measurements) {
            sumOfI += m.getAmperage();
            sumOfU += m.getVoltage();
            sumOfUi += m.getVoltage() * m.getAmperage();
            sumOfISquared += m.getAmperage() * m.getAmperage();
        }
        double averageI = sumOfI / n;
        double averageU = sumOfU / n;
        double averageUi = sumOfUi / n;
        double averageISquared = sumOfISquared / n;
        double res = (averageUi - averageI * averageU) / (averageISquared - averageI * averageI);
        if (Double.isNaN(res)) {
            return 0;
        }
        return (double) Math.round(res * 1000) / 1000;

    }
}
