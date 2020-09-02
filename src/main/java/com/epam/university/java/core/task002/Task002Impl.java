package com.epam.university.java.core.task002;

import java.util.Arrays;

public class Task002Impl implements Task002 {
    @Override
    public boolean isEquals(String firstString, String secondString) {
        checkArguments(firstString, secondString);
        return firstString.equals(secondString);
    }

    @Override
    public String left(String sourceString, int number) {
        checkArguments(sourceString, number);
        if (number > sourceString.length()) {
            return sourceString;
        }
        return sourceString.substring(0, number);
    }

    @Override
    public String left(String sourceString, String separator) {
        checkArguments(sourceString, separator);
        return left(sourceString, sourceString.indexOf(separator));
    }

    @Override
    public String right(String sourceString, int number) {
        checkArguments(sourceString, number);
        if (number > sourceString.length()) {
            return sourceString;
        }
        return sourceString.substring(sourceString.length() - number);
    }

    @Override
    public String right(String sourceString, String separator) {
        checkArguments(sourceString, separator);
        if (!sourceString.contains(separator)) {
            return sourceString;
        }
        return right(sourceString, sourceString.indexOf(separator));
    }

    @Override
    public String[] split(String sourceString, String split) {
        checkArguments(sourceString, split);
        return sourceString.split(split);
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        checkArguments(sourceCollection, glue);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= sourceCollection.length - 2; i++) {
            sb.append(sourceCollection[i]);
            sb.append(glue);
        }
        sb.append(sourceCollection[sourceCollection.length - 1]);
        return sb.toString();
    }

    private void checkArguments(String firstString, String secondString) {
        if (firstString == null || secondString == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkArguments(String sourceString, int number) {
        if (sourceString == null || number < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void checkArguments(String[] sourceCollection, String glue) {
        if (sourceCollection == null || sourceCollection.length == 0
                || glue == null || Arrays.asList(sourceCollection).contains(null)) {
            throw new IllegalArgumentException();
        }
    }
}
