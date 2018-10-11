package org.simplegraph.impl;

import java.util.ArrayList;
import java.util.LinkedList;

import org.simplegraph.DirectedGraph;
import org.simplegraph.impl.base.BaseDirectedDenseGraph;

public class DirectedDenseGraph<V> extends BaseDirectedDenseGraph<V, Boolean> implements DirectedGraph<V> {
    /**
     * Default constructor
     */
    public DirectedDenseGraph() {
        initialize(DEFAULT_SIZE);
    }

    /**
     * Create a graph of a specified size
     * @param size starting size
     */
    public DirectedDenseGraph(int size) {
        initialize(size);
    }

    /**
     * Copy constructor
     * @param graph graph to copy
     */
    public DirectedDenseGraph(DirectedDenseGraph<V> graph) {
        copy(graph);
    }

    /**
     * Add an edge that goes from the first vertex to the second.
     * Add the two vertices in the graph if they don't exists.
     * @param  v1   first vertex
     * @param  v2   second vertex
     * @return      true if the graph has been modified
     */
    public boolean addEdge(V v1, V v2) {
        return _addEdge(v1, v2, true);
    }
}
