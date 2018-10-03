package org.simplegraph.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import org.simplegraph.WeightedGraph;

public class UndirectedWeightedSparseGraph<V, E> extends BaseSparseGraph<V, E> implements WeightedGraph<V, E> {
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
     * @param  edge edge to add
     * @return      true if the graph has been modified
     */
    public boolean addEdge(V v1, V v2, E edge) {
        return _addEdge(v1, v2, edge) || _addEdge(v1, v2, edge);
    }

    /**
     * Get all the edges in the graph.
     * Each edge will be added only one time, even if it appears many times
     * @return LinkedList of the edges
     */
    public LinkedList<E> getEdges() {
        LinkedList<E> t = new LinkedList<E>();

        for (HashMap<V, E> h : edges.values()) {
            for (E e : h.values()) {
                if (!t.contains(e)) {
                    t.add(e);
                }
            }
        }

        return t;
    }

    public LinkedList<V> getShortestPath(V source, V destination) {
        return null;
    }

    public E getMinimumDistance(V source, V destination) {
        return null;
    }

    public WeightedGraph<V, E> getSpanningTree() {
        return new UndirectedWeightedSparseGraph<V, E>();
    }

    public WeightedGraph<V, E> getMinimumSpanningTree() {
        return new UndirectedWeightedSparseGraph<V, E>();
    }
}

