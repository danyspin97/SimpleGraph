package org.simplegraph.impl;

import java.util.List;

import org.simplegraph.DirectedWeightedGraph;
import org.simplegraph.util.Algorithms;

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

    /**
     * Add an edge that goes from the first vertex to the second.
     * Add the two vertices in the graph if they don't exists.
     * @param  v1     first vertex
     * @param  v2     second vertex
     * @param  weight edge to add
     * @return      true if the graph has been modified
     */
    public boolean addEdge(V v1, V v2, Double weight) {
        return addSingleEdge(v1, v2, weight);
    }

    /**
     * Get the edge that goes from the first vertex to the second.
     * @param  v1   first vertex
     * @param  v2   second vertex
     * @return      the edge from v1 to v2, if it exists, null otherwise
     */
    public Double getWeight(V v1, V v2) {
        return getSingleEdge(v1, v2);
    }

    public DirectedWeightedGraph<V> getSpanningTree() {
        return new DirectedWeightedSparseGraph<V>();
    }

    public DirectedWeightedGraph<V> getMinimumSpanningTree() {
        return new DirectedWeightedSparseGraph<V>();
    }

    public Double getMinimumDistance(V source, V destination) {
        return Algorithms.<V>getMinimumDistance(this, source, destination);
    }

    public List<V> getShortestPath(V source, V destination) {
        return Algorithms.<V>getShortestPath(this, source, destination);
    }
}

