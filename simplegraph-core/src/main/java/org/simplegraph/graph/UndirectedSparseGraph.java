package org.simplegraph.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import org.simplegraph.interfaces.Graph;

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
        // Add the two nodes to the graph if they don't exists
        if (!containsVertex(v1)) {
            addVertex(v1);
        }
        if (!containsVertex(v2)) {
            addVertex(v2);
        }

        // If the are already connected
        if (existsEdge(v1, v2)) {
            return false;
        }

        edges.get(v1).put(v2, true);
        edges.get(v2).put(v1, true);

        return true;
    }

    /**
     * Remove an edge between two vertices.
     * @param  v1 first vertex
     * @param  v2 second vertex
     * @return    true if the graph has been changed
     */
    public boolean removeEdge(V v1, V v2) {
        return (super.removeEdge(v1, v2) || super.removeEdge(v2,v1));
    }

    /**
     * Get the number of edges in the graph.
     * @return number of edges
     */
    public int countEdges() {
        return super.countEdges() / 2;
    }

    /**
     * Get the neighbors of a vertex
     * @param  vertex the specified vertex
     * @return        the collection of vertices that are neighbors of vertex
     *                null if the vertex is not contained in the graph
     */
    public LinkedList<V> getNeighbors(V vertex) {
        if (!containsVertex(vertex)) {
            return null;
        }

        return new LinkedList<V>(edges.get(vertex).keySet());
    }

    public Graph<V> getSpanningTree() {
        return new UndirectedSparseGraph<V>();
    }
}

