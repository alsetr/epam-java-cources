package com.epam.university.java.core.task010;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        if (source == null) {
            throw new IllegalArgumentException();
        }
        HashMap<String, Integer> map = new HashMap<>();
        try (Scanner scanner = new Scanner(source)) {
            while (scanner.hasNext()) {
                String s = scanner.next().toLowerCase();
                s = s.replaceAll("\\W", "");
                if (s.isBlank()) {
                    continue;
                }
                if (map.containsKey(s)) {
                    int i = map.get(s) + 1;
                    map.put(s, i);
                }
                map.putIfAbsent(s, 1);

            }
        } catch (FileNotFoundException e) {
            return null;
        }
        return map;
    }
}
