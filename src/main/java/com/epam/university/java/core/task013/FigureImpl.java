package com.epam.university.java.core.task013;

import java.util.ArrayList;
import java.util.Collection;
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
        return figure;
    }
}
