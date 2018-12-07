package org.simplegraph.impl.base;

import java.util.ArrayDeque;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import org.simplegraph.Summable;

public abstract class BaseSparseGraph<V, E> {
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
        if (vertex == null) {
            return false;
        }

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
        // null is not a valid vertex
        if (v1 == null || v2 == null || edge == null) {
            return false;
        }

        // But fail if they are the same
        if (v1.equals(v2)) {
            return false;
        }

        // If the are already connected
        if (existsEdge(v1, v2)) {
            return false;
        }

        // If the edge is the same of the one in the graph between v1 and v2
        if (edge.equals(_getEdge(v1, v2))) {
            return false;
        }

        // It's safe to add the edge
        // Add the two nodes to the graph if they don't exists
        if (!containsVertex(v1)) {
            addVertex(v1);
        }

        if (!containsVertex(v2)) {
            addVertex(v2);
        }

        edges.get(v1).put(v2, edge);

        return true;
    }

    protected E _getEdge(V v1, V v2) {
        if (!containsVertex(v1) || !containsVertex(v2)) {
            return null;
        }

        return edges.get(v1).get(v2);
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

    protected int _countEdges() {
        int count = 0;

        for (HashMap<V, E> l : edges.values()) {
            count += l.size();
        }

        return count;
    }

    /**
     * Get the number of edges in the graph.
     * @return number of edges
     */
    public int countEdges() {
        return _countEdges() / 2;
    }

    /**
     * Get the neighbors of a vertex
     * @param  vertex the specified vertex
     * @return        the list of vertices that are neighbors of vertex
     *                null if the vertex is not contained in the graph
     */
    public List<V> getNeighbors(V vertex) {
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
     * @return a list containing all the graph vertices
     */
    public List<V> getVertices() {
        return new LinkedList<V>(edges.keySet());
    }

    /**
     * Get a path between a source and a destination
     * @param source      source vertex
     * @param destination destination vertex
     * @return            a list containing the vertices that
     *                    compose the path, in order; an empty LinkedList if
     *                    there is no path, null if the source and the
     *                    destination are equals or are not contained in the
     *                    graph
     */
    public List<V> getPath(V source, V destination) {
        if (!edges.containsKey(source) || !edges.containsKey(destination)) {
            return null;
        }

        if (source.equals(destination)) {
            return null;
        }

        // Based on https://en.wikipedia.org/wiki/Breadth-first_search
        HashMap<V, V> parent = new HashMap<V, V>();
        ArrayDeque<V> queue = new ArrayDeque<V>(edges.size());
        queue.add(source);

        V current = null;

        while ((current = queue.pollFirst()) != null) {
            if (current == destination) {
                break;
            }

            for (V neighbor : edges.get(current).keySet()) {
                // if the vertex has not been already processed
                if (!parent.containsKey(neighbor)) {
                    queue.add(neighbor);
                    parent.put(neighbor, current);
                }
            }
        }

        LinkedList<V> path = new LinkedList<V>();

        if (destination.equals(current)) {
            do {
                path.addFirst(current);
            } while (!(current = parent.get(current)).equals(source));

            path.addFirst(source);
            return path;
        }

        return path;
    }

    /**
     * Does a path exists between source and destination.
     * @param source      source vertex
     * @param destination destination vertex
     * @return            true if a path exists
     */
    public boolean existsPath(V source, V destination) {
        List<V> path = getPath(source, destination);
        if (path == null) {
            return false;
        }

        return path.size() != 0;
    }
}

