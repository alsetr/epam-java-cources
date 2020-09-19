package com.epam.university.java.core.task030;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Task030Impl implements Task030 {
    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {
        checkArguments(dateStart, dateEnd);
        return (int) ChronoUnit.DAYS.between(dateStart, dateEnd);
    }

    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {
        checkArguments(dateStart, daysToAdd);
        return dateStart.plusDays(daysToAdd);
    }

    @Override
    public long distanceBetween(Instant instantStart, Instant instantEnd) {
        checkArguments(instantStart, instantEnd);
        return ChronoUnit.SECONDS.between(instantStart, instantEnd);
    }

    @Override
    public DayOfWeek getDayOfWeek(LocalDate localDate) {
        checkArguments(localDate);
        return localDate.getDayOfWeek();
    }

    @Override
    public LocalDate getNextWeekend(LocalDate localDate) {
        checkArguments(localDate);
        if (localDate.getDayOfWeek() == DayOfWeek.SATURDAY
                || localDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return localDate;
        } else {
            int add = 5 - localDate.getDayOfWeek().ordinal();
            return localDate.plusDays(add);
        }
    }

    @Override
    public LocalTime getLocalTime(String timeString) {
        checkArguments(timeString);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mma");
        return LocalTime.parse(timeString, formatter);
    }

    private void checkArguments(Object... args) {
        if (args[0] == null) {
            throw new IllegalArgumentException();
        }
        if (args.length > 1) {
            if (args[1] == null) {
                throw new IllegalArgumentException();
            }
        }
    }
}
