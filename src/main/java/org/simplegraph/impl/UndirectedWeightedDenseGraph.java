package org.simplegraph.impl;

import java.util.LinkedList;
import java.util.List;

import org.simplegraph.WeightedGraph;
import org.simplegraph.impl.base.BaseUndirectedDenseGraph;

/**
 * Undirected graph implemention for dense graphs.
 */
public class UndirectedWeightedDenseGraph<V, E> extends BaseUndirectedDenseGraph<V, E> implements WeightedGraph<V, E> {
    public UndirectedWeightedDenseGraph() {
        super();
    }

    public UndirectedWeightedDenseGraph(int size)
    {
        super(size);
    }

    public UndirectedWeightedDenseGraph(UndirectedWeightedSparseGraph<V, E> graph) {
        // TODO
        super(graph);
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
        return addSingleEdge(v1, v2, edge);
    }

    /**
     * Get the edge between two vertices
     * @param  v1   first vertex
     * @param  v2   second vertex
     * @return      the edge between v1 and v2, if it exists, null otherwise
     */
    public E getEdge(V v1, V v2) {
        return _getEdge(v1, v2);
    }

    /**
     * Get a list with the edges contained in the graph.
     * @return List of the edges
     */
    @SuppressWarnings("unchecked")
    public List<E> getEdges() {
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

    public List<V> getShortestPath(V source, V destination) {
        // TODO
        return null;
    }

    public WeightedGraph<V, E> getMinimumSpanningTree() {
        return getMinimumSpanningTree();
    }
}
