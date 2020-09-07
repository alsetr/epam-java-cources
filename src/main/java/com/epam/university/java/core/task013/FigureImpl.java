package com.epam.university.java.core.task013;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class FigureImpl implements Figure {
    private List<Vertex> figure;
    private int vertexes;

    public FigureImpl(int vertexCount) {
        figure = new ArrayList<>();
        vertexes = vertexCount;
    }

    @Override
    public void addVertex(Vertex vertex) {
        if (figure.size() >= vertexes) {
            throw new IllegalArgumentException();
        }
        figure.add(vertex);
    }

    @Override
    public Collection<Vertex> getVertexes() {
        int sumOfx = 0;
        int sumOFy = 0;
        for (Vertex v: figure) {
            sumOfx += v.getX();
            sumOFy += v.getY();
        }
        double averageX = (double) sumOfx / figure.size();
        double averageY = (double) sumOFy / figure.size();
        figure.sort(Comparator
                .comparingDouble(vertex -> Math.atan2(vertex.getY() - averageY,
                        vertex.getX() - averageX)));
        return figure;
    }
}
