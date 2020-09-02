package com.epam.university.java.core.task003;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        checkArguments(source);
        String[] inverted = new String[source.length];
        for (int i = 0; i < source.length; i++) {
            inverted[i] = source[source.length - i - 1];
        }
        return inverted;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        checkArguments(first, second);
        String[] result = new String[first.length + second.length];
        System.arraycopy(first, 0, result, 0, first.length);
        for (int i = 0; i < second.length; i++) {
            result[first.length + i] = second[i];
        }
        return result;
    }

    @Override
    public int findMax(int[] source) {
        checkArguments(source);
        int m = source[0];
        for (int i = 0; i < source.length; i++) {
            if (source[i] > m) {
                m = source[i];
            }
        }
        return m;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        checkArguments(source, condition);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0, j = 0; i < source.length; i++) {
            if (condition.isValid(source[i])) {
                result.add(source[i]);
                j++;
            }
        }
        String[] r = new String[result.size()];
        return result.toArray(r);
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemove) {
        checkArguments(source, toRemove);
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(source));
        arrayList.removeAll(Arrays.asList(toRemove));
        String[] r = new String[arrayList.size()];
        return arrayList.toArray(r);
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        checkArguments(source, operation);
        for (int i = 0; i < source.length; i++) {
            source[i] = operation.map(source[i]);
        }
        return source;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        checkArguments(source, operation);
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            arrayList.addAll(Arrays.asList(operation.flatMap(source[i])));
        }
        HashSet<String> set = new HashSet<>(arrayList);
        ArrayList<String> list = new ArrayList<>(set);
        String[] r = new String[list.size()];
        list.toArray(r);
        Integer[] intArr = new Integer[r.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(r[i]);
        }
        Arrays.sort(intArr, Collections.reverseOrder());
        for (int i = 0; i < r.length; i++) {
            r[i] = String.valueOf(intArr[i]);
        }
        return r;
    }

    private void checkArguments(String[] source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkArguments(int[] source) {
        if (source == null || source.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void checkArguments(String[] first, String[] second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkArguments(String[] source, FlatMappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkArguments(String[] source, FilteringCondition operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkArguments(String[] source, MappingOperation operation) {
        if (source == null || operation == null) {
            throw new IllegalArgumentException();
        }
    }
}
