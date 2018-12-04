package org.simplegraph.impl;

import java.util.ArrayList;
import java.util.LinkedList;

import org.simplegraph.DirectedWeightedGraph;
import org.simplegraph.impl.base.BaseDirectedDenseGraph;

/**
 * Undirected graph implemention for dense graphs.
 */
public class DirectedWeightedDenseGraph<V, E> extends BaseDirectedDenseGraph<V, E> implements DirectedWeightedGraph<V, E> {
    public DirectedWeightedDenseGraph() {
        initialize(DEFAULT_SIZE);
    }

    public DirectedWeightedDenseGraph(int size)
    {
        initialize(size);
    }

    public DirectedWeightedDenseGraph(DirectedWeightedDenseGraph<V, E> graph) {
        copy(graph);
    }


    /**
     * Add an edge that goes from the first vertex to the second.
     * Add the two vertices in the graph if they don't exists.
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
        // TODO
        return null;
    }

    public boolean isSource(V vertex, E edge) {
        return checkEdge(vertex, edge, true);
    }

    public boolean isDestination(V vertex, E edge) {
        return checkEdge(vertex, edge, false);
    }

    public DirectedWeightedGraph<V, E> getSpanningTree() {
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

    public DirectedWeightedGraph<V, E> getMinimumSpanningTree() {
        return getMinimumSpanningTree();
    }
}
