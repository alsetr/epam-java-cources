package com.epam.university.java.core.task038;

public class VertexImpl implements Vertex {
    private final int id;
    private final int x;
    private final int y;


    /**
     * Vertexes constructor.
     * @param id - id of Vertex.
     * @param x - X coordinate of Vertex.
     * @param y - Y coordinate of Vertex.
     */
    public VertexImpl(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

}
