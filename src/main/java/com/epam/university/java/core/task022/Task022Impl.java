package com.epam.university.java.core.task022;

import java.util.Collection;
import java.util.Comparator;

public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        check(numbers);
        Integer min = numbers.stream().min(Comparator.naturalOrder()).get();
        Integer s = 0;
        for (Integer i : numbers) {
            s = s + i;
        }
        return s - min;
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        check(numbers);
        Integer max = numbers.stream().max(Comparator.naturalOrder()).get();
        Integer s = 0;
        for (Integer i : numbers) {
            s = s + i;
        }
        return s - max;
    }

    private void check(Collection<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
