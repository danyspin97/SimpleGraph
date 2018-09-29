package org.simplegraph.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import org.simplegraph.interfaces.Graph;

public class UndirectedSparseGraph<V> implements Graph<V> {
    private static final int DEFAULT_SIZE = 15;
    private HashMap<V, LinkedList<V>> edges;

    /**
     * Default constructor
     */
    public UndirectedSparseGraph() {
        edges = new HashMap<V, LinkedList<V>>(DEFAULT_SIZE);
    }

    /**
     * Create a graph with a starting size.
     * @param size starting size
     */
    public UndirectedSparseGraph(int size) {
        edges = new HashMap<V, LinkedList<V>>(size);
    }

    /**
     * Add a node to the vertex.
     * @param  vertex the vertex to add
     * @return        true if the the graph has been modified
     */
    public boolean addVertex(V vertex) {
        if (containsVertex(vertex)) {
            return false;
        }

        edges.put(vertex, new LinkedList<V>());
        return true;
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

        edges.get(v1).add(v2);
        edges.get(v2).add(v1);

        return true;
    }

    /**
     * Check the existence of an edge between two vertices
     * @param  v1 first vertex
     * @param  v2 second vertex
     * @return    true if an edge exists between v1 and v2
     */
    public boolean existsEdge(V v1, V v2) {
        if (!containsVertex(v1) || !containsVertex(v2)) {
            return false;
        }

        return edges.get(v1).contains(v2);
    }

    /**
     * Remove an edge between two vertices.
     * @param  v1 first vertex
     * @param  v2 second vertex
     * @return    true if the graph has been changed
     */
    public boolean removeEdge(V v1, V v2) {
        if (!containsVertex(v1) || !containsVertex(v2)) {
            return false;
        }

        edges.get(v1).remove(v2);
        return edges.get(v2).remove(v1);
    }

    /**
     * Get the number of edges in the graph.
     * @return number of edges
     */
    public int countEdges() {
        int count = 0;

        for (LinkedList<V> l : edges.values()) {
            count += l.size();
        }

        // The graph is undirected
        // we save both v1 -> v2 and v2 -> v1
        return count / 2;
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
     * Get the neighbors of a vertex
     * @param  vertex the specified vertex
     * @return        the collection of vertices that are neighbors of vertex
     *                null if the vertex is not contained in the graph
     */
    public Collection<V> getNeighbors(V vertex) {
        if (!containsVertex(vertex)) {
            return null;
        }

        return edges.get(vertex);
    }

    public Collection<V> getPath(V source, V destination) {
        return new LinkedList<V>();
    }

    public Graph<V> getSpanningTree() {
        return new UndirectedSparseGraph<V>();
    }
}

