package com.epam.university.java.core.task003;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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
        //Arrays.copyOf(first,
                //first.length + second.length);
        for (int i = 0; i < second.length ; i++) {
            result[first.length + i] = second[i];
        }
        return result;
    }

    @Override
    public int findMax(int[] source) {
        checkArguments(source);
        int m = source[0];
        for (int i = 0; i < source.length ; i++) {
            if (source[i] > m) {
                m = source[i];
            }
        }
        return m;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        checkArguments(source);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0, j = 0; i < source.length ; i++) {
            if (condition.isValid(source[i])) {
                result.add(source[i]);
                j++;
            }
        }
        String[] r = new String[result.size()];
        return result.toArray(r);
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        checkArguments(source, toRemote);
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(source));
        arrayList.removeAll(Arrays.asList(toRemote));
        String[] r = new String[arrayList.size()];
        return arrayList.toArray(r);
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        checkArguments(source);
        for (int i = 0; i < source.length ; i++) {
            source[i] = operation.map(source[i]);
        }
        return source;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        checkArguments(source);
//        ArrayList<String> arrayList = new ArrayList<>();
//        for (int i = 0; i < source.length ; i++) {
//            arrayList.addAll(Arrays.asList(operation.flatMap(source[i])));
//        }
//        System.out.println(arrayList);
//        arrayList = (ArrayList<String>) Arrays.asList(operation.flatMap(arrayList.toString()));
////        arrayList.addAll(Arrays.asList(operation.flatMap(source[0])));
//        String[] r = new String[arrayList.size()];
//        System.out.println(arrayList);
//        return arrayList.toArray(r);
    }

    private void checkArguments(String[] source) {
        if (source == null){
            throw new IllegalArgumentException();
        }
    }

    private void checkArguments(int[] source) {
        if (source == null || source.length == 0){
            throw new IllegalArgumentException();
        }
    }

    private void checkArguments(String[] first, String[] second){
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
    }
}
