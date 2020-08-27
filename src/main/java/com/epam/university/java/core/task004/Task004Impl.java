package com.epam.university.java.core.task004;

import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        checkArguments(first, second);
        ArrayList<String> intersection = new ArrayList<>();
        for (String f: first) {
            for (String s: second) {
                if (s.equals(f)) {
                    intersection.add(s);
                }
            }
        }
        String[] res = new String[0];
        return intersection.toArray(res);
    }

    @Override
    public String[] union(String[] first, String[] second) {
        checkArguments(first, second);
        ArrayList<String> union = new ArrayList<>(Arrays.asList(first));
        for (String s: second) {
            if (!union.contains(s)) {
                union.add(s);
            }
        }
        String[] res = new String[0];
        return union.toArray(res);
    }

    private void checkArguments(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
    }
}
