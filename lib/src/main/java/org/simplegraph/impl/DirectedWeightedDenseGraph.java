package org.simplegraph.impl;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.simplegraph.DirectedWeightedGraph;
import org.simplegraph.impl.base.BaseDirectedDenseGraph;
import org.simplegraph.util.FibonacciHeap;
import org.simplegraph.util.Algorithms;

/**
 * Undirected graph implemention for dense graphs.
 */
public class DirectedWeightedDenseGraph<V> extends BaseDirectedDenseGraph<V, Double> implements DirectedWeightedGraph<V> {
    public DirectedWeightedDenseGraph() {
        initialize(DEFAULT_SIZE);
    }

    public DirectedWeightedDenseGraph(int size)
    {
        initialize(size);
    }

    public DirectedWeightedDenseGraph(DirectedWeightedDenseGraph<V> graph) {
        copy(graph);
    }


    /**
     * Add an edge that goes from the first vertex to the second.
     * Add the two vertices in the graph if they don't exists.
     * @param  v1     first vertex
     * @param  v2     second vertex
     * @param  weight weight to add
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
        return (DirectedWeightedDenseGraph<V>) _getSpanningTree();
    }

    public Double getMinimumDistance(V source, V destination) {
        return Algorithms.<V>getMinimumDistance(this, source, destination);
    }

    public List<V> getShortestPath(V source, V destination) {
        return Algorithms.<V>getShortestPath(this, source, destination);
    }

    public DirectedWeightedGraph<V> getMinimumSpanningTree() {
    return null;
    }
}
