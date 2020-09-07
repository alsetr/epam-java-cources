package com.epam.university.java.core.task013;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task013Impl implements Task013 {
    @Override
    public Figure invokeActions(Figure figure, Collection<FigureAction> actions) {
        if (figure == null || actions == null || actions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (FigureAction action : actions) {
            action.run(figure);
        }
        return figure;
    }

    @Override
    public boolean isConvexPolygon(Figure figure) {
        if (figure == null) {
            throw new IllegalArgumentException();
        }
        if (figure.getVertexes().size() == 3) {
            return true;
        }
        List<Vertex> vertexes = new ArrayList<>(figure.getVertexes());
        MyVector vector1;
        MyVector vector2;
        int vertNum = vertexes.size();
        double[] vectorProducts = new double[vertexes.size()];
        for (int i = 0; i < vertNum; i++) {
            vector1 = vectorCoord(vertexes.get(i), vertexes.get(index(i + 1, vertNum)));
            vector2 = vectorCoord(vertexes.get(index(i + 1, vertNum)),
                    vertexes.get(index(i + 2, vertNum)));
            vectorProducts[i] = vector1.x * vector2.y - vector1.y * vector2.x;
        }
        boolean firstSign = isPositive(vectorProducts[0]);
        for (double d: vectorProducts) {
            if (isPositive(d) != firstSign) {
                return false;
            }
        }
        return true;
    }

    private MyVector vectorCoord(Vertex a, Vertex b) {
        MyVector v = new MyVector();
        v.x = b.getX() - a.getX();
        v.y = b.getY() - a.getY();
        return v;
    }

    private class MyVector {
        private double x;
        private double y;
    }

    private int index(int i, int length) {
        if (i >= length) {
            return i % length;
        }
        return i;
    }

    private boolean isPositive(double i) {
        return i >= 0;
    }
}
