package com.epam.university.java.core.task009;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        if (sourceFile == null) {
            throw new IllegalArgumentException();
        }
        HashSet<String> set = new HashSet<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(sourceFile);
            while (scanner.hasNext()) {
                String s = scanner.next();
                System.out.println(s);
                if (!s.replaceAll("\\W", "").isBlank()) {
                    set.add(s.toLowerCase().replaceAll("\\W", ""));
                }
            }
        } catch (FileNotFoundException e) {
            return null;
        } finally {
            scanner.close();
        }
        System.out.println(set);
        return set;
    }
}
