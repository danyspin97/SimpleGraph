package org.simplegraph.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Random;
import java.util.function.UnaryOperator;
import org.simplegraph.WeightedGraph;

/**
 * Undirected graph implemention for dense graphs.
 */
public class UndirectedWeightedDenseGraph<V, E> extends BaseUndirectedDenseGraph<V, E> implements WeightedGraph<V, E> {
    protected ArrayList<E> edges;

    public UndirectedWeightedDenseGraph() {
        super();
    }

    public UndirectedWeightedDenseGraph(int size)
    {
        super(size);
    }

    public UndirectedWeightedDenseGraph(UndirectedWeightedSparseGraph<V, E> graph) {
        // TODO
        // super(graph);
    }

    /**
     * Add an edge between two vertices.
     * Add the two vertices in the graph if they don't exists
     * @param  v1   first vertex
     * @param  v2   second vertex
     * @param  edge edge to add
     * @return      true if the graph has been modified
     */
    public boolean addEdge(V v1, V v2, E edge) {
        return _addEdge(v1, v2, edge);
    }

    /**
     * Get a list with the edges contained in the graph.
     * @return LinkedList of the edges
     */
    @SuppressWarnings("unchecked")
    public LinkedList<E> getEdges() {
        return (LinkedList<E>) edges.clone();
    }

    public WeightedGraph<V, E> getSpanningTree() {
        // TODO
        return null;
    }

    public E getMinimumDistance(V source, V destination) {
        // TODO
        return null;
    }

    public LinkedList<V> getShortestPath(V source, V destination) {
        // TODO
        return null;
    }

    public WeightedGraph<V, E> getMinimumSpanningTree() {
        return getMinimumSpanningTree();
    }
}
