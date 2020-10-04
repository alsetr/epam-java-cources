package com.epam.university.java.core.task038;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphImpl implements Graph {
    private final List<Vertex> graph = new ArrayList<>();
    private final Map<Integer, Map<Integer, Double>> searchGraph = new HashMap<>();
    private final int vertexCount;

    /**
     * Graph constructor.
     * @param vertexCount - amount of Vertexes.
     */
    public GraphImpl(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    @Override
    public void createVertex(int id, int x, int y) {
        if (graph.size() == vertexCount) {
            throw new IllegalArgumentException();
        }
        graph.add(new VertexImpl(id, x, y));
        searchGraph.put(id, new HashMap<>());
    }

    @Override
    public void connectVertices(int fromId, int toId) {
        int fromX = findVertexById(fromId).getX();
        int fromY = findVertexById(fromId).getY();
        int toX = findVertexById(toId).getX();
        int toY = findVertexById(toId).getY();
        double distance = Math.sqrt(Math.pow(fromX - toX, 2) + Math.pow(fromY - toY, 2));
        searchGraph.get(fromId).put(toId, distance);
    }

    /**
     * Method that returns Vertex by its Id.
     * @param id - Id of vertex to find.
     * @return - Vertex with defined Id.
     */
    public Vertex findVertexById(int id) {
        for (Vertex v : graph) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    /**
     * Method that returns graph with connections.
     * @return - graph as Map of Integers - Id's, Double - distance between vertexes.
     */
    public Map<Integer, Map<Integer, Double>> getSearchGraph() {
        return searchGraph;
    }

}
