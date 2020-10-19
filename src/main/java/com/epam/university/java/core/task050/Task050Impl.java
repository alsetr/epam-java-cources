package com.epam.university.java.core.task050;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Task050Impl implements Task050 {
    private Map<Double, Double> visited = new HashMap<>();
    private Map<Double, Double> items = new HashMap<>();

    @Override
    public double calculate(int size, Map<Double, Double> items) {
        this.items = items;
        if (size == 0 || items == null) {
            throw new IllegalArgumentException();
        }
        double currentWeight = 0;
        double currentPrice = 0;
        while (currentWeight < size) {
            Map.Entry<Double, Double> entry = findMaxCost((size - currentWeight));
            currentWeight += entry.getValue();
            currentPrice += entry.getKey();
        }
        return currentPrice;
    }


    private Map.Entry<Double, Double> findMaxCost(double size) {
        Map.Entry<Double, Double> maxCost = null;
        for (Map.Entry<Double, Double> entry : items.entrySet()) {
            if (maxCost == null) {
                maxCost = entry;
            }
            if (entry.getKey() > maxCost.getKey()
                    && !visited.entrySet().contains(entry) && entry.getValue() <= size) {
                maxCost = entry;
            }
        }
        visited.put(maxCost.getKey(), maxCost.getValue());
        return maxCost;
    }



}
