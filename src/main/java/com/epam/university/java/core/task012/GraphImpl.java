package com.epam.university.java.core.task012;

import java.util.*;

public class GraphImpl implements Graph {
    private Map<Integer, Set<Integer>> graph = new HashMap<>();

    public void createVertex(int i) {
        graph.put(i, new HashSet<>());
    }

    @Override
    public void createEdge(int from, int to) {
        checkArguments(from, to);
        graph.get(from).add(to);
        graph.get(to).add(from);
    }

    @Override
    public boolean edgeExists(int from, int to) {
        checkArguments(from, to);
        return graph.get(from).contains(to);
    }

    @Override
    public void removeEdge(int from, int to) {
        checkArguments(from, to);
        graph.get(from).remove(to);
        graph.get(to).remove(from);
    }

    @Override
    public Collection<Integer> getAdjacent(int from) {
        checkArguments(from);
        Set<Integer> adjacent = new HashSet<>(graph.get(from));
        for (Integer i : adjacent) {
            adjacent.addAll(graph.get(i));
        }
        return adjacent;
    }

    private void checkArguments(int from, int to) {
        if (!graph.containsKey(from) || !graph.containsKey(to)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkArguments(int from) {
        if (!graph.containsKey(from)) {
            throw new IllegalArgumentException();
        }
    }
}
