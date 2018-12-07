package org.simplegraph.impl;

import org.simplegraph.Graph;
import org.simplegraph.impl.base.BaseSparseGraph;

public class UndirectedSparseGraph<V> extends BaseSparseGraph<V, Boolean> implements Graph<V> {
    /**
     * Default constructor
     */
    public UndirectedSparseGraph() {
        super();
    }

    /**
     * Create a graph with a starting size.
     * @param size starting size
     */
    public UndirectedSparseGraph(int size) {
        super(size);
    }

    /**
     * Add an edge between two vertices.
     * Add the two vertices in the graph if they don't exists
     * @param  v1 first vertex
     * @param  v2 second vertex
     * @return    true if the graph has been modified
     */
    public boolean addEdge(V v1, V v2) {
        boolean a = _addEdge(v1, v2, true);
        boolean b = _addEdge(v2, v1, true);
        return a || b;
    }

    public Graph<V> getSpanningTree() {
        return new UndirectedSparseGraph<V>();
    }
}

