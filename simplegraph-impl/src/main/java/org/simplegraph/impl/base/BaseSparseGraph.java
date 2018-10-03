package org.simplegraph.impl.base;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import org.simplegraph.Summable;

public class BaseSparseGraph<V, E> {
    protected static final int DEFAULT_SIZE = 15;
    protected HashMap<V, HashMap<V, E>> edges;

    /**
     * Default constructor
     */
    public BaseSparseGraph() {
        edges = new HashMap<V, HashMap<V, E>>(DEFAULT_SIZE);
    }

    /**
     * Create a graph with a starting size.
     * @param size starting size
     */
    public BaseSparseGraph(int size) {
        edges = new HashMap<V, HashMap<V, E>>(size);
    }

    /**
     * Add a vertex to the graph.
     * @param  vertex the vertex to add
     * @return        true if the the graph has been modified
     */
    public boolean addVertex(V vertex) {
        return edges.putIfAbsent(vertex, new HashMap<V, E>()) == null;
    }

    /**
     * Check the existence of a vertex in the graph.
     * @param  vertex the vertex to check
     * @return        true if the graph contains vertex
     */
    public boolean containsVertex(V vertex) {
        return edges.containsKey(vertex);
    }

    /**
     * Remove a vertex from the graph
     * @param  vertex the vertex to remove
     * @return        true if the graph has been modified
     */
    public boolean removeVertex(V vertex) {
        return edges.remove(vertex) != null;
    }

    /**
     * Get the number of vertices in the graph.
     * @return number of vertices
     */
    public int countVertices() {
        return edges.size();
    }

    protected boolean _addEdge(V v1, V v2, E edge) {
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

        edges.get(v1).put(v2, edge);

        return true;
    }

    /**
     * Check the existence of an edge that goes from the first vertex to the second.
     * @param  v1 first vertex
     * @param  v2 second vertex
     * @return    true if an edge from v1 to v2 exists
     */
    public boolean existsEdge(V v1, V v2) {
        if (!containsVertex(v1) || !containsVertex(v2)) {
            return false;
        }

        return edges.get(v1).get(v2) != null;
    }

    protected boolean _removeEdge(V v1, V v2) {
        if (!containsVertex(v1) || !containsVertex(v2)) {
            return false;
        }

        return edges.get(v1).remove(v2) != null;
    }

    /**
     * Remove an edge between two vertices.
     * @param  v1 first vertex
     * @param  v2 second vertex
     * @return    true if the graph has been changed
     */
    public boolean removeEdge(V v1, V v2) {
        return (_removeEdge(v1, v2) || _removeEdge(v2,v1));
    }

    /**
     * Get the number of edges in the graph.
     * @return number of edges
     */
    public int countEdges() {
        int count = 0;

        for (HashMap<V, E> l : edges.values()) {
            count += l.size();
        }

        return count / 2;
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

    /**
     * Get the number of neighbors for a vertex.
     * @param  vertex the spefied vertex
     * @return        number of neighbors, -1 if vertex does not exists
     */
    public int countNeighbors(V vertex) {
        if (!containsVertex(vertex)) {
            return -1;
        }

        return edges.get(vertex).size();
    }

    /**
     * Get all the vertices in the graph
     * @return a LinkedList containing all the graph vertices
     */
    public LinkedList<V> getVertices() {
        return new LinkedList<V>(edges.keySet());
    }

    public LinkedList<V> getPath(V source, V destination) {
        return new LinkedList<V>();
    }
}

