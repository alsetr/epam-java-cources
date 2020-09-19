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
        int[] source = new int[sourceString.length()];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < sourceString.length(); i++) {
            source[i] = Integer.parseInt(String.valueOf(sourceString.charAt(i)));
        }
        return null;
    }
}
