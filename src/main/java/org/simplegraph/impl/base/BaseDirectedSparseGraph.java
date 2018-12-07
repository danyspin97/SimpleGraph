package org.simplegraph.impl.base;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import org.simplegraph.Summable;

public abstract class BaseDirectedSparseGraph<V, E> extends BaseSparseGraph<V, E> {
    /**
     * Default constructor
     */
    public BaseDirectedSparseGraph() {
        super();
    }

    /**
     * Create a graph with a starting size.
     * @param size starting size
     */
    public BaseDirectedSparseGraph(int size) {
        super(size);
    }

    /**
     * Remove an edge that goes from the first vertex to the second.
     * @param  v1 first vertex
     * @param  v2 second vertex
     * @return    true if the graph has been changed
     */
    public boolean removeEdge(V v1, V v2) {
        return _removeEdge(v1, v2);
    }

    /**
     * Get the neighbors of a vertex, both incident and outer vertices.
     * @param  vertex the specified vertex
     * @return        the list of vertices that are neighbors of vertex
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
     * Get the number of edges in the graph.
     * @return number of edges
     */
    public int countEdges() {
        return _countEdges();
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
        for (Map.Entry<V, HashMap<V, E>> entry : edges.entrySet()) {
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
        return super.getNeighbors(vertex);
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
}
