package com.epam.university.java.core.task012;

import java.util.*;

public class Task012Impl implements Task012 {
    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        if (sourceGraph == null || actions == null || actions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (GraphAction action: actions) {
            action.run(sourceGraph);
        }

        return sourceGraph;
    }

    @Override
    public boolean pathExists(Graph graph, int from, int to) {
        if (graph == null) {
            throw new IllegalArgumentException();
        }
        Deque<Integer> searchQueue = new ArrayDeque<>(graph.getAdjacent(from));
        List<Integer> searched = new ArrayList<>();
        int vertex;
        while (!searchQueue.isEmpty()) {
            vertex = searchQueue.pollFirst();
            if (!searched.contains(vertex)) {
                if (vertex == to) {
                    return true;
                } else {
                    searchQueue.addAll(graph.getAdjacent(vertex));
                    searched.add(vertex);
                }
            }
        }
        return false;
    }
}
