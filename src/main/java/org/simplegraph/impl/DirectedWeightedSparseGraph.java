package org.simplegraph.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

import org.simplegraph.DirectedWeightedGraph;
import org.simplegraph.impl.base.BaseDirectedSparseGraph;

public class DirectedWeightedSparseGraph<V, E> extends BaseDirectedSparseGraph<V, E> implements DirectedWeightedGraph<V, E> {
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
     * @param  v1   first vertex
     * @param  v2   second vertex
     * @param  edge edge to add
     * @return      true if the graph has been modified
     */
    public boolean addEdge(V v1, V v2, E edge) {
        return _addEdge(v1, v2, edge);
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
     * Get all the edges in the graph.
     * If an edge appears n times, there will be n copy of the edge in the list.
     * @return LinkedList of the edges
     */
    public LinkedList<E> getEdges() {
        LinkedList<E> t = new LinkedList<E>();

        for (HashMap<V, E> h : edges.values()) {
            t.addAll(h.values());
        }

        return t;
    }

    /**
     * Check if a vertex is the source of an edge.
     * @param  vertex the specified vertex
     * @param  edge   edge to check
     * @return        true if vertex is the source of edge
     */
    public boolean isSource(V vertex, E edge) {
        if (!containsVertex(vertex)) {
            return false;
        }

        for (Map.Entry<V, E> e : edges.get(vertex).entrySet()) {
            if (e.getValue().equals(edge)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check if a vertex is the destination of an edge.
     * @param  vertex the specified vertex
     * @param  edge   edge to check
     * @return        true if vertex is the destination of edge
     */
    public boolean isDestination(V vertex, E edge) {
        if (!containsVertex(vertex)) {
            return false;
        }

        for (HashMap<V, E> h : edges.values()) {
            E t = h.get(vertex);
            if (t != null && t.equals(edge)) {
                return true;
            }
        }

        return false;
    }

    public DirectedWeightedGraph<V, E> getSpanningTree() {
        return new DirectedWeightedSparseGraph<V, E>();
    }

    public DirectedWeightedGraph<V, E> getMinimumSpanningTree() {
        return new DirectedWeightedSparseGraph<V, E>();
    }

    public E getMinimumDistance(V source, V destination) {
        return null;
    }

    public LinkedList<V> getShortestPath(V source, V destination) {
        return null;
    }
}

