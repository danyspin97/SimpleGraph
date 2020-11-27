package org.simplegraph.impl;

import java.util.List;

import org.simplegraph.Graph;

/**
 Sparse graph implementation.
 */
public class SparseGraph<V> extends BaseSparseGraph<V, Boolean> implements Graph<V> {
    /**
     * Default constructor
     */
    public SparseGraph() {
        super();
    }

    /**
     * Create a graph with a starting size.
     * @param size starting size
     */
    public SparseGraph(int size) {
        super(size);
    }

    @Override
    public boolean addEdge(V v1, V v2) {
        boolean a = addSingleEdge(v1, v2, true);
        boolean b = addSingleEdge(v2, v1, true);
        return a || b;
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

    public Graph<V> getSpanningTree() {
        return new SparseGraph<V>();
    }
}

