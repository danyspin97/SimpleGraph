package org.simplegraph.impl;

import java.util.List;

import org.simplegraph.DirectedWeightedGraph;
import org.simplegraph.util.Algorithms;

/**
 Sparse graph implementation for directed and weighted graphs.
 */
public class DirectedWeightedSparseGraph<V> extends BaseDirectedSparseGraph<V, Double> implements DirectedWeightedGraph<V> {
    /**
     * Default constructor
     */
    public DirectedWeightedSparseGraph() {
        super();
    }

    /**
     * Create a graph with a starting size.
     * @param size starting size
     */
    public DirectedWeightedSparseGraph(int size) {
        super(size);
    }

    public DirectedWeightedSparseGraph(DirectedWeightedSparseGraph<V> graph) {
        copy(graph);
    }

    @Override
    public boolean addEdge(V v1, V v2, Double weight) {
        return addSingleEdge(v1, v2, weight);
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
    public DirectedWeightedGraph<V> getSpanningTree() {
        return new DirectedWeightedSparseGraph<V>();
    }

    @Override
    public DirectedWeightedGraph<V> getMinimumSpanningTree() {
        return new DirectedWeightedSparseGraph<V>();
    }

    @Override
    public Double getMinimumDistance(V source, V destination) {
        return Algorithms.<V>getMinimumDistance(this, source, destination);
    }

    @Override
    public List<V> getShortestPath(V source, V destination) {
        return Algorithms.<V>getShortestPath(this, source, destination);
    }
}

