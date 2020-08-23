package com.epam.university.java.core.task003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;


public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {
        String[] strings = source.split(",");
        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].trim();
        }
        HashSet<String> set = new HashSet<>(Arrays.asList(strings));
        ArrayList<String> list = new ArrayList<>(set);
        String[] r = new String[list.size()];
        list.toArray(r);
        Arrays.sort(r, Collections.reverseOrder());
        return r;
    }
}
