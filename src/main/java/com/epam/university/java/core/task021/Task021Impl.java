package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;

import java.util.Collection;

public class Task021Impl implements Task021 {
    @Override
    public Point calculate(Collection<Point> minePositions) {
        if (minePositions == null || minePositions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        int x = 0;
        int y = 0;
        int c = minePositions.size();
        for (Point p : minePositions) {
            x += p.getX();
            y += p.getY();
        }
        Point result = new PointImpl();
        result.setX((double) x / c);
        result.setY((double) y / c);
        return result;
    }
}
