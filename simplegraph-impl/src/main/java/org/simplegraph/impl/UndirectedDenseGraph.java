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

import org.simplegraph.Graph;
import org.simplegraph.impl.base.BaseUndirectedDenseGraph;

/**
 * Undirected graph implemention for dense graphs.
 */
public class UndirectedDenseGraph<V> extends BaseUndirectedDenseGraph<V, Boolean> implements Graph<V> {
    private ArrayList<Boolean> edges;

    public UndirectedDenseGraph() {
        super();
    }

    public UndirectedDenseGraph(int size) {
        super(size);
    }

    public UndirectedDenseGraph(UndirectedDenseGraph<V> graph) {
        // TODO
        // super(graph);
    }

    /**
     * Add an edge between two vertices.
     * Add the two vertices in the graph if they don't exists
     * @param  v1 first vertex
     * @param  v2 second vertex
     * @return    true if the graph has been modified
     */
    public boolean addEdge(V v1, V v2) {
        return _addEdge(v1, v2, true);
    }

    public Graph<V> getSpanningTree()
    {
        return new UndirectedDenseGraph<V>();
    }
}
