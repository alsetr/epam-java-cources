package com.epam.university.java.core.task024;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task024Impl implements Task024 {
    @Override
    public Collection<String> getWordsCount(String source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        List<String> list = new ArrayList<>();
        if (source.isEmpty()) {
            return list;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (Character.isUpperCase(source.charAt(i))) {
                if (i != 0) {
                    list.add(sb.toString());
                }
                sb = new StringBuilder();
                sb.append(Character.toLowerCase(source.charAt(i)));
            } else {
                sb.append(source.charAt(i));
                if (i == source.length() - 1) {
                    list.add(sb.toString());
                }
            }
        }
        return list;
    }
}
