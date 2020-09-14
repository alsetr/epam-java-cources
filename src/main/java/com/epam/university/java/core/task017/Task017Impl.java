package com.epam.university.java.core.task017;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Task017Impl implements Task017 {
    @Override
    public String formatString(Object... args) {
        checkArgs(args);
        StringBuilder sb = new StringBuilder();
        sb.append("You know ");
        sb.append(args[0]);
        sb.append(", ");
        sb.append(args[1]);
        sb.append("!");
        return sb.toString();
    }

    @Override
    public String formatNumbers(Object... args) {
        checkArgs(args);
        Double d = Double.parseDouble(args[0].toString());
        StringBuilder sb = new StringBuilder();
        String s1 = String.format(Locale.ENGLISH, "%.1f", d);
        String s2 = String.format(Locale.ENGLISH, "%.2f", d);
        String s3 = String.format(Locale.ENGLISH, "+%.2f", d);
        String s4 = Double.toHexString(d);
        sb.append(s1).append(", ").append(s2).append(", ").append(s3).append(", ").append(s4);
        return sb.toString();
    }

    @Override
    public String formatDates(Object... args) {
        checkArgs(args);
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.dd.MM");
        return dateFormat.format(args[0]);
    }

    private void checkArgs(Object... args) {
        if (args == null || args.length == 0
                || Arrays.asList(args).contains(null)) {
            throw new IllegalArgumentException();
        }
    }
}
