package org.simplegraph.impl;

import org.simplegraph.Graph;

/**
 * Dense graph implemention.
 */
public class DenseGraph<V> extends BaseUndirectedDenseGraph<V, Boolean> implements Graph<V> {
    public DenseGraph() {
        super();
    }

    public DenseGraph(int size) {
        super(size);
    }

    public DenseGraph(DenseGraph<V> graph) {
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
        return new DenseGraph<V>();
    }
}
