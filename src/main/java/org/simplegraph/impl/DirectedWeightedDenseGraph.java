package org.simplegraph.impl;

import java.util.List;

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
        return addSingleEdge(v1, v2, edge);
    }

    /**
     * Get the edge that goes from the first vertex to the second.
     * @param  v1   first vertex
     * @param  v2   second vertex
     * @return      the edge from v1 to v2, if it exists, null otherwise
     */
    public E getEdge(V v1, V v2) {
        return _getEdge(v1, v2);
    }

    /**
     * Get a list with the edges contained in the graph.
     * @return list of the edges
     */
    @SuppressWarnings("unchecked")
    public List<E> getEdges() {
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

    public List<V> getShortestPath(V source, V destination) {
        // TODO
        return null;
    }

    public DirectedWeightedGraph<V, E> getMinimumSpanningTree() {
        return getMinimumSpanningTree();
    }
}
