package org.simplegraph.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import org.simplegraph.interfaces.DirectedGraph;

public class DirectedSparseGraph<V> extends BaseSparseGraph<V> implements DirectedGraph<V> {
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
     * Get the neighbors of a vertex, both incident and outer vertices.
     * @param  vertex the specified vertex
     * @return        the collection of vertices that are neighbors of vertex
     *                null if the vertex is not contained in the graph
     */
    public LinkedList<V> getNeighbors(V vertex) {
        if (!containsVertex(vertex)) {
            return null;
        }

        LinkedList<V> neighbors = getOutVertices(vertex);

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
     * @return        a LinkedList containing the incident vertices of vertex,
     *                null if vertex is not contained in the graph
     */
    public LinkedList<V> getInVertices(V vertex) {
        if (!containsVertex(vertex)) {
            return null;
        }

        LinkedList<V> vertices = new LinkedList<V>();

        // Get all incident vertices with vertex
        for (Map.Entry<V, LinkedList<V>> entry : edges.entrySet()) {
            if (entry.getValue().contains(vertex)) {
                vertices.add(entry.getKey());
            }
        }

        return vertices;
    }

    /**
     * Get the outer vertices of a vertex.
     * @param  vertex the specified vertex
     * @return        a LinkedList containing the outer vertices of vertex,
     *                null if vertex is not contained in the graph
     */
    public LinkedList<V> getOutVertices(V vertex) {
        if (!containsVertex(vertex)) {
            return null;
        }

        return edges.get(vertex);
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

