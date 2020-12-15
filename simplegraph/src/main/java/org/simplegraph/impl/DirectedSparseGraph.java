package org.simplegraph.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.simplegraph.DirectedGraph;

/**
 Sparse graph implementation for directed graphs.
 */
public class DirectedSparseGraph<V> extends BaseDirectedSparseGraph<V, Boolean> implements DirectedGraph<V> {
    /**
     * Default constructor
     */
    public DirectedSparseGraph() {
        super();
    }

    /**
     * Create a graph with a starting size.
     * @param size starting size
     */
    public DirectedSparseGraph(int size) {
        super(size);
    }

    public DirectedSparseGraph(DirectedSparseGraph<V> graph) {
        copy(graph);
    }

    @Override
    public boolean addEdge(V v1, V v2) {
        return addSingleEdge(v1, v2, true);
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
    public List<V> getNeighbors(V vertex) {
        if (!containsVertex(vertex)) {
            return null;
        }

        List<V> neighbors = getOutVertices(vertex);

        // Do not add duplicated element
        for (V v : getInVertices(vertex)) {
            if (!neighbors.contains(v)) {
                neighbors.add(v);
            }
        }

        return neighbors;
    }

    @Override
    public List<V> getInVertices(V vertex) {
        if (!containsVertex(vertex)) {
            return null;
        }

        LinkedList<V> vertices = new LinkedList<V>();

        // Get all incident vertices with vertex
        for (Map.Entry<V, HashMap<V, Boolean>> entry : edges.entrySet()) {
            if (entry.getValue().get(vertex) != null) {
                vertices.add(entry.getKey());
            }
        }

        return vertices;
    }

    @Override
    public List<V> getOutVertices(V vertex) {
        if (!containsVertex(vertex)) {
            return null;
        }

        return new LinkedList<V>(edges.get(vertex).keySet());
    }

    @Override
    public int getInDegree(V vertex) {
        if (!containsVertex(vertex)) {
            return -1;
        }

        return getInVertices(vertex).size();
    }

    @Override
    public int getOutDegree(V vertex) {
        if (!containsVertex(vertex)) {
            return -1;
        }

        return getOutVertices(vertex).size();
    }

    @Override
    public DirectedGraph<V> getSpanningTree() {
        return new DirectedSparseGraph<V>();
    }
}

