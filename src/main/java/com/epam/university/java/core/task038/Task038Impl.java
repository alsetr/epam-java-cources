package com.epam.university.java.core.task038;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Task038Impl implements Task038 {
    Map<Integer, Map<Integer, Double>> searchGraph;
    Map<Integer, Double> costs;
    Map<Integer, Integer> parents;
    List<Integer> processed;

    @Override
    public Graph invokeActions(Graph sourceGraph, Collection<GraphAction> actions) {
        if (sourceGraph == null || actions == null || actions.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (GraphAction action : actions) {
            action.run(sourceGraph);
        }
        return sourceGraph;
    }

    @Override
    public Collection<Vertex> getShortestPath(Graph graph, int startId, int endId) {
        if (graph == null) {
            throw new IllegalArgumentException();
        }
        GraphImpl castedGraph = (GraphImpl) graph;
        searchGraph = castedGraph.getSearchGraph();
        costs = new HashMap<>();
        parents = new HashMap<>();
        processed = new ArrayList<>();
        List<Vertex> result = new ArrayList<>();
        for (Map.Entry<Integer, Double> entry : searchGraph.get(startId).entrySet()) {
            costs.put(entry.getKey(), entry.getValue());
            parents.put(entry.getKey(), startId);
        }
        if (costs.containsKey(endId)) {
            result.add(castedGraph.findVertexById(endId));
            result.add(castedGraph.findVertexById(startId));
            return result;
        }
        costs.put(endId, Double.POSITIVE_INFINITY);
        parents.put(endId, null);
        Integer node = findLowestCostNode();
        double cost;
        Set<Integer> neighbours;
        double newCost;
        while (node != null) {
            cost = costs.get(node);
            neighbours = searchGraph.get(node).keySet();
            for (Integer neighbour : neighbours) {
                newCost = cost + neighbour;
                if (costs.get(neighbour) > newCost) {
                    costs.put(neighbour, newCost);
                    parents.put(neighbour, node);
                }
            }
            processed.add(node);
            node = findLowestCostNode();
        }
        if (parents.get(endId) == null) {
            return result;
        }
        Integer currentNode = endId;
        result.add(castedGraph.findVertexById(currentNode));
        Integer parent;
        while (getParent(currentNode) != startId) {
            parent = getParent(currentNode);
            result.add(castedGraph.findVertexById(parent));
            currentNode = parent;
        }
        result.add(castedGraph.findVertexById(startId));
        return result;
    }


    private Integer findLowestCostNode() {
        double lowestCost = Double.POSITIVE_INFINITY;
        Integer lowestCostNode = null;
        double cost;
        Integer node;
        for (Map.Entry<Integer, Double> entry : costs.entrySet()) {
            cost = entry.getValue();
            node = entry.getKey();
            if (cost < lowestCost && !processed.contains(node)) {
                lowestCost = cost;
                lowestCostNode = entry.getKey();
            }
        }
        return lowestCostNode;
    }

    private Integer getParent(Integer node) {
        return parents.get(node);
    }
}
