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
        neighbors.addAll(getInVertices(vertex));

        return neighbors;
    }

    public LinkedList<V> getInVertices(V vertex) {
        LinkedList<V> vertices = new LinkedList<V>();

        // Get all incident vertices with vertex
        for (Map.Entry<V, LinkedList<V>> entry : edges.entrySet()) {
            if (entry.getValue().contains(vertex)) {
                vertices.add(entry.getKey());
            }
        }

        return vertices;
    }

    public LinkedList<V> getOutVertices(V vertex) {
        return edges.get(vertex);
    }

    public int getInDegree(V vertex) {
        return getInVertices(vertex).size();
    }

    public int getOutDegree(V vertex) {
        return getOutVertices(vertex).size();
    }
}

