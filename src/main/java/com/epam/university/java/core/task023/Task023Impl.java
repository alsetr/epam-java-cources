package com.epam.university.java.core.task023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task023Impl implements Task023 {
    @Override
    public String extract(String phoneString) {
        if (phoneString == null || phoneString.isEmpty()
                || phoneString.length() < 11) {
            throw new IllegalArgumentException();
        }
        Pattern pattern = Pattern.compile("[+]?\\d?.??(\\d{3})");
        Matcher matcher = pattern.matcher(phoneString);
        matcher.find();
        return matcher.group(1);
    }
}
