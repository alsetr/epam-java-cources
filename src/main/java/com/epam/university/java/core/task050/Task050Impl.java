package com.epam.university.java.core.task050;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Task050Impl implements Task050 {
    private Map<Double, Double> itemsMap = new HashMap<>();

    @Override
    public double calculate(int size, Map<Double, Double> items) {
        if (items == null || size == 0) {
            throw new IllegalArgumentException();
        }
        this.itemsMap = new HashMap<>(items);
        double summaryCost = 0;
        double summaryMass = 0;
        Map.Entry<Double, Double> costlyItem;
        double itemUnitCost;
        double itemMass;
        while (summaryMass < size) {
            costlyItem = findMaxCost();
            if (costlyItem.getKey() == 0) {
                break;
            }
            itemMass = costlyItem.getValue();
            itemUnitCost = costlyItem.getKey() / costlyItem.getValue();
            if (itemMass >= size - summaryMass) {
                summaryCost += (size - summaryMass) * itemUnitCost;
                summaryMass += size - summaryMass;
            } else if (itemMass < size - summaryMass) {
                summaryCost += costlyItem.getKey();
                summaryMass += itemMass;
            }
        }
        return Double
                .parseDouble(String
                        .format(Locale.ENGLISH, "%.3f", summaryCost));
    }


    private Map.Entry<Double, Double> findMaxCost() {
        Map.Entry<Double, Double> maxCost = new Map.Entry<Double, Double>() {
            @Override
            public Double getKey() {
                return 0.0;
            }

            @Override
            public Double getValue() {
                return 0.0;
            }

            @Override
            public Double setValue(Double aDouble) {
                return 0.0;
            }
        };
        double unitCost = 0;
        double currentUnitCost;
        if (itemsMap.size() == 0) {
            return maxCost;
        }
        for (Map.Entry<Double, Double> entry : itemsMap.entrySet()) {
            currentUnitCost = entry.getKey() / entry.getValue();
            if (currentUnitCost > unitCost) {
                unitCost = currentUnitCost;
                maxCost = entry;
            }
        }
        itemsMap.remove(maxCost.getKey(), maxCost.getValue());
        return maxCost;
    }
}
