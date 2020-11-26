package org.simplegraph.impl;

import org.simplegraph.Graph;

/**
 * Dense graph implemention.
 */
public class UndirectedDenseGraph<V> extends BaseUndirectedDenseGraph<V, Boolean> implements Graph<V> {
    public UndirectedDenseGraph() {
        super();
    }

    public UndirectedDenseGraph(int size) {
        super(size);
    }

    public UndirectedDenseGraph(UndirectedDenseGraph<V> graph) {
        copy(graph);
    }

    /**
     * Add an edge between two vertices.
     * Add the two vertices in the graph if they don't exists
     * @param  v1 first vertex
     * @param  v2 second vertex
     * @return    true if the graph has been modified
     */
    public boolean addEdge(V v1, V v2) {
        return addSingleEdge(v1, v2, true);
    }

    public Graph<V> getSpanningTree()
    {
        return new UndirectedDenseGraph<V>();
    }
}
