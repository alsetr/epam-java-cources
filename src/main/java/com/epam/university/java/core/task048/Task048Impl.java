package com.epam.university.java.core.task048;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task048Impl implements Task048 {
    @Override
    public Collection<Integer> getArmstrongNumbers(Integer from, Integer to) {
        if (from == null || to == null || from < 0 || to < 0) {
            throw new IllegalArgumentException();
        }
        Collection<Integer> answer = new ArrayList<>();
        for (int i = from; i <= to; i++) {
            if (isArmstrong(i)) {
                answer.add(i);
            }
        }
        return answer;
    }

    private boolean isArmstrong(int i) {
        int test = i;
        List<Integer> ints = new ArrayList<>();
        do {
            ints.add(test % 10);
            test /= 10;
        } while (test > 0);
        int digits = ints.size();
        int sum = 0;
        for (int j : ints) {
            sum += Math.pow(j, digits);
        }
        return sum == i;
    }
}
