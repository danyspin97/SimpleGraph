package org.simplegraph.impl;

import java.util.List;

import org.simplegraph.Graph;

/**
 * Dense graph implemention.
 */
public class DenseGraph<V> extends BaseUndirectedDenseGraph<V, Boolean> implements Graph<V> {
    public DenseGraph() {
        super();
    }

    public DenseGraph(int size) {
        super(size);
    }

    public DenseGraph(DenseGraph<V> graph) {
        copy(graph);
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
    public boolean addEdge(V v1, V v2) {
        return addSingleEdge(v1, v2, true);
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
    public Graph<V> getSpanningTree()
    {
        return new DenseGraph<V>();
    }
}
