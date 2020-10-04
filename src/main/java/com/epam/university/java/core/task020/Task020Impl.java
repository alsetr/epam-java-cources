package com.epam.university.java.core.task020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task020Impl implements Task020 {
    @Override
    public int calculate(Collection<String> stones) {
        if (stones == null || stones.isEmpty()) {
            throw new IllegalArgumentException();
        }
        List<String> stonesList = new ArrayList<>(stones);
        Set<String> gems = new HashSet<>(Arrays.asList(stonesList.get(0).split("")));
        int result = 0;
        int matchNeeded;
        int matchCurrent;
        for (String gem : gems) {
            matchCurrent = 0;
            for (String s : stonesList) {
                matchNeeded = stonesList.size();
                if (s.contains(gem)) {
                    matchCurrent++;
                }
                if (matchCurrent == matchNeeded) {
                    result++;
                }
            }
        }
        return result;
    }
}
