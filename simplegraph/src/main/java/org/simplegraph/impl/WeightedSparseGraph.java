package org.simplegraph.impl;

import java.util.List;

import org.simplegraph.WeightedGraph;
import org.simplegraph.util.Algorithms;

/**
 Sparse graph implementation for weighted graph.
 */
public class WeightedSparseGraph<V> extends BaseSparseGraph<V, Double> implements WeightedGraph<V> {
    /**
     * Default constructor
     */
    public WeightedSparseGraph() {
        super();
    }

    /**
     * Create a graph with a starting size.
     * @param size starting size
     */
    public WeightedSparseGraph(int size) {
        super(size);
    }

    public WeightedSparseGraph(WeightedSparseGraph<V> graph) {
        copy(graph);
    }

    @Override
    public boolean addEdge(V v1, V v2, Double weight) {
        boolean a = addSingleEdge(v1, v2, weight);
        boolean b = addSingleEdge(v2, v1, weight);
        return a || b;
    }

    @Override
    public Double getWeight(V v1, V v2) {
        return getSingleEdge(v1, v2);
    }

    @Override
     public boolean addVertex(V vertex) {
         return super.addVertex(vertex);
     }

    @Override
    public boolean containsVertex(V vertex) {
        return super.containsVertex(vertex);
    }

    @Override
    public int countVertices() {
        return super.countVertices();
    }

    @Override
    public boolean existsPath(V source, V destination) {
        return super.existsPath(source, destination);
    }

    @Override
    public boolean existsEdge(V v1, V v2) {
        return super.existsEdge(v1, v2);
    }

    @Override
    public int countNeighbors(V vertex) {
        return super.countNeighbors(vertex);
    }

    @Override
    public List<V> getNeighbors(V vertex) {
        return super.getNeighbors(vertex);
    }

    @Override
    public List<V> getPath(V source, V destination) {
        return super.getPath(source, destination);
    }

    @Override
    public boolean removeEdge(V v1, V v2) {
        return super.removeEdge(v1, v2);
    }

    @Override
    public boolean removeVertex(V vertex) {
        return super.removeVertex(vertex);
    }

    @Override
    public List<V> getVertices() {
        return super.getVertices();
    }

    @Override
    public List<V> getShortestPath(V source, V destination) {
        return Algorithms.<V>getShortestPath(this, source, destination);
    }

    @Override
    public Double getMinimumDistance(V source, V destination) {
        return Algorithms.<V>getMinimumDistance(this, source, destination);
    }

    @Override
    public WeightedGraph<V> getSpanningTree() {
        return new WeightedSparseGraph<V>();
    }

    @Override
    public WeightedGraph<V> getMinimumSpanningTree() {
        return new WeightedSparseGraph<V>();
    }
}

