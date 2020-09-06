package com.epam.university.java.core.task007;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class Task007Impl implements Task007 {
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
                                                  Collection<Integer> second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        Integer[] result = new Integer[first.size() + second.size() - 1];
        for (int i = 0; i < first.size() + second.size() - 1; i++) {
            result[i] = 0;
        }
        List<Integer> f = new ArrayList<>(first);
        List<Integer> s = new ArrayList<>(second);
        Collections.reverse(f);
        Collections.reverse(s);
        for (int i = 0; i < f.size(); i++) {
            for (int j = 0; j < s.size(); j++) {
                result[i + j] =  result[i + j] + f.get(i) * s.get(j);
            }
        }
        ArrayList<Integer> r = new ArrayList<>(Arrays.asList(result));
        Collections.reverse(r);
        return r;
    }
}
