package com.epam.university.java.core.task027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Task027Impl implements Task027 {
    @Override
    public Collection<Integer> extract(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        List<Integer> trial = new ArrayList<>();
        boolean isOrdered = false;
        if (sourceString.charAt(0) == '0') {
            return trial;
        }
        for (int i = 1; i < 6; i++) {
            trial = divideString(sourceString, i);
            for (int j = 0; j < trial.size() - 1; j++) {
                if (trial.get(j) + 1 != trial.get(j + 1)) {
                    break;
                }
            }
            for (int j = 0; j < trial.size() - 1; j++) {
                if (trial.get(j) + 1 == trial.get(j + 1)) {
                    isOrdered = true;
                } else {
                    isOrdered = false;
                    break;
                }
            }
            if (isOrdered) {
                break;
            }
        }
        if (!isOrdered) {
            return new ArrayList<>();
        }
        return trial;
    }

    private List<Integer> divideString(String source, int digits) {
        List<Integer> list = new ArrayList<>();
        String sub;
        for (int i = 0; i < source.length();) {
            if (i < source.length() - (digits - 1)) {
                sub = source.substring(i, i + digits);
                if (sub.charAt(sub.length() - 1) == '9') {
                    i = i + digits;
                    digits += 1;
                } else {
                    i = i + digits;
                }
                list.add(Integer.parseInt(sub));
            } else {
                sub = source.substring(i);
                list.add(Integer.parseInt(sub));
                break;
            }
        }
        return list;
    }
}
