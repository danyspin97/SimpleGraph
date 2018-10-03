package org.simplegraph.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import org.simplegraph.DirectedGraph;

public class DirectedDenseGraph<V> extends BaseDirectedDenseGraph<V, Boolean> implements DirectedGraph<V> {
    /**
     * Default constructor
     */
    public DirectedDenseGraph() {
        super();
    }

    /**
     * Create a graph of a specified size
     * @param size starting size
     */
    public DirectedDenseGraph(int size) {
        super(size);
    }

    /**
     * Copy constructor
     * @param graph graph to copy
     */
    public DirectedDenseGraph(DirectedDenseGraph<V> graph) {
        super(graph);
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

    /**
     * Get how many edges the graph contains.
     * @return number of edges
     */
    public int countEdges() {
        int count = 0;

        for (V vertex : verticesArray) {
            count += countNeighbors(vertex);
        }

        return 0;
    }
}
