package com.epam.university.java.core.task013;

import java.util.*;

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
        List<Vertex> vertexes = new ArrayList<>(figure.getVertexes());
        myVector ab;
        myVector bc;
        myVector cd;
        double[] vectorProducts = new double[vertexes.size()];
        ab = vectorCoord(vertexes.get(0), vertexes.get(1));
        bc = vectorCoord(vertexes.get(1), vertexes.get(2));
        if (vertexes.size() == 3) {
            cd = vectorCoord(vertexes.get(2), vertexes.get(0));
        } else {
            cd = vectorCoord(vertexes.get(2), vertexes.get(3));
        }
        vectorProducts[0] = ab.x * bc.y - ab.y * bc.x;
        vectorProducts[1] = bc.x * cd.y - bc.y * cd.x;
        vectorProducts[2] = cd.x * ab.y - cd.y * ab.x;
        System.out.println(Arrays.toString(vectorProducts));


//        for (int i = 0; i < 1; i++) {
//            if (i == vertexes.size() - 1) {
//                ab = vectorCoord(vertexes.get(i), vertexes.get(0));
//            }
//            ab = vectorCoord(vertexes.get(i), vertexes.get(i + 1));
//            bc = vectorCoord(vertexes.get(i + 1), vertexes.get(i + 2));
//            double product = ab.x * bc.y - ab.y * bc.x;
//            System.out.println(product);
//        }
        return false;
    }

    private myVector vectorCoord(Vertex a, Vertex b) {
        myVector v = new myVector();
        v.x = b.getX() - a.getX();
        v.y = b.getY() - a.getY();
        return v;
    }

    private class myVector {
        private double x;
        private double y;
    }
}
