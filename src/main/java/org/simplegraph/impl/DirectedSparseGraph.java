package org.simplegraph.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.simplegraph.DirectedGraph;
import org.simplegraph.impl.base.BaseDirectedSparseGraph;

public class DirectedSparseGraph<V> extends BaseDirectedSparseGraph<V, Boolean> implements DirectedGraph<V> {
    /**
     * Default constructor
     */
    public DirectedSparseGraph() {
        super();
    }

    /**
     * Create a graph with a starting size.
     * @param size starting size
     */
    public DirectedSparseGraph(int size) {
        super(size);
    }

    /**
     * Add an edge that goes from the first vertex to the second.
     * Add the two vertices in the graph if they don't exists.
     * @param  v1   first vertex
     * @param  v2   second vertex
     * @return      true if the graph has been modified
     */
    public boolean addEdge(V v1, V v2) {
        return addSingleEdge(v1, v2, true);
    }

    /**
     * Get the neighbors of a vertex, both incident and outer vertices.
     * @param  vertex the specified vertex
     * @return        the collection of vertices that are neighbors of vertex
     *                null if the vertex is not contained in the graph
     */
    public List<V> getNeighbors(V vertex) {
        if (!containsVertex(vertex)) {
            return null;
        }

        List<V> neighbors = getOutVertices(vertex);

        // Do not add duplicated element
        for (V v : getInVertices(vertex)) {
            if (!neighbors.contains(v)) {
                neighbors.add(v);
            }
        }

        return neighbors;
    }

    /**
     * Get the incident vertices of a vertex.
     * @param  vertex the specified vertex
     * @return        a list containing the incident vertices of vertex,
     *                null if vertex is not contained in the graph
     */
    public List<V> getInVertices(V vertex) {
        if (!containsVertex(vertex)) {
            return null;
        }

        LinkedList<V> vertices = new LinkedList<V>();

        // Get all incident vertices with vertex
        for (Map.Entry<V, HashMap<V, Boolean>> entry : edges.entrySet()) {
            if (entry.getValue().get(vertex) != null) {
                vertices.add(entry.getKey());
            }
        }

        return vertices;
    }

    /**
     * Get the outer vertices of a vertex.
     * @param  vertex the specified vertex
     * @return        a list containing the outer vertices of vertex,
     *                null if vertex is not contained in the graph
     */
    public List<V> getOutVertices(V vertex) {
        if (!containsVertex(vertex)) {
            return null;
        }

        return new LinkedList<V>(edges.get(vertex).keySet());
    }

    /**
     * Get the number of incident vertices of a vertex.
     * @param  vertex the specified vertex
     * @return        the number of incident vertices of vertex, -1 if vertex
     *                is not contained in the graph
     */
    public int getInDegree(V vertex) {
        if (!containsVertex(vertex)) {
            return -1;
        }

        return getInVertices(vertex).size();
    }

    /**
     * Get the number of outer vertices of a vertex.
     * @param  vertex the specified vertex
     * @return        the number of outer vertices of vertex, -1 if vertex
     *                is not contained in the graph
     */
    public int getOutDegree(V vertex) {
        if (!containsVertex(vertex)) {
            return -1;
        }

        return getOutVertices(vertex).size();
    }

    public DirectedGraph<V> getSpanningTree() {
        return new DirectedSparseGraph<V>();
    }
}

