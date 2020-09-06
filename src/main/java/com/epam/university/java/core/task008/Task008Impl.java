package com.epam.university.java.core.task008;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task008Impl implements Task008 {

    @Override
    public boolean isValid(String sourceString) {
        if (sourceString == null) {
            throw new IllegalArgumentException();
        }
        if (sourceString.isEmpty()) {
            return true;
        }
        List<Character> openBrackets = new ArrayList<>(Arrays.asList('{', '[', '('));
        List<Character> closeBrackets = new ArrayList<>(Arrays.asList('}', ']', ')'));
        List<Character> myStack = new ArrayList<>();

        for (int i = 0; i < sourceString.length(); i++) {
            if (openBrackets.contains(sourceString.charAt(i))
                    || closeBrackets.contains(sourceString.charAt(i))) {
                myStack.add(sourceString.charAt(i));
            }
        }
        if (closeBrackets.contains(myStack.get(0))
                || openBrackets.contains(myStack.get(myStack.size() - 1))) {
            return false;
        }
        Character[] array = new Character[myStack.size()];
        myStack.toArray(array);
        System.out.println(Arrays.toString(array));
        List<Character> checked = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            if (openBrackets.contains(array[i])) {
                int k = openBrackets.indexOf(array[i]);
                if (closeBrackets.contains(array[i + 1])
                        && closeBrackets.indexOf(array[i + 1]) != k) {
                    return false;
                }
                for (int j = i; j < array.length; j++) {
                    if (closeBrackets.indexOf(array[j]) == k) {
                        checked.add(openBrackets.get(k));
                        checked.add(closeBrackets.get(k));
                        continue;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
        return checked.size() == array.length;
    }
}
