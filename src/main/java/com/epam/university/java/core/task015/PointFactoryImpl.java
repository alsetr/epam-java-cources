package com.epam.university.java.core.task015;

public class PointFactoryImpl implements PointFactory {
    @Override
    public Point newInstance(double x, double y) {
        Point p = new PointImpl();
        p.setX(x);
        p.setY(y);
        return p;
    }
}
