package org.simplegraph.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.simplegraph.WeightedGraph;
import org.simplegraph.impl.base.BaseSparseGraph;
import org.simplegraph.util.Algorithms;

public class UndirectedWeightedSparseGraph<V> extends BaseSparseGraph<V, Double> implements WeightedGraph<V> {
    /**
     * Default constructor
     */
    public UndirectedWeightedSparseGraph() {
        super();
    }

    /**
     * Create a graph with a starting size.
     * @param size starting size
     */
    public UndirectedWeightedSparseGraph(int size) {
        super(size);
    }

    /**
     * Add an edge between two vertices.
     * Add the two vertices in the graph if they don't exists
     * @param  v1   first vertex
     * @param  v2   second vertex
     * @param  weight edge to add
     * @return      true if the graph has been modified
     */
    public boolean addEdge(V v1, V v2, Double weight) {
        boolean a = addSingleEdge(v1, v2, weight);
        boolean b = addSingleEdge(v2, v1, weight);
        return a || b;
    }

    /**
     * Get the edge between two vertices
     * @param  v1   first vertex
     * @param  v2   second vertex
     * @return      the edge between v1 and v2, if it exists, null otherwise
     */
    public Double getWeight(V v1, V v2) {
        return getSingleEdge(v1, v2);
    }

    public List<V> getShortestPath(V source, V destination) {
        return Algorithms.<V>getShortestPath(this, source, destination);
    }

    public Double getMinimumDistance(V source, V destination) {
        return Algorithms.<V>getMinimumDistance(this, source, destination);
    }

    public WeightedGraph<V> getSpanningTree() {
        return new UndirectedWeightedSparseGraph<V>();
    }

    public WeightedGraph<V> getMinimumSpanningTree() {
        return new UndirectedWeightedSparseGraph<V>();
    }
}

